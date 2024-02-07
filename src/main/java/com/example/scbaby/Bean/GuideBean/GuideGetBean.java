package com.example.scbaby.Bean.GuideBean;

import com.example.scbaby.Model.DTO.Guide.GuideGetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GuideGetBean {
    final private String url = "https://download.blog.naver.com/open/b722ab1965523b8ea3422c1729c8bcc9683659/Kchss_KUJIKNR22ZhEGgMub2k3_ZQ0AaRhh7NBZyxgZCbZorTaDOLEEj_ibylhT3g0Dk8v1jjUynTVRzjfrykA/%EC%B4%88%EB%B3%B4%EC%95%84%EB%B9%A0%EC%88%98%EC%B2%A9%282018%29.pdf";

    public GuideGetDTO getExec() {
        return GuideGetDTO.builder()
                .Url(url)
                .build();
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void setExec(){
        System.out.println("setExec");
    }
}
