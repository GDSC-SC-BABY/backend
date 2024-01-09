package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "babysitter")
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


    private Integer Wage;
    private String residence;

}
