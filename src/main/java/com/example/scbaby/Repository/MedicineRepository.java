package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.MedicineDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicineRepository extends JpaRepository<MedicineDAO, Long> {
    List<MedicineDAO> findByBabyAndStartTimeBetweenOrderByStartTime(BabyDAO baby, LocalDateTime startTime, LocalDateTime endTime);

}
