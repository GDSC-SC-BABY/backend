package com.example.scbaby.Bean.Snack;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.SnackDAO;
import com.example.scbaby.Model.DTO.Snack.Res.SnackGetRes;
import com.example.scbaby.Model.DTO.Snack.Res.SnackListRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.SnackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SnackListGetByDateBean {
    private final SnackRepository snackRepository;
    private final BabyRepository babyRepository;

    public SnackListRes exec(Long babyId, LocalDate date) {
        BabyDAO babyDAO = babyRepository.findByBabyId(babyId);
        LocalDateTime startDateTime = date.atStartOfDay();
        LocalDateTime endDateTime = date.plusDays(1).atStartOfDay();

        List<SnackDAO> snackList = snackRepository.findByBabyAndDateTimeBetweenOrderByDateTime(babyDAO, startDateTime, endDateTime);

        List<SnackGetRes> snackGetResList = snackList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return SnackListRes.builder()
                .snackGetResList(snackGetResList)
                .build();
    }

    private SnackGetRes convertToDto(SnackDAO snackDAO) {
        return SnackGetRes.builder()
                .snackId(snackDAO.getSnackId())
                .dateTime(snackDAO.getDateTime())
                .imageUrl(snackDAO.getImageUrl())
                .amount(snackDAO.getAmount())
                .build();
    }
}
