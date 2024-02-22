package com.example.scbaby.Bean.BabyFood;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodListRes;
import com.example.scbaby.Repository.BabyFoodRepository;
import com.example.scbaby.Repository.BabyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BabyFoodListGetByDateBean {

    private final BabyFoodRepository babyFoodRepository;
    private final BabyRepository babyRepository;


    public BabyFoodListRes exec(Long babyId, LocalDate date) {
        BabyDAO babyDAO = babyRepository.findByBabyId(babyId);
        LocalDateTime startDateTime = date.atStartOfDay();
        LocalDateTime endDateTime = date.plusDays(1).atStartOfDay();

        List<BabyFoodDAO> babyFoodList = babyFoodRepository.findByBabyAndDateTimeBetweenOrderByDateTime(babyDAO, startDateTime, endDateTime);

        List<BabyFoodGetRes> babyFoodGetResList = babyFoodList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return BabyFoodListRes.builder()
                .babyFoodGetResList(babyFoodGetResList)
                .build();
    }

    private BabyFoodGetRes convertToDto(BabyFoodDAO babyFoodDAO) {
        return BabyFoodGetRes.builder()
                .babyFoodId(babyFoodDAO.getBabyFoodId())
                .basePorridgeName(babyFoodDAO.getBasePorridgeDAOS().get(0).getBasePorridgeName())
                .dateTime(babyFoodDAO.getDateTime())
                .imageUrl(babyFoodDAO.getImageUrl())
                .amount(babyFoodDAO.getAmount())
                .build();
    }
}

