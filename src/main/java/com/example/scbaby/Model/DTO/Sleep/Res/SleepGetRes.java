package com.example.scbaby.Model.DTO.Sleep.Res;

import com.example.scbaby.Model.DAO.SleepDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SleepGetRes {
    private Long sleepId;
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String memo;

    public static SleepGetRes of(SleepDAO sleepDAO) {
        return SleepGetRes.builder()
                .sleepId(sleepDAO.getSleepId())
                .startTime(sleepDAO.getStartTime())
                .endTime(sleepDAO.getEndTime())
                .memo(sleepDAO.getMemo())
                .build();
    }
}
