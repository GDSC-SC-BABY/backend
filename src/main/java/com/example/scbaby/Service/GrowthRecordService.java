package com.example.scbaby.Service;

import com.example.scbaby.Bean.GrowthRecordBean.GrowthRecordGetBean;
import com.example.scbaby.Bean.GrowthRecordBean.GrowthRecordRegistBean;
import com.example.scbaby.Bean.GrowthRecordBean.GrowthRecordUpdateBean;
import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordRegistReq;
import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordUpdateReq;
import com.example.scbaby.Model.DTO.GrowthRecord.Res.PageResponseDto;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GrowthRecordService {

    private final GrowthRecordRegistBean growthRecordRegistBean;
    private final GrowthRecordGetBean growthRecordGetBean;
    private final GrowthRecordUpdateBean growthRecordUpdateBean;

    @Transactional
    public StateRes registerGrowthRecord(GrowthRecordRegistReq growthRecordRegistReq, String babyId) {
        return growthRecordRegistBean.exec(growthRecordRegistReq, babyId);
    }

    @Transactional(readOnly = true)
    public PageResponseDto getGrowthRecord(int pageNo, int pageSize, String babyId) {
        return growthRecordGetBean.exec(pageNo, pageSize, babyId);
    }

    @Transactional
    public StateRes updateGrowthRecord(Long growthRecordId, GrowthRecordUpdateReq growthRecordUpdateReq) {
        return growthRecordUpdateBean.exec(growthRecordId, growthRecordUpdateReq);
    }
}
