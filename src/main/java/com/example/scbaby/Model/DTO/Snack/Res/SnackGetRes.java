package com.example.scbaby.Model.DTO.Snack.Res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnackGetRes {
    private Long snackId;
    private LocalDateTime dateTime;
    private String imageUrl;
    private float amount;
}
