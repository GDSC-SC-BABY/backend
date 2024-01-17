package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.BabyFood.Req.BabyFoodPostReq;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodDetailGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodListRes;
import com.example.scbaby.Model.DTO.Snack.Req.SnackPostReq;
import com.example.scbaby.Model.DTO.Snack.Res.SnackDetailGetRes;
import com.example.scbaby.Model.DTO.Snack.Res.SnackListRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.BabyFoodService;
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
    @GetMapping("/Snack")
    public SnackListRes getListSnackList(@RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
                                         @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                         @RequestParam String babyId) {
        return snackService.getListSnackList(pageNo, pageSize, babyId);
    }

    @Operation(summary = "Snack 개별 조회")
    @GetMapping("/Snack/{snackId}")
    public SnackDetailGetRes getSnack(@PathVariable Long snackId) {
        return snackService.getSnack(snackId);
    }

    @Operation(summary = "Snack 등록")
    @PostMapping("/Snack")
    public StateRes postSnack(@RequestBody SnackPostReq snackPostReq) {
        return snackService.postSnack(snackPostReq);
    }
}
