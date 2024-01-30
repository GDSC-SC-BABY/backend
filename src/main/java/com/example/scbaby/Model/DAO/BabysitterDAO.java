package com.example.scbaby.Model.DAO;

import com.example.scbaby.Model.DTO.Babysitter.Req.BabysitterUpdateReq;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "babysitter")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabysitterDAO {
    @Id
    private String babysitterId;

    private String name;
    private String phoneNumber;
    private String selfIntro;

    //활동 가능 시간, 돌볼 수 있는 아이, 지금 할 수 있는 활동 나중에 개발


    private Integer wage;
    private String residence;

    public void update(BabysitterUpdateReq babysitterUpdateReq) {
        this.babysitterId = babysitterUpdateReq.getBabysitterId();
        this.name = babysitterUpdateReq.getName();
        this.phoneNumber = babysitterUpdateReq.getPhoneNumber();
        this.selfIntro = babysitterUpdateReq.getSelfIntro();
        this.wage = babysitterUpdateReq.getWage();
        this.residence = babysitterUpdateReq.getResidence();
    }
}
