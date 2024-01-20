package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.BabysitterDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabysitterRepository extends JpaRepository<BabysitterDAO, String> {
}
