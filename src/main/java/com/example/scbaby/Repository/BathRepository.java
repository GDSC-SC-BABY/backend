package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BathDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BathRepository extends JpaRepository<BathDAO, Long> {
    List<BathDAO> findByBabyAndStartTimeBetweenOrderByStartTime(BabyDAO baby, LocalDateTime startTime, LocalDateTime endTime);
}
