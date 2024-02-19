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
public class BabyIdGetRes {
    private Long babyId;

    public static BabyIdGetRes of(UserDAO userDAO) {
        return BabyIdGetRes.builder()
                .babyId(userDAO.getBaby().getBabyId())
                .build();
    }
}
