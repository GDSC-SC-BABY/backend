package com.example.scbaby.Model.DTO.GrowthRecord.Req;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.GrowthRecordDAO;
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
public class GrowthRecordRegistReq {

    @NotNull
    private Long babyId;

    @NotNull
    private float height;

    @NotNull
    private float weight;

    @NotNull
    private float headSize;

    @NotNull
    @PastOrPresent
    private LocalDateTime dateTime;


    public GrowthRecordDAO toDAO(BabyDAO babyDAO) {
        return GrowthRecordDAO.builder()
                .height(height)
                .weight(weight)
                .headSize(headSize)
                .dateTime(dateTime)
                .baby(babyDAO)
                .build();
    }
}
