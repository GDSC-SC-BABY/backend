package com.example.scbaby.Bean.BabyDiaryBean;

import com.example.scbaby.Bean.ImageBean.ImageListUpdateBean;
import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import com.example.scbaby.Model.DAO.BabyDiaryImageDAO;
import com.example.scbaby.Model.DTO.BabyDiary.Req.BabyDiaryUpdateReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyDiaryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class BabyDiaryUpdateBean {
    private final BabyDiaryRepository babyDiaryRepository;
    private final ImageListUpdateBean imageListUpdateBean;

    public StateRes exec(BabyDiaryUpdateReq babyDiaryUpdateReq, Long babyDiaryId, List<MultipartFile> multipartFiles) throws IOException {
        BabyDiaryDAO babyDiaryDAO = babyDiaryRepository.findById(babyDiaryId)
                .orElseThrow(EntityNotFoundException::new);

        babyDiaryDAO.update(babyDiaryUpdateReq);

        List<String> imageUrls = imageListUpdateBean.exec(multipartFiles);

        updateBabyDiaryImages(babyDiaryDAO, imageUrls, multipartFiles.size());
        removeExcessBabyDiaryImages(babyDiaryDAO, multipartFiles.size());

        return new StateRes(true);
    }

    private void updateBabyDiaryImages(BabyDiaryDAO babyDiaryDAO, List<String> imageUrls, int numOfFiles) {
        List<BabyDiaryImageDAO> babyDiaryImageDAOS = babyDiaryDAO.getBabyDiaryImageDAOS();

        IntStream.range(0, numOfFiles)
                .forEach(i -> {
                    BabyDiaryImageDAO babyDiaryImageDAO = getOrCreateBabyDiaryImage(babyDiaryImageDAOS, i);
                    babyDiaryImageDAO.setRepImgYn(i == 0 ? "Y" : "N");
                    babyDiaryImageDAO.setBabyDiaryDAO(babyDiaryDAO);
                    babyDiaryImageDAO.setImgUrl(imageUrls.get(i));
                });
    }

    private BabyDiaryImageDAO getOrCreateBabyDiaryImage(List<BabyDiaryImageDAO> babyDiaryImageDAOS, int index) {
        if (index < babyDiaryImageDAOS.size()) {
            return babyDiaryImageDAOS.get(index);
        } else {
            BabyDiaryImageDAO babyDiaryImageDAO = new BabyDiaryImageDAO();
            babyDiaryImageDAOS.add(babyDiaryImageDAO);
            return babyDiaryImageDAO;
        }
    }

    private void removeExcessBabyDiaryImages(BabyDiaryDAO babyDiaryDAO, int expectedSize) {
        List<BabyDiaryImageDAO> babyDiaryImageDAOS = babyDiaryDAO.getBabyDiaryImageDAOS();

        // Remove excess BabyDiaryImageDAO entities
        if (babyDiaryImageDAOS.size() > expectedSize) {
            babyDiaryImageDAOS.subList(expectedSize, babyDiaryImageDAOS.size()).clear();
        }
    }
}
