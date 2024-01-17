package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyRepository extends JpaRepository<BabyDAO, Long> {
    //findByBabyId
    BabyDAO findByBabyId(Long babyId);
}
