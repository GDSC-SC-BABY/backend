package com.example.scbaby.Bean.BabyDiaryBean;

import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import com.example.scbaby.Model.DAO.BabyDiaryImageDAO;
import com.example.scbaby.Model.DTO.BabyDiary.Res.BabyDiaryGetRes;
import com.example.scbaby.Repository.BabyDiaryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BabyDiaryGetBean {
    private final BabyDiaryRepository babyDiaryRepository;

    public BabyDiaryGetRes exec(Long babyDiaryId) {
        BabyDiaryDAO babyDiaryDAO = babyDiaryRepository.findById(babyDiaryId).orElseThrow(EntityNotFoundException::new);
        List<BabyDiaryImageDAO> diaryImageDAOS = babyDiaryDAO.getBabyDiaryImageDAOS();

        return BabyDiaryGetRes.of(babyDiaryDAO, diaryImageDAOS);
    }
}
