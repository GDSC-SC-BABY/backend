package com.example.scbaby.Model.DTO.Defecation.Req;

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
public class DefecationUpdateReq {

    @NotNull
    @PastOrPresent
    private LocalDateTime startTime;

    private String memo;
}
