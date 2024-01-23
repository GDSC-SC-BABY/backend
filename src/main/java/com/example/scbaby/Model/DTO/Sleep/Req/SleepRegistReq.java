package com.example.scbaby.Model.DTO.Sleep.Req;

import com.example.scbaby.Model.DAO.SleepDAO;
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
public class SleepRegistReq {
    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    private String memo;

    private Long babyId;

    public SleepDAO toDAO() {
        return SleepDAO.builder()
                .startTime(startTime)
                .endTime(endTime)
                .memo(memo)
                .build();
    }
}
