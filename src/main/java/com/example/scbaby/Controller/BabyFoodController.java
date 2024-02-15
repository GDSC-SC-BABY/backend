package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.BabyFood.Req.BabyFoodPostReq;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodDetailGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodListRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.BabyFoodService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BabyFoodController {
    private final BabyFoodService babyFoodService;

    @Operation(summary = "babyFood 조회")
    @GetMapping("/babyFood")
    public BabyFoodListRes getListBabyFoodList(@RequestParam(value = "pageNo", defaultValue = "0", required = false) Integer pageNo,
                                   @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                   @RequestParam Long babyId) {
        return babyFoodService.getListBabyFoodList(pageNo, pageSize, babyId);
    }

    @Operation(summary = "babyFood 개별 조회")
    @GetMapping("/babyFood/{babyFoodId}")
    public BabyFoodDetailGetRes getBabyFood(@PathVariable Long babyFoodId) {
        return babyFoodService.getBabyFood(babyFoodId);
    }

    @Operation(summary = "babyFood 등록")
    @PostMapping("/babyFood")
    public StateRes postBabyFood(@RequestBody BabyFoodPostReq babyFoodPostReq) {
        return babyFoodService.postBabyFood(babyFoodPostReq);
    }


}
