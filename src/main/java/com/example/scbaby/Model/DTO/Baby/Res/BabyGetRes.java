package com.example.scbaby.Model.DTO.Baby.Res;

import com.example.scbaby.Model.DAO.BabyDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyGetRes {

    private Long babyId;

    private String name;

    private String gender;

    private LocalDateTime dateTime;

    private String imageUrl;

    private String birthHeight;

    private String birthWeight;

    private String babyCode;

    public static BabyGetRes of(BabyDAO babyDAO) {
        return BabyGetRes.builder()
                .babyId(babyDAO.getBabyId())
                .name(babyDAO.getName())
                .gender(babyDAO.getGender())
                .dateTime(babyDAO.getDateTime())
                .imageUrl(babyDAO.getImageUrl())
                .birthHeight(babyDAO.getBirthHeight())
                .birthWeight(babyDAO.getBirthWeight())
                .babyCode(babyDAO.getBabyCode())
                .build();
    }
}
