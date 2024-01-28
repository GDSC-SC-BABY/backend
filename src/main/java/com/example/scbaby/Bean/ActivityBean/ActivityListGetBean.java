package com.example.scbaby.Bean.ActivityBean;

import com.example.scbaby.Model.DAO.*;
import com.example.scbaby.Model.DTO.Activity.Res.ActivityListGetRes;
import com.example.scbaby.Repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ActivityListGetBean {
    private final BabyRepository babyRepository;
    private final SleepRepository sleepRepository;
    private final BathRepository bathRepository;
    private final MedicineRepository medicineRepository;
    private final DefecationRepository defecationRepository;

    public List<ActivityListGetRes> exec(Long babyId, LocalDate specificDate) {
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);

        LocalDateTime startDate = specificDate.atStartOfDay();
        LocalDateTime endDate = specificDate.atTime(23, 59, 59);

        List<SleepDAO> sleepActivities = sleepRepository.findByBabyAndStartTimeBetweenOrderByStartTime(babyDAO, startDate, endDate);
        List<BathDAO> bathActivities = bathRepository.findByBabyAndStartTimeBetweenOrderByStartTime(babyDAO, startDate, endDate);
        List<MedicineDAO> medicineActivities = medicineRepository.findByBabyAndStartTimeBetweenOrderByStartTime(babyDAO, startDate, endDate);
        List<DefecationDAO> defecationActivities = defecationRepository.findByBabyAndStartTimeBetweenOrderByStartTime(babyDAO, startDate, endDate);

        List<ActivityListGetRes> allActivities = mergeAndSortActivities(sleepActivities, bathActivities, medicineActivities, defecationActivities);

        return allActivities;
    }

    private List<ActivityListGetRes> mergeAndSortActivities(List<SleepDAO> sleepActivities,
                                                     List<BathDAO> bathActivities,
                                                     List<MedicineDAO> medicineActivities,
                                                     List<DefecationDAO> defecationActivities) {
        List<ActivityListGetRes> allActivities = sleepActivities.stream()
                .map(ActivityListGetRes::fromSleepDAO)
                .collect(Collectors.toList());

        allActivities.addAll(bathActivities.stream()
                .map(ActivityListGetRes::fromBathDAO)
                .toList());

        allActivities.addAll(medicineActivities.stream()
                .map(ActivityListGetRes::fromMedicineDAO)
                .toList());

        allActivities.addAll(defecationActivities.stream()
                .map(ActivityListGetRes::fromDefecationDAO)
                .toList());

        // 정렬
        allActivities.sort((a1, a2) -> a1.getStartTime().compareTo(a2.getStartTime()));

        return allActivities;
    }
}
