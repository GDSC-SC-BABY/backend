package com.example.scbaby.Bean.DefecationBean;

import com.example.scbaby.Model.DAO.DefecationDAO;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.DefecationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefecationDeleteBean {
    private final DefecationRepository defecationRepository;

    public StateRes exec(Long defecationId) {
        DefecationDAO defecationDAO = defecationRepository.findById(defecationId).orElseThrow(EntityNotFoundException::new);
        defecationRepository.delete(defecationDAO);
        return new StateRes(true);
    }
}
