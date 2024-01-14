package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import com.example.scbaby.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGetBean {
    private final UserRepository userRepository;

    public UserGetRes exec(String userId) {
        return UserGetRes.of(userRepository.findById(userId).get());
    }
}
