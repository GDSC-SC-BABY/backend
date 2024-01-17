package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "beverages")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeverageDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beverageId;

    private String beverageName;

    @ManyToOne
    @JoinColumn(name = "snack_id")
    private SnackDAO snack;

    @Builder.Default
    private boolean Allergy = false;
}
