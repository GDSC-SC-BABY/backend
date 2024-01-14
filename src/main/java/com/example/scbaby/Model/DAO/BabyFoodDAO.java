package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "baby_food")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyFoodDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long babyFoodId;
    private LocalDateTime dateTime;

    private String SpecialNote;

    private float amount;

    @OneToMany(mappedBy = "babyFood")
    private List<BasePorridgeDAO> basePorridgeDAOS;

    @OneToMany(mappedBy = "babyFood")
    private List<ToppingDAO> toppingDAOS;
}
