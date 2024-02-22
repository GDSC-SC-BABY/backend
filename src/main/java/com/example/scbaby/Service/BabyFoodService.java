package com.example.scbaby.Service;

import com.example.scbaby.Bean.BabyFood.BabyFoodGetBean;
import com.example.scbaby.Bean.BabyFood.BabyFoodListGetBean;
import com.example.scbaby.Bean.BabyFood.BabyFoodListGetByDateBean;
import com.example.scbaby.Bean.BabyFood.BabyFoodPostBean;
import com.example.scbaby.Model.DTO.BabyFood.Req.BabyFoodPostReq;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodDetailGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodListRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BabyFoodService {
    private final BabyFoodListGetBean babyFoodListGetBean;
    private final BabyFoodListGetByDateBean babyFoodListGetByDateBean;
    private final BabyFoodGetBean babyFoodGetBean;
    private final BabyFoodPostBean babyFoodPostBean;


    @Transactional(readOnly = true)
    public BabyFoodListRes getListBabyFoodList(Integer pageNo, Integer pageSize, Long babyId) {
        return babyFoodListGetBean.exec(pageNo, pageSize, babyId);
    }

    @Transactional(readOnly = true)
    public BabyFoodListRes getListBabyFoodListByDate(Long babyId, String date) {
        LocalDate specificDate = LocalDate.parse(date);
        return babyFoodListGetByDateBean.exec(babyId, specificDate);
    }

    @Transactional
    public BabyFoodDetailGetRes getBabyFood(Long babyFoodId) {
        return babyFoodGetBean.exec(babyFoodId);
    }

    @Transactional
    public StateRes postBabyFood(BabyFoodPostReq babyFoodPostReq) {
        return babyFoodPostBean.exec(babyFoodPostReq);
    }
}
