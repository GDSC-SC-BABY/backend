package com.example.scbaby.Bean.Medicine;

import com.example.scbaby.Model.DTO.Medicine.Res.MedicineGetRes;
import com.example.scbaby.Repository.MedicineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicineGetBean {
    private final MedicineRepository medicineRepository;

    public MedicineGetRes exec(Long medicineId) {
        return MedicineGetRes.of(medicineRepository.findById(medicineId).orElseThrow(EntityNotFoundException::new));
    }
}
