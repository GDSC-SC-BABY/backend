package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.BabyDiary.Req.BabyDiaryRegistReq;
import com.example.scbaby.Model.DTO.BabyDiary.Req.BabyDiaryUpdateReq;
import com.example.scbaby.Model.DTO.BabyDiary.Res.BabyDiaryGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.BabyDiaryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BabyDiaryController {
    private final BabyDiaryService babyDiaryService;

    @Operation(summary = "BabyDiary 등록")
    @PostMapping("/babydiary")
    public StateRes registerBabyDiary(@RequestPart BabyDiaryRegistReq babyDiaryRegistReq,
                                 @RequestPart List<MultipartFile> multipartFile) throws IOException {
        return babyDiaryService.registerBabyDiary(babyDiaryRegistReq, babyDiaryRegistReq.getBabyId(), multipartFile);
    }

    @Operation(summary = "BabyDiary 조회")
    @GetMapping("/babydiary/{babydiaryId}")
    public BabyDiaryGetRes getBabyDiary(@PathVariable Long babydiaryId) {
        return babyDiaryService.getBabyDiary(babydiaryId);
    }

    @Operation(summary = "특정 Baby의 전체 BabyDiary 조회")
    @GetMapping("/babydiary/list/{babyId}")
    public List<BabyDiaryGetRes> getBabyDiaryList(@PathVariable Long babyId) {
        return babyDiaryService.getBabyDiaryList(babyId);
    }

    @Operation(summary = "BabyDiary 수정")
    @PatchMapping("/babydiary/{babydiaryId}")
    public StateRes updateBabyDiary(@PathVariable Long babydiaryId, @RequestPart BabyDiaryUpdateReq babyDiaryUpdateReq,
                                                 @RequestPart List<MultipartFile> multipartFile) throws IOException {
        return babyDiaryService.updateBabyDiary(babydiaryId, babyDiaryUpdateReq, multipartFile);
    }

    @Operation(summary = "BabyDiary 삭제")
    @DeleteMapping("/babydiary/{babydiaryId}")
    public StateRes deleteBabyDiary(@PathVariable Long babydiaryId) {
        return babyDiaryService.deleteBabyDiary(babydiaryId);
    }
}
