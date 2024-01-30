package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Bean.ImageBean.ImageUploadBean;
import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DTO.Baby.Req.BabyUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class BabyUpdateBean {
    private final BabyRepository babyRepository;
    private final ImageUploadBean imageUploadBean;

    public StateRes exec(Long babyId, BabyUpdateReq babyUpdateReq, MultipartFile multipartFile) throws IOException {
        if (babyRepository.findById(babyId).isPresent()) {
            BabyDAO babyDAO = babyRepository.findById(babyId).get();
            
            String imgUrl = null;
            if (multipartFile.getOriginalFilename() != null) {
                imgUrl = imageUploadBean.exec(multipartFile);
            }

            babyDAO.update(babyUpdateReq, imgUrl);
            return new StateRes(true);
        }
        return new StateRes(false);
    }
}
