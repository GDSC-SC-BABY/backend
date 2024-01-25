package com.example.scbaby.Model.DTO.GrowthRecord.Res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrowthRecordListRes {
    private float height;
    private float weight;
    private float headSize;
    private LocalDateTime dateTime;
}
