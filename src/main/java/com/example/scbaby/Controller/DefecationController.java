package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Defecation.Req.DefecationRegistReq;
import com.example.scbaby.Model.DTO.Defecation.Req.DefecationUpdateReq;
import com.example.scbaby.Model.DTO.Defecation.Res.DefecationGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.DefecationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class DefecationController {
    private final DefecationService defecationService;

    @Operation(summary = "생활패턴에 Defecation 등록")
    @PostMapping("/defecation")
    public StateRes registerDefecation(@RequestBody @Valid DefecationRegistReq defecationRegistReq) {
        return defecationService.registerDefecation(defecationRegistReq, defecationRegistReq.getBabyId());
    }

    @Operation(summary = "Defecation 조회")
    @GetMapping("/defecation/{defecationId}")
    public DefecationGetRes getDefecationList(@PathVariable Long defecationId) {
        return defecationService.getDefecation(defecationId);
    }

    @Operation(summary = "Defecation 수정")
    @PatchMapping("/defecation/{defecationId}")
    public StateRes updateGrowthRecord(@PathVariable Long defecationId, @RequestBody @Valid DefecationUpdateReq defecationUpdateReq) {
        return defecationService.updateDefecation(defecationId, defecationUpdateReq);
    }

    @Operation(summary = "Defecation 삭제")
    @DeleteMapping("/defecation/{defecationId}")
    public StateRes deleteDefecation(@PathVariable Long defecationId) {
        return defecationService.deleteDefecation(defecationId);
    }
}
