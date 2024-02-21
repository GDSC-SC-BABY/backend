package com.example.scbaby.Model.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guide")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuideDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guideId;

    private String title;
    private int age;
    private String imageUrl;
    private String pdfUrl;

}
