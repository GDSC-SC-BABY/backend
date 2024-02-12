package com.example.scbaby.Bean.DefecationBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.DefecationDAO;
import com.example.scbaby.Model.DTO.Defecation.Req.DefecationRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.DefecationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefecationRegistBean {
    private final DefecationRepository defecationRepository;
    private final BabyRepository babyRepository;

    public StateRes exec(DefecationRegistReq defecationRegistReq, Long babyId) {
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);
        DefecationDAO defecationDAO = defecationRegistReq.toDAO(babyDAO);

        defecationRepository.save(defecationDAO);
        return new StateRes(true);
    }
}
