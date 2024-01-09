package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "babies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyDAO {
    @Id
    private String babyId;

    @OneToMany(mappedBy = "baby")
    private List<BabyUserLinkDAO> babyUserLinkDAOS;

    //아기 이름
    private String name;

    //출생일
    @Column(updatable = false)
    private LocalDateTime dateTime;

    //프로필 이미지 URL
    private String imageUrl;

    //출생 키, 몸무게
    private float brithHeight;
    private float brithWeight;

    @OneToMany(mappedBy = "baby")
    private List<GrowthRecordDAO> growthRecordDAOS;
}
