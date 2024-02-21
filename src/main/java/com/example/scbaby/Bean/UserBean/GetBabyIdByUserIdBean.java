package com.example.scbaby.Bean.UserBean;

import com.example.scbaby.Model.DAO.UserDAO;
import com.example.scbaby.Model.DTO.User.Res.BabyIdGetRes;
import com.example.scbaby.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetBabyIdByUserIdBean {
    private final UserRepository userRepository;

    public BabyIdGetRes exec(String userId) {
        Optional<UserDAO> userDAO = userRepository.findById(userId);
        if (userDAO.isEmpty()) {
            return BabyIdGetRes.builder().babyId(null).build();
        }
        return BabyIdGetRes.of(userDAO.get());
    }
}
