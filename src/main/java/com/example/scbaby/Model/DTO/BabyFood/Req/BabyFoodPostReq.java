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
    private String babyId;
    private LocalDateTime dateTime;
    private float amount;
    private String imageUrl;
    private String specialNote;
    private List<BasePorridge> basePorridgeList;
    private List<Topping> toppingList;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BasePorridge {
        private String name;
        private boolean hasAllergy;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Topping {
        private String name;
        private boolean hasAllergy;
    }
}