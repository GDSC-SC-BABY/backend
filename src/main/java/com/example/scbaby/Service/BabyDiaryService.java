package com.example.scbaby.Service;

import com.example.scbaby.Bean.BabyDiaryBean.*;
import com.example.scbaby.Model.DTO.BabyDiary.Req.BabyDiaryRegistReq;
import com.example.scbaby.Model.DTO.BabyDiary.Req.BabyDiaryUpdateReq;
import com.example.scbaby.Model.DTO.BabyDiary.Res.BabyDiaryGetRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyDiaryService {
    private final BabyDiaryRegistBean babyDiaryRegistBean;
    private final BabyDiaryGetBean babyDiaryGetBean;
    private final BabyDiaryListBean babyDiaryListBean;
    private final BabyDiaryUpdateBean babyDiaryUpdateBean;
    private final BabyDiaryDeleteBean babyDiaryDeleteBean;

    @Transactional
    public StateRes registerBabyDiary(BabyDiaryRegistReq babyDiaryRegistReq, Long babyId, List<MultipartFile> multipartFiles) throws IOException {
        return babyDiaryRegistBean.exec(babyDiaryRegistReq, babyId, multipartFiles);
    }

    @Transactional(readOnly = true)
    public BabyDiaryGetRes getBabyDiary(Long babyDiaryId) {
        return babyDiaryGetBean.exec(babyDiaryId);
    }

    @Transactional(readOnly = true)
    public List<BabyDiaryGetRes> getBabyDiaryList(Long babyId) {
        return babyDiaryListBean.exec(babyId);
    }

    @Transactional
    public StateRes updateBabyDiary(Long babydiaryId, BabyDiaryUpdateReq babyDiaryUpdateReq, List<MultipartFile> multipartFiles) throws IOException {
        return babyDiaryUpdateBean.exec(babyDiaryUpdateReq, babydiaryId, multipartFiles);
    }

    @Transactional
    public StateRes deleteBabyDiary(Long babydiaryId) {
        return babyDiaryDeleteBean.exec(babydiaryId);
    }
}
