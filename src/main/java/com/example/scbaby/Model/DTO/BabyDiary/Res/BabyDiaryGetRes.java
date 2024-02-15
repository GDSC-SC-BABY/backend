package com.example.scbaby.Model.DTO.BabyDiary.Res;

import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import com.example.scbaby.Model.DAO.BabyDiaryImageDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyDiaryGetRes {
    private Long babyDiaryId;
    private String title;
    private String content;
    private LocalDateTime dateTime;
    private List<BabyDiaryImageDAO> imageList;

    public static BabyDiaryGetRes of(BabyDiaryDAO babyDiaryDAO, List<BabyDiaryImageDAO> babyDiaryImageDAOS) {
        return BabyDiaryGetRes.builder()
                .babyDiaryId(babyDiaryDAO.getBabyDiaryId())
                .title(babyDiaryDAO.getTitle())
                .content(babyDiaryDAO.getContent())
                .dateTime(babyDiaryDAO.getDateTime())
                .imageList(babyDiaryImageDAOS)
                .build();
    }
}
