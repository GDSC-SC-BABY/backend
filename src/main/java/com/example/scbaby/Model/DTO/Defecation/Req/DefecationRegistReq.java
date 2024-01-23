package com.example.scbaby.Model.DTO.Defecation.Req;

import com.example.scbaby.Model.DAO.DefecationDAO;
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
public class DefecationRegistReq {
    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private String defecationStatus;

    private String memo;

    private Long babyId;

    public DefecationDAO toDAO() {
        return DefecationDAO.builder()
                .startTime(startTime)
                .defecationStatus(defecationStatus)
                .memo(memo)
                .build();
    }
}
