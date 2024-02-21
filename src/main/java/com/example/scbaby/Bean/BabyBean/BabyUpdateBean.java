package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class BabyUpdateBean {
    private final BabyRepository babyRepository;

    public StateRes exec(Long babyId, BabyUpdateReq babyUpdateReq) throws IOException {
        if (babyRepository.findById(babyId).isPresent()) {
            BabyDAO babyDAO = babyRepository.findById(babyId).get();

            babyDAO.update(babyUpdateReq);
            return new StateRes(true);
        }
        return new StateRes(false);
    }
}
