package com.example.scbaby.Model.DTO.Defecation.Res;

import com.example.scbaby.Model.DAO.DefecationDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefecationGetRes {
    private LocalDateTime startTime;

    private String defecationStatus;

    private String memo;

    public static DefecationGetRes of(DefecationDAO defecationDAO) {
        return DefecationGetRes.builder()
                .startTime(defecationDAO.getStartTime())
                .defecationStatus(defecationDAO.getDefecationStatus())
                .memo(defecationDAO.getMemo())
                .build();
    }
}
