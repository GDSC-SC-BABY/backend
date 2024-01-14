package com.example.scbaby.Model.DTO.GrowthRecord.Req;

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
public class GrowthRecordUpdateReq {

    @NotNull
    private float height;

    @NotNull
    private float weight;

    @NotNull
    private float headSize;

    @NotNull
    private LocalDateTime dateTime;
}
