package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.GuideDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<GuideDAO, Long> {
}
