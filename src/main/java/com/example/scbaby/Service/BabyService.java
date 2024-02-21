package com.example.scbaby.Service;

import com.example.scbaby.Bean.BabyBean.BabyGetBean;
import com.example.scbaby.Bean.BabyBean.BabyRegistBean;
import com.example.scbaby.Bean.BabyBean.BabyUpdateBean;
import com.example.scbaby.Bean.BabyBean.GetParentsBean;
import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.Baby.Res.BabyGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyService {
    private final BabyRegistBean babyRegistBean;
    private final BabyGetBean babyGetBean;
    private final BabyUpdateBean babyUpdateBean;
    private final GetParentsBean getParentsBean;

    @Transactional
    public StateRes registerBaby(BabyRegistReq babyRegistReq) throws IOException {
        return babyRegistBean.exec(babyRegistReq);
    }

    @Transactional(readOnly = true)
    public BabyGetRes getBaby(Long babyId) {
        return babyGetBean.exec(babyId);
    }

    @Transactional
    public StateRes updateBaby(Long babyId, BabyUpdateReq babyUpdateReq) throws IOException {
        return babyUpdateBean.exec(babyId, babyUpdateReq);
    }

    @Transactional(readOnly = true)
    public List<UserGetRes> getParents(Long babyId) {
        return getParentsBean.exec(babyId);
    }
}
