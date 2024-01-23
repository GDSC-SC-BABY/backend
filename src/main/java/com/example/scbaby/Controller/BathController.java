package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Bath.Req.BathRegistReq;
import com.example.scbaby.Model.DTO.Bath.Req.BathUpdateReq;
import com.example.scbaby.Model.DTO.Bath.Res.BathGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.BathService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BathController {

    private final BathService bathService;

    @Operation(summary = "생활패턴에 Bath 등록")
    @PostMapping("/bath")
    public StateRes registerBath(@RequestBody @Valid BathRegistReq bathRegistReq) {
        return bathService.registerBath(bathRegistReq, bathRegistReq.getBabyId());
    }

    @Operation(summary = "BabyId로 Bath 조회")
    @GetMapping("/bath/{bathId}")
    public BathGetRes getBathList(@PathVariable Long bathId) {
        return bathService.getBath(bathId);
    }

    @Operation(summary = "Bath 수정")
    @PatchMapping("/bath/{bathId}")
    public StateRes updateGrowthRecord(@PathVariable Long bathId, @RequestBody @Valid BathUpdateReq bathUpdateReq) {
        return bathService.updateBath(bathId, bathUpdateReq);
    }

    @Operation(summary = "Bath 삭제")
    @DeleteMapping("/bath/{bathId}")
    public StateRes deleteBath(@PathVariable Long bathId) {
        return bathService.deleteBath(bathId);
    }
}
