package com.example.scbaby.Model.DTO.Babysitter.Req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabysitterUpdateReq {
    @NotBlank
    private String babysitterId;
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String selfIntro;
    @NotNull
    private Integer wage;
    @NotBlank
    private String residence;
}
