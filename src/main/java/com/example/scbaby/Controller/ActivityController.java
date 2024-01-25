package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Activity.Res.ActivityListGetRes;
import com.example.scbaby.Service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    @Operation(summary = "Baby 등록")
    @GetMapping("/activity/{babyId}")
    public List<ActivityListGetRes> getBabyActivityListByBabyIdAndDate(@PathVariable Long babyId, @RequestParam String date) {
        LocalDate specificDate = LocalDate.parse(date);
        return activityService.getBabyActivityListByBabyIdAndDate(babyId, specificDate);
    }
}
