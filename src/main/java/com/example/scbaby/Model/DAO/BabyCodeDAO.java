package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "baby_code")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyCodeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    private String babyCode;
    private LocalDateTime dateTime;
}
