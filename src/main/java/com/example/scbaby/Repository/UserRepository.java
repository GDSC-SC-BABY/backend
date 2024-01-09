package com.example.scbaby.Repository;

import com.example.scbaby.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, String>{

}
