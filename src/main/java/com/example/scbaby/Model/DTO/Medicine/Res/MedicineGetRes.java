package com.example.scbaby.Model.DTO.Medicine.Res;

import com.example.scbaby.Model.DAO.MedicineDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineGetRes {
    private LocalDateTime startTime;

    private String medicineType;

    private String memo;

    public static MedicineGetRes of(MedicineDAO medicineDAO) {
        return MedicineGetRes.builder()
                .startTime(medicineDAO.getStartTime())
                .medicineType(medicineDAO.getMedicineType())
                .memo(medicineDAO.getMemo())
                .build();
    }
}
