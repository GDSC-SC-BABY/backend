package com.example.scbaby.Bean.BabysitterBean;

import com.example.scbaby.Model.DTO.Babysitter.Res.BabysitterGetRes;
import com.example.scbaby.Repository.BabysitterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BabysitterGetBean {

    private final BabysitterRepository babysitterRepository;

    public BabysitterGetRes exec(Long babysitterId) {
        return BabysitterGetRes.of(babysitterRepository.findById(babysitterId).orElseThrow(EntityNotFoundException::new));
    }
}
