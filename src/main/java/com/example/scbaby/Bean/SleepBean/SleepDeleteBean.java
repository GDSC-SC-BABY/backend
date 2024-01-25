package com.example.scbaby.Bean.SleepBean;

import com.example.scbaby.Model.DAO.SleepDAO;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.SleepRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SleepDeleteBean {
    private final SleepRepository sleepRepository;

    public StateRes exec(Long sleepId) {
        SleepDAO sleepDAO = sleepRepository.findById(sleepId).orElseThrow(EntityNotFoundException::new);
        sleepRepository.delete(sleepDAO);
        return new StateRes(true);
    }
}
