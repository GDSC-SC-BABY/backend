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
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BabyRegistBean {
    private final BabyRepository babyRepository;
    private final ImageUploadBean imageUploadBean;
    private final UserRepository userRepository;

    public StateRes exec(BabyRegistReq babyRegistReq, MultipartFile multipartFile, String userId) throws IOException {
        String imgUrl = imageUploadBean.exec(multipartFile);
        BabyDAO babyDAO = babyRegistReq.toDAO(imgUrl, babyCode());
        BabyDAO babyDAO1 = babyRepository.save(babyDAO);

        UserDAO userDAO = userRepository.findById(userId).get();
        userDAO.setBaby(babyDAO1);
        userRepository.save(userDAO);

        return new StateRes(true);
    }

    private String babyCode() {
        String code = generateUniqueCode(8);
        return code;
    }


    public static String generateUniqueCode(int length) {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "").substring(0, length);
    }

    public static void main(String[] args) {
        String uniqueCode = generateUniqueCode(8);
        System.out.println(uniqueCode);
    }
}
