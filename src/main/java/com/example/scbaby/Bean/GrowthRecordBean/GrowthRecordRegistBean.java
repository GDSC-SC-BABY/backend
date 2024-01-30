package com.example.scbaby.Bean.GrowthRecordBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.GrowthRecordDAO;
import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.GrowthRecordRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GrowthRecordRegistBean {
    private final GrowthRecordRepository growthRecordRepository;
    private final BabyRepository babyRepository;

    public StateRes exec(GrowthRecordRegistReq growthRecordRegistReq, Long babyId) {
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);
        GrowthRecordDAO growthRecordDAO = growthRecordRegistReq.toDAO(babyDAO);

        growthRecordRepository.save(growthRecordDAO);
        return new StateRes(true);
    }
}
