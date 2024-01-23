package com.example.scbaby.Model.DTO.GrowthRecord.Res;

import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class PageResponseDto {

    private List<GrowthRecordListRes> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}