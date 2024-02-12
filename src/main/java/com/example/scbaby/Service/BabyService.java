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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BabyService {
    private final BabyRegistBean babyRegistBean;
    private final BabyGetBean babyGetBean;
    private final BabyUpdateBean babyUpdateBean;

    @Transactional
    public StateRes registerBaby(BabyRegistReq babyRegistReq, MultipartFile multipartFile) throws IOException {
        return babyRegistBean.exec(babyRegistReq, multipartFile);
    }

    @Transactional(readOnly = true)
    public BabyGetRes getBaby(Long babyId) {
        return babyGetBean.exec(babyId);
    }

    @Transactional
    public StateRes updateBaby(Long babyId, BabyUpdateReq babyUpdateReq, MultipartFile multipartFile) throws IOException {
        return babyUpdateBean.exec(babyId, babyUpdateReq, multipartFile);
    }
}
