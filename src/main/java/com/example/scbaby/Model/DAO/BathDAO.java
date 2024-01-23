package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bath")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BathDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bathId;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    // 기록 시작 시간
    private LocalDateTime startTime;

    // 기록 종료 시간
    private LocalDateTime endTime;

    private String memo;

    public void update(BabyDAO baby, LocalDateTime startTime, LocalDateTime endTime, String memo) {
        this.baby = baby;
        this.startTime = startTime;
        this.endTime = endTime;
        this.memo = memo;
    }
}
