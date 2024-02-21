package com.example.scbaby.Service;

import com.example.scbaby.Bean.Snack.SnackGetBean;
import com.example.scbaby.Bean.Snack.SnackListGetBean;
import com.example.scbaby.Bean.Snack.SnackPostBean;
import com.example.scbaby.Model.DTO.Snack.Req.SnackPostReq;
import com.example.scbaby.Model.DTO.Snack.Res.SnackDetailGetRes;
import com.example.scbaby.Model.DTO.Snack.Res.SnackListRes;
import com.example.scbaby.Model.DTO.StateRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SnackService {
    private final SnackListGetBean snackListGetBean;
    private final SnackGetBean snackGetBean;
    private final SnackPostBean snackPostBean;

    public SnackListRes getListSnackList(Integer pageNo, Integer pageSize, Long babyId) {
        return snackListGetBean.exec(pageNo, pageSize, babyId);
    }

    public SnackDetailGetRes getSnack(Long snackId) {
        return snackGetBean.exec(snackId);
    }

    public StateRes postSnack(SnackPostReq snackPostReq) {
        return snackPostBean.exec(snackPostReq);
    }
}
