package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.Baby.Res.BabyGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.BabyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BabyController {
    private final BabyService babyService;

    @Operation(summary = "Baby 등록")
    @PostMapping("/baby")
    public StateRes registerUser(@RequestBody @Valid BabyRegistReq babyRegistReq) {
        return babyService.registerBaby(babyRegistReq);
    }

    @Operation(summary = "BabyId로 Baby 조회")
    @GetMapping("/baby/{babyId}")
    public BabyGetRes getBaby(@PathVariable Long babyId) {
        return babyService.getBaby(babyId);
    }

    @Operation(summary = "Baby 수정.")
    @PatchMapping("/baby/{babyId}")
    public StateRes updateBaby(@PathVariable Long babyId, @RequestBody @Valid BabyUpdateReq babyUpdateReq) {
        return babyService.updateBaby(babyId, babyUpdateReq);
    }
}
