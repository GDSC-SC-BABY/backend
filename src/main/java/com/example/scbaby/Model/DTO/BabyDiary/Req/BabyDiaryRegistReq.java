package com.example.scbaby.Model.DTO.BabyDiary.Req;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyDiaryRegistReq {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private Long babyId;

    public BabyDiaryDAO toDAO(BabyDAO babyDAO) {
        return BabyDiaryDAO.builder()
                .baby(babyDAO)
                .title(title)
                .content(content)
                .dateTime(LocalDateTime.now())
                .build();
    }
}
