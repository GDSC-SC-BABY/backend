package com.example.scbaby.Model.DTO.Defecation.Req;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.DefecationDAO;
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
public class DefecationRegistReq {
    @NotNull
    @PastOrPresent
    private LocalDateTime startTime;

    private String memo;

    private Long babyId;

    public DefecationDAO toDAO(BabyDAO babyDAO) {
        return DefecationDAO.builder()
                .startTime(startTime)
                .memo(memo)
                .baby(babyDAO)
                .build();
    }
}
