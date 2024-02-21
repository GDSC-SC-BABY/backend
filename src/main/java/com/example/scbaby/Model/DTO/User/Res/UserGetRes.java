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
    private String name;
    private String imageUri;
    private String relation;

    public static UserGetRes of(UserDAO userDAO) {
        return UserGetRes.builder()
                .name(userDAO.getName())
                .imageUri(userDAO.getImageUri())
                .relation(userDAO.getRelation())
                .build();
    }
}
