package com.example.scbaby.Bean.SleepBean;

import com.example.scbaby.Model.DTO.Sleep.Res.SleepGetRes;
import com.example.scbaby.Repository.SleepRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SleepGetBean {
    private final SleepRepository sleepRepository;

    public SleepGetRes exec(Long sleepId) {
        return SleepGetRes.of(sleepRepository.findById(sleepId).orElseThrow(EntityNotFoundException::new));
    }
}
