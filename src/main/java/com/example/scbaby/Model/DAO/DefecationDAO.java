package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "defeaction")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefecationDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long defecationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    // 기록 시작 시간
    private LocalDateTime startTime;

    private String memo;

    public void update(BabyDAO baby, LocalDateTime startTime, String memo) {
        this.baby = baby;
        this.startTime = startTime;
        this.memo = memo;
    }
}
