package com.example.scbaby.Model.DTO.BabyFood.Res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyFoodListRes {
    private List<BabyFoodGetRes> babyFoodGetResList;
}
