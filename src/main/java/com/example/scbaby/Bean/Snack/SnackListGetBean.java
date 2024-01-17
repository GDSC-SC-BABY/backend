package com.example.scbaby.Bean.Snack;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DAO.SnackDAO;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodListRes;
import com.example.scbaby.Model.DTO.Snack.Res.SnackGetRes;
import com.example.scbaby.Model.DTO.Snack.Res.SnackListRes;
import com.example.scbaby.Repository.BabyFoodRepository;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.SnackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SnackListGetBean {
    private final SnackRepository snackRepository;
    private final BabyRepository babyRepository;

    public SnackListRes exec(Integer pageNo, Integer pageSize, String babyId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BabyDAO babyDAO = babyRepository.findByBabyId(babyId);
        Page<SnackDAO> page = snackRepository.findByBaby(pageable, babyDAO);

        List<SnackGetRes> snackListRes = page.getContent().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return SnackListRes.builder()
                .snackGetResList(snackListRes)
                .build();
    }

    private SnackGetRes convertToDto(SnackDAO snackDAO) {
        return SnackGetRes.builder()
                .snackId(snackDAO.getSnackId())
                .dateTime(snackDAO.getDateTime())
                .amount(snackDAO.getAmount())
                .imageUrl(snackDAO.getImageUrl())
                .build();
    }
}
