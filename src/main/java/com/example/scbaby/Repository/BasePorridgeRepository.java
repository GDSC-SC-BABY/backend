package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DAO.BasePorridgeDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasePorridgeRepository extends JpaRepository<BasePorridgeDAO, Long> {
    List<BasePorridgeDAO> findByBabyFood(BabyFoodDAO babyFoodDAO);
}
