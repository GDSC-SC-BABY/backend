package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Sleep.Req.SleepRegistReq;
import com.example.scbaby.Model.DTO.Sleep.Req.SleepUpdateReq;
import com.example.scbaby.Model.DTO.Sleep.Res.SleepGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.SleepService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class SleepController {

    private final SleepService sleepService;

    @Operation(summary = "생활패턴에 Sleep 등록")
    @PostMapping("/sleep")
    public StateRes registerSleep(@RequestBody @Valid SleepRegistReq sleepRegistReq) {
        return sleepService.registerSleep(sleepRegistReq, sleepRegistReq.getBabyId());
    }

    @Operation(summary = "Sleep 조회")
    @GetMapping("/sleep/{sleepId}")
    public SleepGetRes getSleepList(@PathVariable Long sleepId) {
        return sleepService.getSleep(sleepId);
    }

    @Operation(summary = "Sleep 수정")
    @PatchMapping("/sleep/{sleepId}")
    public StateRes updateGrowthRecord(@PathVariable Long sleepId, @RequestBody @Valid SleepUpdateReq sleepUpdateReq) {
        return sleepService.updateSleep(sleepId, sleepUpdateReq);
    }

    @Operation(summary = "Sleep 삭제")
    @DeleteMapping("/sleep/{sleepId}")
    public StateRes deleteSleep(@PathVariable Long sleepId) {
        return sleepService.deleteSleep(sleepId);
    }
}
