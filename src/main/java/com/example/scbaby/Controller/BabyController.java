package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.Baby.Res.BabyGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import com.example.scbaby.Service.BabyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BabyController {
    private final BabyService babyService;

    @Operation(summary = "Baby 등록")
    @PostMapping("/baby")
    public StateRes registerUser(@RequestBody BabyRegistReq babyRegistReq) throws IOException {
        return babyService.registerBaby(babyRegistReq);
    }

    @Operation(summary = "BabyId로 Baby 조회")
    @GetMapping("/baby/{babyId}")
    public BabyGetRes getBaby(@PathVariable Long babyId) {
        return babyService.getBaby(babyId);
    }

    @Operation(summary = "Baby 수정")
    @PatchMapping("/baby/{babyId}")
    public StateRes updateBaby(@PathVariable Long babyId, @RequestBody BabyUpdateReq babyUpdateReq) throws IOException {
        return babyService.updateBaby(babyId, babyUpdateReq);
    }

    @Operation(summary = "BabyId로 공동양육자 조회")
    @GetMapping("/baby/{babyId}/parents")
    public List<UserGetRes> getParents(@PathVariable Long babyId) {
        return babyService.getParents(babyId);
    }
}
