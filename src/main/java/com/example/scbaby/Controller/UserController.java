package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Req.AddBabyReq;
import com.example.scbaby.Model.DTO.User.Req.UserGetReq;
import com.example.scbaby.Model.DTO.User.Req.UserRegistReq;
import com.example.scbaby.Model.DTO.User.Res.BabyIdGetRes;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import com.example.scbaby.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @Operation(summary = "UserId 등록")
    @PostMapping("/user")
    public StateRes registerUser(@RequestParam  String userId) {
        return userService.registerUser(userId);
    }

    @Operation(summary = "UserId로 User 조회")
    @GetMapping("/user")
    public UserGetRes getUser(@RequestParam  String userId) {
        return userService.getUser(userId);
    }

    @Operation(summary = "UserId로 중복여부 확인")
    @GetMapping("/user/duplicate/{userId}")
    public StateRes duplicatieUser(@RequestParam  String userId) {
        return userService.duplicateCheckUser(userId);
    }

    @Operation(summary = "UserId로 BabyId 조회")
    @GetMapping("/user/getBaby")
    public BabyIdGetRes getBabyId(@RequestParam  String userId) {
        return userService.getBabyId(userId);
    }

    @Operation(summary = "babyCode로 baby 추가")
    @PatchMapping("/user/addBaby")
    public StateRes addBaby(@RequestBody AddBabyReq addBabyReq) {
        return userService.addBaby(addBabyReq);
    }
}
