package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordRegistReq;
import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordUpdateReq;
import com.example.scbaby.Model.DTO.GrowthRecord.Res.PageResponseDto;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.GrowthRecordService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class GrowthRecordController {

    private final GrowthRecordService growthRecordService;

    @Operation(summary = "GrowthRecord 등록")
    @PostMapping("/growthrecord")
    public StateRes registerGrowthRecord(@RequestBody @Valid GrowthRecordRegistReq growthRecordRegistReq) {
        return growthRecordService.registerGrowthRecord(growthRecordRegistReq, growthRecordRegistReq.getBabyId());
    }

    @Operation(summary = "BabyId로 GrowthRecord List 조회")
    @GetMapping("/growthrecord/{babyId}")
    public PageResponseDto getBaby(@RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
                                   @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                   @PathVariable Long babyId) {

        return growthRecordService.getGrowthRecordList(pageNo, pageSize, babyId);
    }

    @Operation(summary = "GrowthRecord 수정")
    @PatchMapping("/growthrecord/{growthRecordId}")
    public StateRes updateGrowthRecord(@PathVariable Long growthRecordId, @RequestBody @Valid GrowthRecordUpdateReq growthRecordUpdateReq) {
        return growthRecordService.updateGrowthRecord(growthRecordId, growthRecordUpdateReq);
    }
}
