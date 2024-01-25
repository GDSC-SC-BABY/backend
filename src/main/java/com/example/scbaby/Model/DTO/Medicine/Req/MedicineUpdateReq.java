package com.example.scbaby.Model.DTO.Medicine.Req;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineUpdateReq {

    @NotNull
    @PastOrPresent
    private LocalDateTime startTime;

    @NotNull
    private String medicineType;

    private String memo;
}
