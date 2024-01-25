package com.example.scbaby.Service;

import com.example.scbaby.Bean.MedicineBean.MedicineDeleteBean;
import com.example.scbaby.Bean.MedicineBean.MedicineGetBean;
import com.example.scbaby.Bean.MedicineBean.MedicineRegistBean;
import com.example.scbaby.Bean.MedicineBean.MedicineUpdateBean;
import com.example.scbaby.Model.DTO.Medicine.Req.MedicineRegistReq;
import com.example.scbaby.Model.DTO.Medicine.Req.MedicineUpdateReq;
import com.example.scbaby.Model.DTO.Medicine.Res.MedicineGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRegistBean medicineRegistBean;
    private final MedicineGetBean medicineGetBean;
    private final MedicineUpdateBean medicineUpdateBean;
    private final MedicineDeleteBean medicineDeleteBean;

    @Transactional
    public StateRes registerMedicine(MedicineRegistReq medicineRegistReq, Long babyId) {
        return medicineRegistBean.exec(medicineRegistReq, babyId);
    }

    @Transactional(readOnly = true)
    public MedicineGetRes getMedicine(Long medicineId) {
        return medicineGetBean.exec(medicineId);
    }

    @Transactional
    public StateRes updateMedicine(Long medicineId, MedicineUpdateReq medicineUpdateReq) {
        return medicineUpdateBean.exec(medicineId, medicineUpdateReq);
    }

    @Transactional
    public StateRes deleteMedicine(Long medicineId) {
        return medicineDeleteBean.exec(medicineId);
    }
}
