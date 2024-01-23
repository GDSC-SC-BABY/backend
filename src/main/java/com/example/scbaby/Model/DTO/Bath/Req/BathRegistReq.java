package com.example.scbaby.Model.DTO.Bath.Req;

import com.example.scbaby.Model.DAO.BathDAO;
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
public class BathRegistReq {
    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    private String memo;

    private Long babyId;

    public BathDAO toDAO() {
        return BathDAO.builder()
                .startTime(startTime)
                .endTime(endTime)
                .memo(memo)
                .build();
    }
}
