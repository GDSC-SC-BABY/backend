package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BeverageDAO;
import com.example.scbaby.Model.DAO.SnackDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeverageRepository extends JpaRepository<BeverageDAO, Long> {
    List<BeverageDAO> findBySnack(SnackDAO snackDAO);
}

