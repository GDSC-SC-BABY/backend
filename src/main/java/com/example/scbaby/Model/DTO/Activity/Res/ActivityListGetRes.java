package com.example.scbaby.Model.DTO.Activity.Res;

import com.example.scbaby.Model.DAO.BathDAO;
import com.example.scbaby.Model.DAO.DefecationDAO;
import com.example.scbaby.Model.DAO.MedicineDAO;
import com.example.scbaby.Model.DAO.SleepDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityListGetRes {
    private Long activityId;
    private String activityType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String specificStatus; // 예시: defecationStatus 또는 medicineType
    private String memo;

    public static ActivityListGetRes fromDefecationDAO(DefecationDAO defecationDAO) {
        return new ActivityListGetRes(
                defecationDAO.getDefecationId(),
                "Defecation",
                defecationDAO.getStartTime(),
                null, // endTime은 DefecationDAO에 없음
                defecationDAO.getDefecationStatus(),
                defecationDAO.getMemo()
        );
    }

    public static ActivityListGetRes fromMedicineDAO(MedicineDAO medicineDAO) {
        return new ActivityListGetRes(
                medicineDAO.getMedicineId(),
                "Medicine",
                medicineDAO.getStartTime(),
                null, // endTime은 MedicineDAO에 없음
                medicineDAO.getMedicineType(),
                medicineDAO.getMemo()
        );
    }

    public static ActivityListGetRes fromBathDAO(BathDAO bathDAO) {
        return new ActivityListGetRes(
                bathDAO.getBathId(),
                "Bath",
                bathDAO.getStartTime(),
                bathDAO.getEndTime(),
                null, // specificStatus는 BathDAO에 없음
                bathDAO.getMemo()
        );
    }

    public static ActivityListGetRes fromSleepDAO(SleepDAO sleepDAO) {
        return new ActivityListGetRes(
                sleepDAO.getSleepId(),
                "Sleep",
                sleepDAO.getStartTime(),
                sleepDAO.getEndTime(),
                null, // specificStatus는 SleepDAO에 없음
                sleepDAO.getMemo()
        );
    }
}
