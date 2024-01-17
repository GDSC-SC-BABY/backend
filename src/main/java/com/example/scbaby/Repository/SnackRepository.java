package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DAO.SnackDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackRepository extends JpaRepository<SnackDAO, Long> {
    SnackDAO findBySnackId(Long snackId);

    Page<SnackDAO> findByBaby(Pageable pageable, BabyDAO babyDAO);
}
