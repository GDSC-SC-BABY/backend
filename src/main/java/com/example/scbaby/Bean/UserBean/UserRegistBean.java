package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Req.UserRegistReq;
import com.example.scbaby.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegistBean {
    private final UserRepository userRepository;

    public StateRes exec(UserRegistReq userRegistrationReq) {
        userRepository.save(userRegistrationReq.toDAO());
        return new StateRes(true);
    }
}
