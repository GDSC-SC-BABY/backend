package com.example.scbaby.Model.DTO.Baby.Req;

import com.example.scbaby.Model.DAO.BabyDAO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyRegistReq {
    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotBlank
    private String imgUrl;

    @NotNull
    @PastOrPresent
    private LocalDateTime dateTime;

    @NotNull
    private String birthHeight;

    @NotNull
    private String birthWeight;

    @NotNull
    private String userId;


    public BabyDAO toDAO(String babyCode) {
        return BabyDAO.builder()
                .name(name)
                .gender(gender)
                .dateTime(dateTime)
                .imageUrl(imgUrl)
                .birthHeight(birthHeight)
                .birthWeight(birthWeight)
                .babyCode(babyCode)
                .build();
    }
}
