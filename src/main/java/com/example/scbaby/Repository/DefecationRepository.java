package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.DefecationDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface DefecationRepository extends JpaRepository<DefecationDAO, Long> {
    List<DefecationDAO> findByBabyAndStartTimeBetweenOrderByStartTime(BabyDAO baby, LocalDateTime startTime, LocalDateTime endTime);
}
