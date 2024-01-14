package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BabyRegistBean {
    private final BabyRepository babyRepository;

    public StateRes exec(BabyRegistReq babyRegistReq) {
        babyRepository.save(babyRegistReq.toDAO());
        return new StateRes(true);
    }
}
