package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "baby_user_link")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyUserLinkDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    private String relationshipType; // 예: 'Parent', 'Guardian' 등
}