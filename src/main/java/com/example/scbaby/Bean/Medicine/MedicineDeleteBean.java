package com.example.scbaby.Bean.Medicine;

import com.example.scbaby.Model.DAO.MedicineDAO;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.MedicineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicineDeleteBean {
    private final MedicineRepository medicineRepository;

    public StateRes exec(Long medicineId) {
        MedicineDAO medicineDAO = medicineRepository.findById(medicineId).orElseThrow(EntityNotFoundException::new);
        medicineRepository.delete(medicineDAO);
        return new StateRes(true);
    }
}
