package com.example.scbaby.Model.DAO;

import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long babyId;

    @OneToMany(mappedBy = "baby")
    private List<UserDAO> userDAOS;

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

    private String babyCode;

    @OneToMany(mappedBy = "baby")
    private List<GrowthRecordDAO> growthRecordDAOS;

    @OneToMany(mappedBy = "baby")
    private List<SleepDAO> sleepDAOS;

    @OneToMany(mappedBy = "baby")
    private List<BathDAO> bathDAOS;

    @OneToMany(mappedBy = "baby")
    private List<MedicineDAO> medicineDAOS;

    @OneToMany(mappedBy = "baby")
    private List<DefecationDAO> defecationDAOS;

    @OneToMany(mappedBy = "baby")
    private List<BabyDiaryDAO> babyDiaryDAOS;

    public void update(BabyUpdateReq babyUpdateReq) {
        this.name = babyUpdateReq.getName();
        this.gender = babyUpdateReq.getGender();
        this.dateTime = babyUpdateReq.getDateTime();
        this.imageUrl = babyUpdateReq.getImageUrl();
        this.birthHeight = babyUpdateReq.getBirthHeight();
        this.birthWeight = babyUpdateReq.getBirthWeight();
    }

    @OneToMany(mappedBy = "baby")
    private List<BabyFoodDAO> babyFoodDAOS;

    @OneToMany(mappedBy = "baby")
    private List<SnackDAO> snackDAOS;
}
