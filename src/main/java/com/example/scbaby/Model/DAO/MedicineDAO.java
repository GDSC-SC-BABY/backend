package com.example.scbaby.Model.DAO;

import com.example.scbaby.Model.DTO.Medicine.Req.MedicineUpdateReq;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medicine")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    // 기록 시작 시간
    private LocalDateTime startTime;

    private String medicineType;

    private String memo;

    public void update(MedicineUpdateReq medicineUpdateReq) {
        this.startTime = medicineUpdateReq.getStartTime();
        this.medicineType = medicineUpdateReq.getMedicineType();
        this.memo = medicineUpdateReq.getMemo();
    }
}
