package com.example.scbaby.Model.DTO.BabyFood.Req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyFoodPostReq {
    private Long babyId;
    private LocalDateTime dateTime;
    private float amount;
    private String imageUrl;
    private String specialNote;
    private String basePorridgeName;
    private List<Topping> toppingList;


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Topping {
        private String name;
        private float amount;
    }
}
