package com.example.scbaby.Service;

import com.example.scbaby.Bean.BabysitterBean.BabysitterGetBean;
import com.example.scbaby.Bean.BabysitterBean.BabysitterRegistBean;
import com.example.scbaby.Bean.BabysitterBean.BabysitterUpdateBean;
import com.example.scbaby.Model.DTO.Babysitter.Req.BabysitterRegistReq;
import com.example.scbaby.Model.DTO.Babysitter.Req.BabysitterUpdateReq;
import com.example.scbaby.Model.DTO.Babysitter.Res.BabysitterGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BabysitterService {
    private final BabysitterRegistBean babysitterRegistBean;
    private final BabysitterGetBean babysitterGetBean;
    private final BabysitterUpdateBean babysitterUpdateBean;

    @Transactional
    public StateRes registerBabysitter(BabysitterRegistReq babysitterRegistReq) {
        return babysitterRegistBean.exec(babysitterRegistReq);
    }

    @Transactional(readOnly = true)
    public BabysitterGetRes getBabysitter(String babysitterId) {
        return babysitterGetBean.exec(babysitterId);
    }

    @Transactional
    public StateRes updateBabysitter(String babysitterId, BabysitterUpdateReq babysitterUpdateReq) {
        return babysitterUpdateBean.exec(babysitterId, babysitterUpdateReq);
    }
}
