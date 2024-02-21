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

    private String imageUri;

    private String relation;

    public UserDAO toDAO() {
        return UserDAO.builder()
                .userId(userId)
                .name(name)
                .imageUri(imageUri)
                .relation(relation)
                .build();
    }
}
