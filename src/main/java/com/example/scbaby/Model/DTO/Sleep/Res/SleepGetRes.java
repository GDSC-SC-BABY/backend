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
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String memo;

    public static SleepGetRes of(SleepDAO sleepDAO) {
        return SleepGetRes.builder()
                .startTime(sleepDAO.getStartTime())
                .endTime(sleepDAO.getEndTime())
                .memo(sleepDAO.getMemo())
                .build();
    }
}
