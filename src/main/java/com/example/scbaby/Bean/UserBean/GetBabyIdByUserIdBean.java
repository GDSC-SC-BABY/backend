package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DAO.UserDAO;
import com.example.scbaby.Model.DTO.User.Res.BabyIdGetRes;
import com.example.scbaby.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetBabyIdByUserIdBean {
    private final UserRepository userRepository;

    public BabyIdGetRes exec(String userId) {
        UserDAO userDAO = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        return BabyIdGetRes.of(userDAO);
    }
}
