package com.example.scbaby.Service;

import com.example.scbaby.Bean.DefecationBean.DefecationDeleteBean;
import com.example.scbaby.Bean.DefecationBean.DefecationGetBean;
import com.example.scbaby.Bean.DefecationBean.DefecationRegistBean;
import com.example.scbaby.Bean.DefecationBean.DefecationUpdateBean;
import com.example.scbaby.Model.DTO.Defecation.Req.DefecationRegistReq;
import com.example.scbaby.Model.DTO.Defecation.Req.DefecationUpdateReq;
import com.example.scbaby.Model.DTO.Defecation.Res.DefecationGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefecationService {
    private final DefecationRegistBean defecationRegistBean;
    private final DefecationGetBean defecationGetBean;
    private final DefecationUpdateBean defecationUpdateBean;
    private final DefecationDeleteBean defecationDeleteBean;

    @Transactional
    public StateRes registerDefecation(DefecationRegistReq defecationRegistReq, Long babyId) {
        return defecationRegistBean.exec(defecationRegistReq, babyId);
    }

    @Transactional(readOnly = true)
    public DefecationGetRes getDefecation(Long defecationId) {
        return defecationGetBean.exec(defecationId);
    }

    @Transactional
    public StateRes updateDefecation(Long defecationId, DefecationUpdateReq defecationUpdateReq) {
        return defecationUpdateBean.exec(defecationId, defecationUpdateReq);
    }

    @Transactional
    public StateRes deleteDefecation(Long defecationId) {
        return defecationDeleteBean.exec(defecationId);
    }
}
