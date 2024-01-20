package com.example.scbaby.Model.DTO.Baby.Req;

import com.example.scbaby.Model.DAO.BabyDAO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private Long babyId;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotNull
    private LocalDateTime dateTime;

    @NotBlank
    private String imageUrl;

    @NotNull
    private float birthHeight;

    @NotNull
    private float birthWeight;

    public BabyDAO toDAO() {
        return BabyDAO.builder()
                .name(name)
                .gender(gender)
                .dateTime(dateTime)
                .imageUrl(imageUrl)
                .birthHeight(birthHeight)
                .birthWeight(birthWeight)
                .build();
    }
}
