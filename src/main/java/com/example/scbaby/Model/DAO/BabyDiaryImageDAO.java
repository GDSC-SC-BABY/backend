package com.example.scbaby.Model.DAO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "baby_diary_image")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BabyDiaryImageDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long babyDiaryImageId;

    private String imgUrl;

    private String repImgYn;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_diary_id")
    private BabyDiaryDAO babyDiaryDAO;
}
