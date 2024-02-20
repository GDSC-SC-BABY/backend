package com.example.scbaby.Service;

import com.example.scbaby.Bean.UserBean.*;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Req.AddBabyReq;
import com.example.scbaby.Model.DTO.User.Req.UserGetReq;
import com.example.scbaby.Model.DTO.User.Req.UserRegistReq;
import com.example.scbaby.Model.DTO.User.Res.BabyIdGetRes;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRegistBean userRegistBean;
    private final UserGetBean userGetBean;
    private final UserDuplicateCheckBean userDuplicateCheckBean;
    private final GetBabyIdByUserIdBean getBabyIdByUserIdBean;
    private final AddBabyBean addBabyBean;

    @Transactional
    public StateRes registerUser(String userId) {
        return userRegistBean.exec(userId);
    }

    @Transactional(readOnly = true)
    public UserGetRes getUser(UserGetReq userGetReq) {
        return userGetBean.exec(userGetReq);
    }

    @Transactional(readOnly = true)
    public StateRes duplicateCheckUser(String userId) {
        return userDuplicateCheckBean.exec(userId);
    }

    @Transactional(readOnly = true)
    public BabyIdGetRes getBabyId(UserGetReq userGetReq) {
        return getBabyIdByUserIdBean.exec(userGetReq);
    }

    @Transactional(readOnly = true)
    public StateRes addBaby(AddBabyReq addBabyReq) {
        return addBabyBean.exec(addBabyReq);
    }
}
