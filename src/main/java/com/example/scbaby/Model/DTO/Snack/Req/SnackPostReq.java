package com.example.scbaby.Model.DTO.Snack.Req;

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
public class SnackPostReq {
    private Long babyId;
    private LocalDateTime dateTime;
    private float amount;
    private String imageUrl;
    private String specialNote;
    private List<Beverage> beverageList;
    private List<Topping> toppingList;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Beverage {
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
