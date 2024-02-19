package com.example.scbaby.Model.DTO.User.Req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBabyReq {
    private String userId;
    private String babyCode;
}
