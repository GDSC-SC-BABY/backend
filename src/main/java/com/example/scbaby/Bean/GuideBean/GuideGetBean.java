package com.example.scbaby.Bean.GuideBean;

import com.example.scbaby.Model.DAO.GuideDAO;
import com.example.scbaby.Model.DTO.Guide.GuideGetDTO;
import com.example.scbaby.Repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GuideGetBean {

    private final GuideRepository guideRepository;

    public List<GuideGetDTO> getExec() {
        List<GuideDAO> guideDAO = guideRepository.findAll();

        return guideDAO.stream().map(guide -> GuideGetDTO.builder()
                .title(guide.getTitle())
                .age(guide.getAge())
                .imageUrl(guide.getImageUrl())
                .pdfUrl(guide.getPdfUrl())
                .build()).toList();
    }
}
