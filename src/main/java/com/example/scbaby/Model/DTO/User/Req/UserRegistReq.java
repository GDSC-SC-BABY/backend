package com.example.scbaby.Model.DTO.User.Req;

import com.example.scbaby.Model.DAO.UserDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistReq {
    private String userId;
    private String email;
    private String name;
    private String residence;

    public UserDAO toDAO() {
        return UserDAO.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .residence(residence)
                .build();
    }
}
