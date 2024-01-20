package com.example.scbaby.Bean.GrowthRecordBean;

import com.example.scbaby.Model.DAO.BabyDAO;
import com.example.scbaby.Model.DAO.GrowthRecordDAO;
import com.example.scbaby.Model.DTO.GrowthRecord.Res.GrowthRecordGetRes;
import com.example.scbaby.Model.DTO.GrowthRecord.Res.PageResponseDto;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.GrowthRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GrowthRecordGetBean {

    private final GrowthRecordRepository growthRecordRepository;
    private final BabyRepository babyRepository;

    public PageResponseDto exec(int pageNo, int pageSize, Long babyId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("dateTime").ascending());
        Page<GrowthRecordDAO> growthRecordDAOPage = null;

        if (babyRepository.findById(babyId).isPresent()) {
            BabyDAO babyDAO = babyRepository.findById(babyId).get();
            growthRecordDAOPage = growthRecordRepository.findAllByBaby(pageable, babyDAO);
        }

        List<GrowthRecordDAO> growthRecordDAOList = growthRecordDAOPage.getContent();

        List<GrowthRecordGetRes> content = growthRecordDAOList.stream()
                .map(growthRecordDAO -> GrowthRecordGetRes.builder()
                        .height(growthRecordDAO.getHeight())
                        .weight(growthRecordDAO.getWeight())
                        .headSize(growthRecordDAO.getHeadSize())
                        .dateTime(growthRecordDAO.getDateTime())
                        .build())
                .collect(Collectors.toList());


        return PageResponseDto.builder()
                .content(content)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalElements(growthRecordDAOPage.getTotalElements())
                .totalPages(growthRecordDAOPage.getTotalPages())
                .last(growthRecordDAOPage.isLast())
                .build();
    }
}
