package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.MedicineDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<MedicineDAO, Long> {
}
