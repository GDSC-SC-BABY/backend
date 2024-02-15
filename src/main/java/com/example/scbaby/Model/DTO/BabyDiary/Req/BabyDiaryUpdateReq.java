package com.example.scbaby.Model.DTO.BabyDiary.Req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyDiaryUpdateReq {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private List<Long> babyDiaryImgIds;
}
