package com.example.scbaby.Bean.SleepBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.SleepDAO;
import com.example.scbaby.Model.DTO.Sleep.Req.SleepRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.SleepRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SleepRegistBean {
    private final SleepRepository sleepRepository;
    private final BabyRepository babyRepository;

    public StateRes exec(SleepRegistReq sleepRegistReq, Long babyId) {
        SleepDAO sleepDAO = sleepRegistReq.toDAO();
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);
        sleepDAO.setBaby(babyDAO);

        sleepRepository.save(sleepDAO);
        return new StateRes(true);
    }
}
