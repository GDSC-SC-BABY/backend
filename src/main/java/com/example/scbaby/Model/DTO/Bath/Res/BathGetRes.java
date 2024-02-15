package com.example.scbaby.Model.DTO.Bath.Res;

import com.example.scbaby.Model.DAO.BathDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BathGetRes {
    private Long bathId;
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String memo;

    public static BathGetRes of(BathDAO bathDAO) {
        return BathGetRes.builder()
                .bathId(bathDAO.getBathId())
                .startTime(bathDAO.getStartTime())
                .endTime(bathDAO.getEndTime())
                .memo(bathDAO.getMemo())
                .build();
    }
}
