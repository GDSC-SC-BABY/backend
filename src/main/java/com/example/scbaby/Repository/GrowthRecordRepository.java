package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.GrowthRecordDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowthRecordRepository extends JpaRepository<GrowthRecordDAO, Long> {
    Page<GrowthRecordDAO> findAllByBaby(Pageable pageable, BabyDAO babyDAO);
}
