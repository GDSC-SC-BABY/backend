package com.example.scbaby.Bean.BabysitterBean;

import com.example.scbaby.Model.DTO.Babysitter.Req.BabysitterRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabysitterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BabysitterRegistBean {
    private final BabysitterRepository babysitterRepository;

    public StateRes exec(BabysitterRegistReq babysitterRegistReq) {
        babysitterRepository.save(babysitterRegistReq.toDAO());
        return new StateRes(true);
    }
}
