package com.example.scbaby.Model.DTO.User.Res;

import com.example.scbaby.Model.DAO.UserDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGetRes {
    private String email;
    private String name;
    private String residence;

    public static UserGetRes of(UserDAO userDAO) {
        return UserGetRes.builder()
                .email(userDAO.getEmail())
                .name(userDAO.getName())
                .residence(userDAO.getResidence()
                ).build();
    }
}
