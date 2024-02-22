package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.SnackDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SnackRepository extends JpaRepository<SnackDAO, Long> {
    SnackDAO findBySnackId(Long snackId);

    Page<SnackDAO> findByBaby(Pageable pageable, BabyDAO babyDAO);

    List<SnackDAO> findByBabyAndDateTimeBetweenOrderByDateTime(BabyDAO baby, LocalDateTime startTime, LocalDateTime endTime);
}
