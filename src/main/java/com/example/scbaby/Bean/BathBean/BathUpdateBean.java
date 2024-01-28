package com.example.scbaby.Bean.BathBean;

import com.example.scbaby.Model.DAO.BathDAO;
import com.example.scbaby.Model.DTO.Bath.Req.BathUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BathRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BathUpdateBean {
    private final BathRepository bathRepository;

    public StateRes exec(Long bathId, BathUpdateReq bathUpdateReq) {
            BathDAO bathDAO = bathRepository.findById(bathId).orElseThrow(EntityNotFoundException::new);

            bathDAO.update(bathDAO.getBaby(),
                                    bathUpdateReq.getStartTime(),
                                    bathUpdateReq.getEndTime(),
                                    bathUpdateReq.getMemo());

            return new StateRes(true);
        }
}
