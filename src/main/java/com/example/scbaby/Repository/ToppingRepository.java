package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DAO.SnackDAO;
import com.example.scbaby.Model.DAO.ToppingDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository<ToppingDAO, Long> {

    List<ToppingDAO> findByBabyFood(BabyFoodDAO babyFoodDAO);

    List<ToppingDAO> findBySnack(SnackDAO snackDAO);
}
