package com.example.scbaby.Controller;

import com.example.scbaby.Model.DTO.Babysitter.Req.BabysitterRegistReq;
import com.example.scbaby.Model.DTO.Babysitter.Req.BabysitterUpdateReq;
import com.example.scbaby.Model.DTO.Babysitter.Res.BabysitterGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Service.BabysitterService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class BabysitterController {

    private final BabysitterService babysitterService;

    @Operation(summary = "Babysitter 등록")
    @PostMapping("/babysitter")
    public StateRes registerUser(@RequestBody @Valid BabysitterRegistReq babysitterRegistReq) {
        return babysitterService.registerBabysitter(babysitterRegistReq);
    }

    @Operation(summary = "BabysitterId로 Babysitter 조회")
    @GetMapping("/babysitter/{babysitterId}")
    public BabysitterGetRes getBabysitter(@PathVariable Long babysitterId) {
        return babysitterService.getBabysitter(babysitterId);
    }

    @Operation(summary = "Babysitter 수정")
    @PatchMapping("/babysitter/{babysitterId}")
    public StateRes updateBabysitter(@PathVariable Long babysitterId, @RequestBody @Valid BabysitterUpdateReq babysitterUpdateReq) {
        return babysitterService.updateBabysitter(babysitterId, babysitterUpdateReq);
    }
}
