package com.example.scbaby.Service;

import com.example.scbaby.Bean.BabyFood.BabyFoodGetBean;
import com.example.scbaby.Bean.BabyFood.BabyFoodListGetBean;
import com.example.scbaby.Bean.BabyFood.BabyFoodPostBean;
import com.example.scbaby.Model.DTO.BabyFood.Req.BabyFoodPostReq;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodDetailGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodListRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BabyFoodService {
    private final BabyFoodListGetBean babyFoodListGetBean;
    private final BabyFoodGetBean babyFoodGetBean;
    private final BabyFoodPostBean babyFoodPostBean;

    public BabyFoodListRes getListBabyFoodList(Integer pageNo, Integer pageSize, String babyId) {
        return babyFoodListGetBean.exec(pageNo, pageSize, babyId);
    }

    public BabyFoodDetailGetRes getBabyFood(Long babyFoodId) {
        return babyFoodGetBean.exec(babyFoodId);
    }

    public StateRes postBabyFood(BabyFoodPostReq babyFoodPostReq) {
        return babyFoodPostBean.exec(babyFoodPostReq);
    }
}
