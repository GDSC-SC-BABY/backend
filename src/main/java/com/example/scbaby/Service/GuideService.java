package com.example.scbaby.Service;

import com.example.scbaby.Bean.GuideBean.GuideGetBean;
import com.example.scbaby.Model.DTO.Guide.GuideGetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuideService {

    final private GuideGetBean guideGetBean;

    public GuideGetDTO getGuide() {
        return guideGetBean.getExec();
    }

    public void setGuide(){
        guideGetBean.setExec();
    }
}
