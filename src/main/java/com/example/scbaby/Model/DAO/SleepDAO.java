package com.example.scbaby.Model.DAO;

import com.example.scbaby.Model.DTO.Sleep.Req.SleepUpdateReq;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sleep")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SleepDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sleepId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    // 기록 시작 시간
    private LocalDateTime startTime;

    // 기록 종료 시간
    private LocalDateTime endTime;

    private String memo;

    public void update(SleepUpdateReq sleepUpdateReq) {
        this.startTime = sleepUpdateReq.getStartTime();
        this.endTime = sleepUpdateReq.getEndTime();
        this.memo = sleepUpdateReq.getMemo();
    }
}
