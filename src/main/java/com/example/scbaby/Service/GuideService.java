package com.example.scbaby.Service;

import com.example.scbaby.Bean.GuideBean.GuideGetBean;
import com.example.scbaby.Model.DTO.Guide.GuideGetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {

    final private GuideGetBean guideGetBean;

    public List<GuideGetDTO> getGuide() {
        return guideGetBean.getExec();
    }
}
