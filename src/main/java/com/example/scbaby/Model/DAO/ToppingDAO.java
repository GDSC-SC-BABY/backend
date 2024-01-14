package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "toppings")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToppingDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toppingId;

    private String toppingName;

    @ManyToOne
    @JoinColumn(name = "frist_baby_food_id")
    private FirstBabyFoodDAO firstBabyFood;

    @ManyToOne
    @JoinColumn(name = "baby_food_id")
    private BabyFoodDAO babyFood;

    @ManyToOne
    @JoinColumn(name = "snack_id")
    private SnackDAO snack;
}
