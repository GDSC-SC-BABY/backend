package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Model.DTO.Baby.Res.BabyGetRes;
import com.example.scbaby.Repository.BabyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BabyGetBean {
    private final BabyRepository babyRepository;

    public BabyGetRes exec(Long babyId) {
        return BabyGetRes.of(babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new));
    }
}
