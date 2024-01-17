package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BabyUpdateBean {

    private final BabyRepository babyRepository;

    public StateRes exec(Long babyId, BabyUpdateReq babyUpdateReq) {
        if (babyRepository.findById(babyId).isPresent()) {
            BabyDAO babyDAO = babyRepository.findById(babyId).get();

            babyDAO.update(babyUpdateReq.getName(), babyUpdateReq.getGender(), babyUpdateReq.getDateTime(), babyUpdateReq.getImageUrl(), babyUpdateReq.getBirthHeight(), babyUpdateReq.getBirthWeight());
            return new StateRes(true);
        }
        return new StateRes(false);
    }
}
