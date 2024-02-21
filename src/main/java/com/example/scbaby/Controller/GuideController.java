package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.GrowthRecord.Res.PageResponseDto;
import com.example.scbaby.Model.DTO.Guide.GuideGetDTO;
import com.example.scbaby.Service.GuideService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class GuideController {

    final private GuideService guideService;

    @Operation(summary = "BabyId로 GrowthRecord List 조회")
    @GetMapping("/guide")
    public List<GuideGetDTO> getGuide() {
        return guideService.getGuide();
    }

}
