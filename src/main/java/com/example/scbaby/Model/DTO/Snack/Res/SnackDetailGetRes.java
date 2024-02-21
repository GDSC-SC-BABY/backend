package com.example.scbaby.Model.DTO.Snack.Res;

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
public class SnackDetailGetRes {
    private LocalDateTime dateTime;
    private String SpecialNote;
    private float amount;
    private String imageUrl;
    private List<Topping> toppingList;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Topping {
        private String name;
        private boolean hasAllergy;
    }
}
