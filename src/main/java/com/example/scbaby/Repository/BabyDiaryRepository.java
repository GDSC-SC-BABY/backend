package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyDiaryRepository extends JpaRepository<BabyDiaryDAO, Long> {
    List<BabyDiaryDAO> findAllByBaby(BabyDAO babyDAO);
}
