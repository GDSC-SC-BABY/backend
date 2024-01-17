package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DAO.BasePorridgeDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyFoodRepository extends JpaRepository<BabyFoodDAO, Long> {
    Page<BabyFoodDAO> findByBaby(Pageable pageable, BabyDAO baby);

    BabyFoodDAO findByBabyFoodId(Long babyFoodId);
}
