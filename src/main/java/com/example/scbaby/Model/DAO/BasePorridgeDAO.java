package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "base_porridge")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasePorridgeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basePorridgeId;
    private String basePorridgeName;
    @ManyToOne
    @JoinColumn(name = "baby_food_id")
    private BabyFoodDAO babyFood;
}
