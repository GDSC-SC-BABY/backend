package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Snack.Req.SnackPostReq;
import com.example.scbaby.Model.DTO.Snack.Res.SnackDetailGetRes;
import com.example.scbaby.Model.DTO.Snack.Res.SnackListRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.SnackService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class SnackController {
    private final SnackService snackService;

    @Operation(summary = "Snack 조회")
    @GetMapping("/snack")
    public SnackListRes getListSnackList(@RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
                                         @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                         @RequestParam Long babyId) {
        return snackService.getListSnackList(pageNo, pageSize, babyId);
    }

    @Operation(summary = "날짜별 Snack 조회")
    @GetMapping("/snackList")
    public SnackListRes getListBabyFoodListByDate(@RequestParam Long babyId, @RequestParam String date) {
        return snackService.getListSnackListByDate(babyId, date);
    }

    @Operation(summary = "Snack 개별 조회")
    @GetMapping("/snack/{snackId}")
    public SnackDetailGetRes getSnack(@PathVariable Long snackId) {
        return snackService.getSnack(snackId);
    }

    @Operation(summary = "Snack 등록")
    @PostMapping("/snack")
    public StateRes postSnack(@RequestBody SnackPostReq snackPostReq) {
        return snackService.postSnack(snackPostReq);
    }
}
