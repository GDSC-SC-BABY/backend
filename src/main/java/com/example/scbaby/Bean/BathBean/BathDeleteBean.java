package com.example.scbaby.Bean.BathBean;

import com.example.scbaby.Model.DAO.BathDAO;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BathRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BathDeleteBean {
    private final BathRepository bathRepository;

    public StateRes exec(Long bathId) {
        BathDAO bathDAO = bathRepository.findById(bathId).orElseThrow(EntityNotFoundException::new);
        bathRepository.delete(bathDAO);
        return new StateRes(true);
    }
}
