package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medicine")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    // 기록 시작 시간
    private LocalDateTime startTime;

    private String medicineType;

    private String memo;

    public void update(BabyDAO baby, LocalDateTime startTime, String medicineType, String memo) {
        this.baby = baby;
        this.startTime = startTime;
        this.medicineType = medicineType;
        this.memo = memo;
    }
}
