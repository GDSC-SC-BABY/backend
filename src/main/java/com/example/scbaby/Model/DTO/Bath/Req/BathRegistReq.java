package com.example.scbaby.Model.DTO.Bath.Req;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BathDAO;
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
public class BathRegistReq {
    @NotNull
    @PastOrPresent
    private LocalDateTime startTime;

    @NotNull
    @PastOrPresent
    private LocalDateTime endTime;

    private String memo;

    private Long babyId;

    public BathDAO toDAO(BabyDAO babyDAO) {
        return BathDAO.builder()
                .startTime(startTime)
                .endTime(endTime)
                .memo(memo)
                .baby(babyDAO)
                .build();
    }
}
