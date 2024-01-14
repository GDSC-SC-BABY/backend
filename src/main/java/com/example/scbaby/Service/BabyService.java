package com.example.scbaby.Service;

import com.example.scbaby.Bean.BabyBean.BabyGetBean;
import com.example.scbaby.Bean.BabyBean.BabyRegistBean;
import com.example.scbaby.Bean.BabyBean.BabyUpdateBean;
import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.Baby.Res.BabyGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BabyService {
    private final BabyRegistBean babyRegistBean;
    private final BabyGetBean babyGetBean;
    private final BabyUpdateBean babyUpdateBean;

    @Transactional
    public StateRes registerBaby(BabyRegistReq babyRegistReq) {
        return babyRegistBean.exec(babyRegistReq);
    }

    @Transactional(readOnly = true)
    public BabyGetRes getBaby(String babyId) {
        return babyGetBean.exec(babyId);
    }

    @Transactional
    public StateRes updateBaby(String babyId, BabyUpdateReq babyUpdateReq) {
        return babyUpdateBean.exec(babyId, babyUpdateReq);
    }
}
