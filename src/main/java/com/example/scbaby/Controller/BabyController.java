package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.Baby.Res.BabyGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.BabyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BabyController {
    private final BabyService babyService;

    @Operation(summary = "Baby 등록")
    @PostMapping("/baby")
    public StateRes registerUser(@RequestPart BabyRegistReq babyRegistReq,
                                 @RequestPart MultipartFile multipartFile,
                                 @RequestPart String userId) throws IOException {
        return babyService.registerBaby(babyRegistReq, multipartFile, userId);
    }

    @Operation(summary = "BabyId로 Baby 조회")
    @GetMapping("/baby/{babyId}")
    public BabyGetRes getBaby(@PathVariable Long babyId) {
        return babyService.getBaby(babyId);
    }

    @Operation(summary = "Baby 수정")
    @PatchMapping("/baby/{babyId}")
    public StateRes updateBaby(@PathVariable Long babyId, @RequestPart BabyUpdateReq babyUpdateReq, @RequestPart MultipartFile multipartFile) throws IOException {
        return babyService.updateBaby(babyId, babyUpdateReq, multipartFile);
    }
}
