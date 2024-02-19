package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DAO.UserDAO;
import com.example.scbaby.Model.DTO.User.Req.UserGetReq;
import com.example.scbaby.Model.DTO.User.Res.BabyIdGetRes;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetBabyIdByUserIdBean {
    private final UserRepository userRepository;
    private final BabyRepository babyRepository;

    public BabyIdGetRes exec(UserGetReq userGetReq) {
        UserDAO userDAO = userRepository.findById(userGetReq.getUserId()).orElseThrow(EntityNotFoundException::new);
        return BabyIdGetRes.of(userDAO);
    }
}
