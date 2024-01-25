package com.example.scbaby.Bean.BathBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BathDAO;
import com.example.scbaby.Model.DTO.Bath.Req.BathRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.BathRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BathRegistBean {

    private final BathRepository bathRepository;
    private final BabyRepository babyRepository;

    public StateRes exec(BathRegistReq bathRegistReq, Long babyId) {
        BathDAO bathDAO = bathRegistReq.toDAO();
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);
        bathDAO.setBaby(babyDAO);

        bathRepository.save(bathDAO);
        return new StateRes(true);
    }
}
