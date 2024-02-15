package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Model.DTO.User.Req.UserRegistReq;
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
    public StateRes registerUser(@RequestBody UserRegistReq userRegistrationReq) {
        return userService.registerUser(userRegistrationReq);
    }

    @Operation(summary = "UserId로 조회")
    @GetMapping("/user/{userId}")
    public UserGetRes getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @Operation(summary = "UserId로 중복여부 확인")
    @GetMapping("/user/duplicate/{userId}")
    public StateRes duplicatieUser(@PathVariable String userId) {
        return userService.duplicateCheckUser(userId);
    }
}
