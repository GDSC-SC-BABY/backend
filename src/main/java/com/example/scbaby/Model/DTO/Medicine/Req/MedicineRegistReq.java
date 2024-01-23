package com.example.scbaby.Model.DTO.Medicine.Req;

import com.example.scbaby.Model.DAO.MedicineDAO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineRegistReq {
    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private String medicineType;

    private String memo;

    private Long babyId;

    public MedicineDAO toDAO() {
        return MedicineDAO.builder()
                .startTime(startTime)
                .medicineType(medicineType)
                .memo(memo)
                .build();
    }
}
