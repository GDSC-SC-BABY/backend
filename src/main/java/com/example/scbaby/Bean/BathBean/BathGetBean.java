package com.example.scbaby.Bean.BathBean;

import com.example.scbaby.Model.DTO.Bath.Res.BathGetRes;
import com.example.scbaby.Repository.BathRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BathGetBean {
    private final BathRepository bathRepository;

    public BathGetRes exec(Long bathId) {
        return BathGetRes.of(bathRepository.findById(bathId).orElseThrow(EntityNotFoundException::new));
    }
}
