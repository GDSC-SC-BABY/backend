package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DAO.UserDAO;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Req.AddBabyReq;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddBabyBean {
    private final UserRepository userRepository;
    private final BabyRepository babyRepository;

    public StateRes exec(AddBabyReq addBabyReq) {
        UserDAO userDAO = userRepository.findById(addBabyReq.getUserId()).get();

        userDAO.setBaby(babyRepository.findByBabyCode(addBabyReq.getBabyCode()));

        userRepository.save(userDAO);

        return new StateRes(true);
    }
}
