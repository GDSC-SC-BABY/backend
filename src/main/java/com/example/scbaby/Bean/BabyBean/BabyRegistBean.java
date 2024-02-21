package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Bean.ImageBean.ImageUploadBean;
import com.example.scbaby.Bean.UserBean.UserGetBean;
import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyUserLinkDAO;
import com.example.scbaby.Model.DAO.UserDAO;
import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.BabyUserLinkRepository;
import com.example.scbaby.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class BabyRegistBean {
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public StateRes exec(BabyRegistReq babyRegistReq) throws IOException {
        BabyDAO babyDAO = babyRegistReq.toDAO(babyCode());
        System.out.println("babyDAO = " + babyDAO);
        BabyDAO babyDAO1 = babyRepository.save(babyDAO);
        System.out.println("babyDAO1 = " + babyDAO1);

        UserDAO userDAO = userRepository.findById(babyRegistReq.getUserId()).get();
        userDAO.setBaby(babyDAO1);
        userRepository.save(userDAO);

        return new StateRes(true);
    }

    private String babyCode() {
        //랜덤 문자열 8자리 생성
        char[] charSet = new char[]{'0','1','2','3','4','5','6','7','8','9',
                'A','B','C','D','E','F','G','H','I','J','K','L','M',
                'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int idx = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            idx = (int) (charSet.length * Math.random());
            sb.append(charSet[idx]);
        }
        return sb.toString();
    }
}
