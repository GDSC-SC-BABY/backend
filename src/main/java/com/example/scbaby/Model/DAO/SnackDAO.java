package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "snacks")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SnackDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long snackId;

    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    private String SpecialNote;

    private float amount;
    private String imageUrl;

    @OneToMany(mappedBy = "snack")
    private List<ToppingDAO> toppingDAOS;

}
