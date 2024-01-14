package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "beverages")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeverageDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long snackId;
    private String snackName;
    @ManyToOne
    @JoinColumn(name = "snack_id")
    private SnackDAO snack;
}
