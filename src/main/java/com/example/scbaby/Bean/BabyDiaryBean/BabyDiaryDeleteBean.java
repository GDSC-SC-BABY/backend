package com.example.scbaby.Bean.BabyDiaryBean;

import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyDiaryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BabyDiaryDeleteBean {
    private final BabyDiaryRepository babyDiaryRepository;

    public StateRes exec(Long babyDiaryId) {
        BabyDiaryDAO babyDiaryDAO = babyDiaryRepository.findById(babyDiaryId).orElseThrow(EntityNotFoundException::new);
        babyDiaryRepository.delete(babyDiaryDAO);

        return new StateRes(true);
    }
}
