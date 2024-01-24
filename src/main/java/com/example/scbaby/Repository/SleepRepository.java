package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.SleepDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SleepRepository extends JpaRepository<SleepDAO, Long> {
    List<SleepDAO> findByBabyAndStartTimeBetweenOrderByStartTime(BabyDAO baby, LocalDateTime startTime, LocalDateTime endTime);

}

