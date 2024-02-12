package com.example.scbaby.Bean.BabyDiaryBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import com.example.scbaby.Model.DTO.BabyDiary.Res.BabyDiaryGetRes;
import com.example.scbaby.Repository.BabyDiaryRepository;
import com.example.scbaby.Repository.BabyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BabyDiaryListBean {
    private final BabyRepository babyRepository;
    private final BabyDiaryRepository babyDiaryRepository;
    public List<BabyDiaryGetRes> exec(Long babyId) {
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);
        List<BabyDiaryDAO> babyDiaryDAOS = babyDiaryRepository.findAllByBaby(babyDAO);

        return babyDiaryDAOS.stream()
                .map(babyDiaryDAO -> BabyDiaryGetRes.builder()
                        .babyDiaryId(babyDiaryDAO.getBabyDiaryId())
                        .imageList(babyDiaryDAO.getBabyDiaryImageDAOS())
                        .title(babyDiaryDAO.getTitle())
                        .content(babyDiaryDAO.getContent())
                        .dateTime(babyDiaryDAO.getDateTime())
                        .build())
                .toList();
    }
}
