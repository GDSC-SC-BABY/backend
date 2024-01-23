package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.SleepDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepRepository extends JpaRepository<SleepDAO, Long> {
}
