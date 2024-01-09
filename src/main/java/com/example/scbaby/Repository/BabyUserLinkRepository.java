package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabyUserLinkDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyUserLinkRepository extends JpaRepository<BabyUserLinkDAO, Long> {
}
