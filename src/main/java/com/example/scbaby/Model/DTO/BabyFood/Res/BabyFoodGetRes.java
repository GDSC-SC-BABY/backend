package com.example.scbaby.Model.DTO.BabyFood.Res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyFoodGetRes {
    private Long babyFoodId;
    private LocalDateTime dateTime;
    private String imageUrl;
    private float amount;
}
