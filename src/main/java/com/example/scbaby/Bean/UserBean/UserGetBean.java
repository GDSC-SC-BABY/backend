package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DAO.UserDAO;
import com.example.scbaby.Model.DTO.User.Req.UserGetReq;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import com.example.scbaby.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGetBean {
    private final UserRepository userRepository;

    public UserGetRes exec(UserGetReq userGetReq) {
        UserDAO userDAO = userRepository.findById(userGetReq.getUserId()).orElseThrow(EntityNotFoundException::new);
        return UserGetRes.of(userDAO);
    }
}
