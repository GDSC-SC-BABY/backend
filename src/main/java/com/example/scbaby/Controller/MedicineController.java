package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Medicine.Req.MedicineRegistReq;
import com.example.scbaby.Model.DTO.Medicine.Req.MedicineUpdateReq;
import com.example.scbaby.Model.DTO.Medicine.Res.MedicineGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.MedicineService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class MedicineController {

    private final MedicineService medicineService;

    @Operation(summary = "생활패턴에 Medicine 등록")
    @PostMapping("/medicine")
    public StateRes registerMedicine(@RequestBody @Valid MedicineRegistReq medicineRegistReq) {
        return medicineService.registerMedicine(medicineRegistReq, medicineRegistReq.getBabyId());
    }

    @Operation(summary = "Medicine 조회")
    @GetMapping("/medicine/{medicineId}")
    public MedicineGetRes getMedicineList(@PathVariable Long medicineId) {
        return medicineService.getMedicine(medicineId);
    }

    @Operation(summary = "Medicine 수정")
    @PatchMapping("/medicine/{medicineId}")
    public StateRes updateGrowthRecord(@PathVariable Long medicineId, @RequestBody @Valid MedicineUpdateReq medicineUpdateReq) {
        return medicineService.updateMedicine(medicineId, medicineUpdateReq);
    }

    @Operation(summary = "Medicine 삭제")
    @DeleteMapping("/medicine/{medicineId}")
    public StateRes deleteMedicine(@PathVariable Long medicineId) {
        return medicineService.deleteMedicine(medicineId);
    }
}
