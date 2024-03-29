package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    @Id
    @Column(name = "user_id", length = 50)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id")
    private BabyDAO baby;

    private String imageUri;

    private String relation;

    private String name;
}
