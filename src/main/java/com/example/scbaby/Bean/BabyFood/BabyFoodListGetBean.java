package com.example.scbaby.Bean.BabyFood;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodListRes;
import com.example.scbaby.Repository.BabyFoodRepository;
import com.example.scbaby.Repository.BabyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BabyFoodListGetBean {
    private final BabyFoodRepository babyFoodRepository;
    private final BabyRepository babyRepository;

    public BabyFoodListRes exec(Integer pageNo, Integer pageSize, Long babyId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        BabyDAO babyDAO = babyRepository.findByBabyId(babyId);
        Page<BabyFoodDAO> page = babyFoodRepository.findByBaby(pageable, babyDAO);

        List<BabyFoodGetRes> babyFoodGetRes = page.getContent().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return BabyFoodListRes.builder()
                .babyFoodGetResList(babyFoodGetRes)
                .build();
    }

    private BabyFoodGetRes convertToDto(BabyFoodDAO babyFoodDAO) {
        return BabyFoodGetRes.builder()
                .babyFoodId(babyFoodDAO.getBabyFoodId())
                .dateTime(babyFoodDAO.getDateTime())
                .amount(babyFoodDAO.getAmount())
                .imageUrl(babyFoodDAO.getImageUrl())
                .build();
    }
}
