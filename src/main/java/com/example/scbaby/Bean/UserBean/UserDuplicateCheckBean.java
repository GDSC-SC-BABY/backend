package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDuplicateCheckBean {
    private final UserRepository userRepository;

    public StateRes exec(String userId) {
        if (userRepository.findById(userId).isPresent()) {
            return new StateRes(true);
        } else {
            return new StateRes(false);
        }
    }
}
