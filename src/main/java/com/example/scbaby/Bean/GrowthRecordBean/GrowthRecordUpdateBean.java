package com.example.scbaby.Bean.GrowthRecordBean;

import com.example.scbaby.Model.DAO.GrowthRecordDAO;
import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.GrowthRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GrowthRecordUpdateBean {

    private final GrowthRecordRepository growthRecordRepository;

    public StateRes exec(Long growthRecordId, GrowthRecordUpdateReq growthRecordUpdateReq) {
        if (growthRecordRepository.findById(growthRecordId).isPresent()) {
            GrowthRecordDAO growthRecordDAO = growthRecordRepository.findById(growthRecordId).get();

            growthRecordDAO.update(growthRecordUpdateReq.getHeight(), growthRecordUpdateReq.getWeight(), growthRecordUpdateReq.getHeadSize(), growthRecordUpdateReq.getDateTime());
            return new StateRes(true);
        }
        return new StateRes(false);
    }
}
