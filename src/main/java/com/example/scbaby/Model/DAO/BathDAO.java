package com.example.scbaby.Model.DAO;

import com.example.scbaby.Model.DTO.Bath.Req.BathUpdateReq;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bath")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BathDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bathId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    // 기록 시작 시간
    private LocalDateTime startTime;

    // 기록 종료 시간
    private LocalDateTime endTime;

    private String memo;

    public void update(BathUpdateReq bathUpdateReq) {
        this.startTime = bathUpdateReq.getStartTime();
        this.endTime = bathUpdateReq.getEndTime();
        this.memo = bathUpdateReq.getMemo();
    }
}
