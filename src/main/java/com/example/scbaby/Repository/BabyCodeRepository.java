package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyCodeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyCodeRepository extends JpaRepository<BabyCodeDAO, Long> {
}
