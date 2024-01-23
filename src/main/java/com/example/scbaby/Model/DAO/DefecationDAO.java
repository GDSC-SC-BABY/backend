package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "defeaction")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefecationDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long defecationId;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    // 기록 시작 시간
    private LocalDateTime startTime;

    private String defecationStatus;

    private String memo;

    public void update(BabyDAO baby, LocalDateTime startTime, String defecationStatus, String memo) {
        this.baby = baby;
        this.startTime = startTime;
        this.defecationStatus = defecationStatus;
        this.memo = memo;
    }
}
