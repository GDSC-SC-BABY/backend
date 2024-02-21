package com.example.scbaby.Model.DTO.Guide;

import lombok.*;


@Getter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GuideGetDTO {
    private String title;
    private int age;
    private String imageUrl;
    private String pdfUrl;
}
