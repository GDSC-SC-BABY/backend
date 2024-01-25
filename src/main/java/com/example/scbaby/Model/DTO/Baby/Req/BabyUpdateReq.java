package com.example.scbaby.Model.DTO.Baby.Req;

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
public class BabyUpdateReq {
    @NotBlank
    private String babyId;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotNull
    @PastOrPresent
    private LocalDateTime dateTime;

    @NotBlank
    private String imageUrl;

    @NotNull
    private float birthHeight;

    @NotNull
    private float birthWeight;
}
