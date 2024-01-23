package com.example.scbaby.Service;

import com.example.scbaby.Bean.BathBean.BathDeleteBean;
import com.example.scbaby.Bean.BathBean.BathGetBean;
import com.example.scbaby.Bean.BathBean.BathRegistBean;
import com.example.scbaby.Bean.BathBean.BathUpdateBean;
import com.example.scbaby.Model.DTO.Bath.Req.BathRegistReq;
import com.example.scbaby.Model.DTO.Bath.Req.BathUpdateReq;
import com.example.scbaby.Model.DTO.Bath.Res.BathGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BathService {

    private final BathRegistBean bathRegistBean;
    private final BathGetBean bathGetBean;
    private final BathUpdateBean bathUpdateBean;
    private final BathDeleteBean bathDeleteBean;

    @Transactional
    public StateRes registerBath(BathRegistReq bathRegistReq, Long babyId) {
        return bathRegistBean.exec(bathRegistReq, babyId);
    }

    @Transactional(readOnly = true)
    public BathGetRes getBath(Long bathId) {
        return bathGetBean.exec(bathId);
    }

    @Transactional
    public StateRes updateBath(Long bathId, BathUpdateReq bathUpdateReq) {
        return bathUpdateBean.exec(bathId, bathUpdateReq);
    }

    @Transactional
    public StateRes deleteBath(Long bathId) {
        return bathDeleteBean.exec(bathId);
    }
}
