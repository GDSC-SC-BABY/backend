package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Bean.ImageBean.ImageUploadBean;
import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class BabyRegistBean {
    private final BabyRepository babyRepository;
    private final ImageUploadBean imageUploadBean;

    public StateRes exec(BabyRegistReq babyRegistReq, MultipartFile multipartFile) throws IOException {
        String imgUrl = imageUploadBean.exec(multipartFile);
        BabyDAO babyDAO = babyRegistReq.toDAO(imgUrl);

        babyRepository.save(babyDAO);
        return new StateRes(true);
    }
}
