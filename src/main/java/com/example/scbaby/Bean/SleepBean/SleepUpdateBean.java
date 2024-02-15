package com.example.scbaby.Bean.SleepBean;

import com.example.scbaby.Model.DAO.SleepDAO;
import com.example.scbaby.Model.DTO.Sleep.Req.SleepUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.SleepRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SleepUpdateBean {
    private final SleepRepository sleepRepository;

    public StateRes exec(Long sleepId, SleepUpdateReq sleepUpdateReq) {
            SleepDAO sleepDAO = sleepRepository.findById(sleepId).orElseThrow(EntityNotFoundException::new);

            sleepDAO.update(sleepUpdateReq);
            return new StateRes(true);
        }
}
