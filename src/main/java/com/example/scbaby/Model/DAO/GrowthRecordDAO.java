package com.example.scbaby.Model.DAO;

import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordUpdateReq;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "growth_record")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrowthRecordDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long growthRecordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    private float height;
    private float weight;
    private float headSize;

    //기록 날짜
    private LocalDateTime dateTime;

    public void update(GrowthRecordUpdateReq growthRecordUpdateReq) {
        this.height = growthRecordUpdateReq.getHeight();
        this.weight = growthRecordUpdateReq.getWeight();
        this.headSize = growthRecordUpdateReq.getHeadSize();
        this.dateTime = growthRecordUpdateReq.getDateTime();
    }
}
