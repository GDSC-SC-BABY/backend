package com.example.scbaby.Bean.BabyBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.UserDAO;
import com.example.scbaby.Model.DTO.User.Res.UserGetRes;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetParentsBean {
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public List<UserGetRes> exec(Long babyId) {
        BabyDAO babyDAO = babyRepository.findById(babyId).get();
        List<UserDAO> userDAOList = userRepository.findByBaby(babyDAO);
        return userDAOList.stream().map(UserGetRes::of).collect(Collectors.toList());
    }
}
