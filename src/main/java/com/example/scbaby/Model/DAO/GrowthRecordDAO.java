package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "growth_record")
@Getter
@Setter
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

    public void update(float height, float weight, float headSize, LocalDateTime dateTime) {
        this.height = height;
        this.weight = weight;
        this.headSize = headSize;
        this.dateTime = dateTime;
    }
}
