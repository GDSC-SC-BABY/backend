package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "snacks")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnackDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long snackId;

    private LocalDateTime dateTime;

    private String SpecialNote;

    private float amount;

    @OneToMany(mappedBy = "snack")
    private List<BeverageDAO> beverageDAOS;

    @OneToMany(mappedBy = "snack")
    private List<ToppingDAO> toppingDAOS;

}
