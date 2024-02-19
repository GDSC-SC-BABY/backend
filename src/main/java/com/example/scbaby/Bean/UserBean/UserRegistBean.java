package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Req.UserRegistReq;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegistBean {
    private final UserRepository userRepository;
    private final BabyRepository babyRepository;

    public StateRes exec(UserRegistReq userRegistReq) {
        BabyDAO babyDAO = babyRepository.findById(userRegistReq.getBabyId()).orElseThrow(EntityNotFoundException::new);
        userRepository.save(userRegistReq.toDAO(babyDAO));
        return new StateRes(true);
    }
}
