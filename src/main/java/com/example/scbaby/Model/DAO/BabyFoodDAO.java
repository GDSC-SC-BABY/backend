package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "baby_food")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BabyFoodDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long babyFoodId;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    private String specialNote;

    private float amount;
    private String imageUrl;

    @OneToMany(mappedBy = "babyFood")
    private List<BasePorridgeDAO> basePorridgeDAOS;

    @OneToMany(mappedBy = "babyFood")
    private List<ToppingDAO> toppingDAOS;
}
