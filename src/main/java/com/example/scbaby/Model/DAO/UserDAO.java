package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    @Id
    @Column(name = "user_id", length = 50)
    private String userId;

    @OneToMany(mappedBy = "user")
    private List<BabyUserLinkDAO> babyUserLinkDAOS;

    private String email;
    private String name;
    private String residence;

}