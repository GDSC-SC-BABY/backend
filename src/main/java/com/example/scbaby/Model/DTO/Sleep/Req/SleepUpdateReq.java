package com.example.scbaby.Model.DTO.Sleep.Req;

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
public class SleepUpdateReq {

    @NotNull
    @PastOrPresent
    private LocalDateTime startTime;

    @NotNull
    @PastOrPresent
    private LocalDateTime endTime;

    private String memo;
}
