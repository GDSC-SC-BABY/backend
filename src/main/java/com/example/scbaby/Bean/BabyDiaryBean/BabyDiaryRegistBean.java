package com.example.scbaby.Bean.BabyDiaryBean;

import com.example.scbaby.Bean.ImageBean.ImageListUploadBean;
import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import com.example.scbaby.Model.DAO.BabyDiaryImageDAO;
import com.example.scbaby.Model.DTO.BabyDiary.Req.BabyDiaryRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyDiaryImageRepository;
import com.example.scbaby.Repository.BabyDiaryRepository;
import com.example.scbaby.Repository.BabyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BabyDiaryRegistBean {
    private final BabyRepository babyRepository;
    private final BabyDiaryRepository babyDiaryRepository;
    private final BabyDiaryImageRepository babyDiaryImageRepository;
    private final ImageListUploadBean imageListUploadBean;

    public StateRes exec(BabyDiaryRegistReq babyDiaryRegistReq, Long babyId, List<MultipartFile> multipartFiles) throws IOException {
        BabyDAO babyDAO = babyRepository.findById(babyId).orElseThrow(EntityNotFoundException::new);

        // BabyDiary 등록
        BabyDiaryDAO babyDiaryDAO = babyDiaryRegistReq.toDAO(babyDAO);
        babyDiaryRepository.save(babyDiaryDAO);

        List<String> imgUrlList = imageListUploadBean.exec(multipartFiles);
        BabyDiaryImageDAO babyDiaryImageDAO;

        for (int i = 0; i < multipartFiles.size(); i++) {
            if (i == 0) {
                babyDiaryImageDAO = BabyDiaryImageDAO.builder()
                        .babyDiaryDAO(babyDiaryDAO)
                        .imgUrl(imgUrlList.get(i))
                        .repImgYn("Y")
                        .build();
            } else {
                babyDiaryImageDAO = BabyDiaryImageDAO.builder()
                        .babyDiaryDAO(babyDiaryDAO)
                        .imgUrl(imgUrlList.get(i))
                        .repImgYn("N")
                        .build();
            }
            babyDiaryImageRepository.save(babyDiaryImageDAO);
        }

        return new StateRes(true);
    }
}
