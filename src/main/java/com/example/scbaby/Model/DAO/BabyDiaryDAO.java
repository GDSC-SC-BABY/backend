package com.example.scbaby.Model.DAO;

import com.example.scbaby.Model.DTO.BabyDiary.Req.BabyDiaryUpdateReq;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "baby_diary")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BabyDiaryDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long babyDiaryId;
    private String title;
    private String content;
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    @OneToMany(mappedBy = "babyDiaryDAO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BabyDiaryImageDAO> babyDiaryImageDAOS;

    public void update(BabyDiaryUpdateReq babyDiaryUpdateReq) {
        this.title = babyDiaryUpdateReq.getTitle();
        this.content = babyDiaryUpdateReq.getContent();
        this.dateTime = LocalDateTime.now();
    }
}
