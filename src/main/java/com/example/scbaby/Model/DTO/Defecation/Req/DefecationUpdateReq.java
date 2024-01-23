package com.example.scbaby.Model.DTO.Defecation.Req;

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
public class DefecationUpdateReq {

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private String defecationStatus;

    private String memo;
}
