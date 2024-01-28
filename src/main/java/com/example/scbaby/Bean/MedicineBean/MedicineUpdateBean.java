package com.example.scbaby.Bean.MedicineBean;

import com.example.scbaby.Model.DAO.MedicineDAO;
import com.example.scbaby.Model.DTO.Medicine.Req.MedicineUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.MedicineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MedicineUpdateBean {
    private final MedicineRepository medicineRepository;

    public StateRes exec(Long medicineId, MedicineUpdateReq medicineUpdateReq) {
            MedicineDAO MedicineDAO = medicineRepository.findById(medicineId).orElseThrow(EntityNotFoundException::new);

            MedicineDAO.update(MedicineDAO.getBaby(),
                                    medicineUpdateReq.getStartTime(),
                                    medicineUpdateReq.getMedicineType(),
                                    medicineUpdateReq.getMemo());

            return new StateRes(true);
        }
}
