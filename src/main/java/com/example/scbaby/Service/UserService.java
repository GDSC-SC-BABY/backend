package com.example.scbaby.Service;

import com.example.scbaby.Bean.UserBean.UserGetBean;
import com.example.scbaby.Bean.UserBean.UserRegistBean;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Req.UserRegistReq;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRegistBean userRegistBean;
    private final UserGetBean userGetBean;

    @Transactional
    public StateRes registerUser(UserRegistReq userRegistReq) {
        return userRegistBean.exec(userRegistReq);
    }

    @Transactional
    public UserGetRes getUser(String userId) {
        return userGetBean.exec(userId);
    }
}
