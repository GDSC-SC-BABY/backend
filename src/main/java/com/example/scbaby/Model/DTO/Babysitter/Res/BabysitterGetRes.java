package com.example.scbaby.Model.DTO.Babysitter.Res;

import com.example.scbaby.Model.DAO.BabysitterDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabysitterGetRes {
    private String name;
    private String phoneNumber;
    private String selfIntro;
    private Integer wage;
    private String residence;

    public static BabysitterGetRes of(BabysitterDAO babysitterDAO) {
        return BabysitterGetRes.builder()
                .name(babysitterDAO.getName())
                .phoneNumber(babysitterDAO.getPhoneNumber())
                .selfIntro(babysitterDAO.getSelfIntro())
                .wage(babysitterDAO.getWage())
                .residence(babysitterDAO.getResidence())
                .build();
    }
}
