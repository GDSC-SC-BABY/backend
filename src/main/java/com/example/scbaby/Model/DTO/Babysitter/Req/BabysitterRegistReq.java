package com.example.scbaby.Model.DTO.Babysitter.Req;

import com.example.scbaby.Model.DAO.BabysitterDAO;
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
public class BabysitterRegistReq {
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

    public BabysitterDAO toDAO() {
        return BabysitterDAO.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .selfIntro(selfIntro)
                .wage(wage)
                .residence(residence)
                .build();
    }
}
