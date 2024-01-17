package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "babies")
@Getter
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

    //아기 성별
    private String gender;

    //출생일
    private LocalDateTime dateTime;

    //프로필 이미지 URL
    private String imageUrl;

    //출생 키, 몸무게
    private float birthHeight;
    private float birthWeight;

    @OneToMany(mappedBy = "baby")
    private List<GrowthRecordDAO> growthRecordDAOS;

    public void update(String babyId, String name, String gender, LocalDateTime dateTime, String imageUrl, float birthHeight, float birthWeight) {
        this.babyId = babyId;
        this.name = name;
        this.gender = gender;
        this.dateTime = dateTime;
        this.imageUrl = imageUrl;
        this.birthHeight = birthHeight;
        this.birthWeight = birthWeight;
    }

    @OneToMany(mappedBy = "baby")
    private List<BabyFoodDAO> babyFoodDAOS;

    @OneToMany(mappedBy = "baby")
    private List<SnackDAO> snackDAOS;
}