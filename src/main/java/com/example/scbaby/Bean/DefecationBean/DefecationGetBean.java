package com.example.scbaby.Bean.DefecationBean;

import com.example.scbaby.Model.DTO.Defecation.Res.DefecationGetRes;
import com.example.scbaby.Repository.DefecationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefecationGetBean {
    private final DefecationRepository defecationRepository;

    public DefecationGetRes exec(Long defecationId) {
        return DefecationGetRes.of(defecationRepository.findById(defecationId).orElseThrow(EntityNotFoundException::new));
    }
}
