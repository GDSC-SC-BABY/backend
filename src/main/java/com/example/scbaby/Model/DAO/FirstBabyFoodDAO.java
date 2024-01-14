package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "first_baby_food")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FirstBabyFoodDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long firstBabyFoodId;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    private LocalDateTime dateTime;

    private String SpecialNote;

    private float amount;

    @OneToMany(mappedBy = "firstBabyFood")
    private List<ToppingDAO> toppingDAOS;
}
