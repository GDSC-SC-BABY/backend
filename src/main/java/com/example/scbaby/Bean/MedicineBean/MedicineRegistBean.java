package com.example.scbaby.Bean.MedicineBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.MedicineDAO;
import com.example.scbaby.Model.DTO.Medicine.Req.MedicineRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.MedicineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicineRegistBean {
    private final MedicineRepository medicineRepository;
    private final BabyRepository babyRepository;

    public StateRes exec(MedicineRegistReq medicineRegistReq, Long babyId) {
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);
        MedicineDAO medicineDAO = medicineRegistReq.toDAO(babyDAO);

        medicineRepository.save(medicineDAO);
        return new StateRes(true);
    }
}
