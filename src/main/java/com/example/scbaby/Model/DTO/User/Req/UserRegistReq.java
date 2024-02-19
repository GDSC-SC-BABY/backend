package com.example.scbaby.Model.DTO.User.Req;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.UserDAO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistReq {
    @NotNull
    private String userId;

    @NotNull
    private String name;

    @NotNull
    private String residence;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Long babyId;

    public UserDAO toDAO(BabyDAO babyDAO) {
        return UserDAO.builder()
                .userId(userId)
                .name(name)
                .residence(residence)
                .phoneNumber(phoneNumber)
                .baby(babyDAO)
                .build();
    }
}
