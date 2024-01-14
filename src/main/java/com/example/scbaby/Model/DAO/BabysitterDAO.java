package com.example.scbaby.Model.DAO;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long babysitterId;

    private String name;
    private String phoneNumber;
    private String selfIntro;

    //활동 가능 시간, 돌볼 수 있는 아이, 지금 할 수 있는 활동 나중에 개발


    private Integer wage;
    private String residence;

    public void update(String name, String phoneNumber, String selfIntro, Integer wage, String residence) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.selfIntro = selfIntro;
        this.wage = wage;
        this.residence = residence;
    }
}
