package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "growth_record")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrowthRecordDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long growthRecordId;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    private float height;
    private float weight;
    private float headSize;

    //기록 날짜
    private LocalDateTime dateTime;
}
