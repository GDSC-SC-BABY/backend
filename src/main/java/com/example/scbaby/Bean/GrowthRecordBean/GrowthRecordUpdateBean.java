package com.example.scbaby.Bean.GrowthRecordBean;

import com.example.scbaby.Model.DAO.GrowthRecordDAO;
import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.GrowthRecordRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GrowthRecordUpdateBean {
    private final GrowthRecordRepository growthRecordRepository;

    public StateRes exec(Long growthRecordId, GrowthRecordUpdateReq growthRecordUpdateReq) {
            GrowthRecordDAO growthRecordDAO = growthRecordRepository.findById(growthRecordId).orElseThrow(EntityNotFoundException::new);

            growthRecordDAO.update(growthRecordUpdateReq);
            return new StateRes(true);
        }
}
