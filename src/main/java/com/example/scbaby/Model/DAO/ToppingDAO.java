package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "toppings")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ToppingDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toppingId;

    private String toppingName;

    @ManyToOne
    @JoinColumn(name = "baby_food_id")
    private BabyFoodDAO babyFood;

    @ManyToOne
    @JoinColumn(name = "snack_id")
    private SnackDAO snack;

    @Builder.Default
    private float amount = 0.0f;

    @Builder.Default
    private boolean isAllergy = false;
}
