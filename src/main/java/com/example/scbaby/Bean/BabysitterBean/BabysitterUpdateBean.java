package com.example.scbaby.Bean.BabysitterBean;

import com.example.scbaby.Model.DAO.BabysitterDAO;
import com.example.scbaby.Model.DTO.Babysitter.Req.BabysitterUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabysitterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BabysitterUpdateBean {
    private final BabysitterRepository babysitterRepository;

    public StateRes exec(Long babysitterId, BabysitterUpdateReq babysitterUpdateReq) {
        if (babysitterRepository.findById(babysitterId).isPresent()) {
            BabysitterDAO babysitterDAO = babysitterRepository.findById(babysitterId).get();

            babysitterDAO.update(babysitterUpdateReq.getName(), babysitterUpdateReq.getPhoneNumber(), babysitterUpdateReq.getSelfIntro(), babysitterUpdateReq.getWage(), babysitterUpdateReq.getResidence());
            return new StateRes(true);
        }
        return new StateRes(false);
    }
}
