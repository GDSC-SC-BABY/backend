package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDiaryDAO;
import com.example.scbaby.Model.DAO.BabyDiaryImageDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyDiaryImageRepository extends JpaRepository<BabyDiaryImageDAO, Long> {
    List<BabyDiaryImageDAO> findAllByBabyDiaryDAO(BabyDiaryDAO babyDiaryDAO);
}
