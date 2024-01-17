package com.example.scbaby.Model.DTO.GrowthRecord.Req;

import com.example.scbaby.Model.DAO.GrowthRecordDAO;
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
public class GrowthRecordRegistReq {
    @NotNull
    private float height;

    @NotNull
    private float weight;

    @NotNull
    private float headSize;

    @NotNull
    private LocalDateTime dateTime;

    private Long babyId;

    public GrowthRecordDAO toDAO() {
        return GrowthRecordDAO.builder()
                .height(height)
                .weight(weight)
                .headSize(headSize)
                .dateTime(dateTime)
                .build();
    }
}
