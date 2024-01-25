package com.example.scbaby.Bean.DefecationBean;

import com.example.scbaby.Model.DAO.DefecationDAO;
import com.example.scbaby.Model.DTO.Defecation.Req.DefecationUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.DefecationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DefecationUpdateBean {

    private final DefecationRepository defecationRepository;

    public StateRes exec(Long defecationId, DefecationUpdateReq defecationUpdateReq) {
            DefecationDAO DefecationDAO = defecationRepository.findById(defecationId).orElseThrow(EntityNotFoundException::new);

            DefecationDAO.update(DefecationDAO.getBaby(),
                                    defecationUpdateReq.getStartTime(),
                                    defecationUpdateReq.getDefecationStatus(),
                                    defecationUpdateReq.getMemo());

            return new StateRes(true);
        }
}
