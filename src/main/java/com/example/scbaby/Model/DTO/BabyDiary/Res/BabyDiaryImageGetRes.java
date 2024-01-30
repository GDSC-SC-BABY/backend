package com.example.scbaby.Model.DTO.BabyDiary.Res;

import com.example.scbaby.Model.DAO.BabyDiaryImageDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyDiaryImageGetRes {
    private String imgUrl;

    private String repImgYn;

    public static BabyDiaryImageGetRes of(BabyDiaryImageDAO babyDiaryImageDAO) {
        return BabyDiaryImageGetRes.builder()
                .imgUrl(babyDiaryImageDAO.getImgUrl())
                .repImgYn(babyDiaryImageDAO.getRepImgYn())
                .build();
    }
}
