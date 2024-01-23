package com.example.scbaby.Service;

import com.example.scbaby.Bean.SleepBean.SleepDeleteBean;
import com.example.scbaby.Bean.SleepBean.SleepGetBean;
import com.example.scbaby.Bean.SleepBean.SleepRegistBean;
import com.example.scbaby.Bean.SleepBean.SleepUpdateBean;
import com.example.scbaby.Model.DTO.Sleep.Req.SleepRegistReq;
import com.example.scbaby.Model.DTO.Sleep.Req.SleepUpdateReq;
import com.example.scbaby.Model.DTO.Sleep.Res.SleepGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SleepService {

    private final SleepRegistBean sleepRegistBean;
    private final SleepGetBean sleepGetBean;
    private final SleepUpdateBean sleepUpdateBean;
    private final SleepDeleteBean sleepDeleteBean;

    @Transactional
    public StateRes registerSleep(SleepRegistReq sleepRegistReq, Long babyId) {
        return sleepRegistBean.exec(sleepRegistReq, babyId);
    }

    @Transactional(readOnly = true)
    public SleepGetRes getSleep(Long sleepId) {
        return sleepGetBean.exec(sleepId);
    }

    @Transactional
    public StateRes updateSleep(Long sleepId, SleepUpdateReq sleepUpdateReq) {
        return sleepUpdateBean.exec(sleepId, sleepUpdateReq);
    }

    @Transactional
    public StateRes deleteSleep(Long sleepId) {
        return sleepDeleteBean.exec(sleepId);
    }
}
