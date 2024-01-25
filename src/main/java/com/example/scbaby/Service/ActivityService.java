package com.example.scbaby.Service;

import com.example.scbaby.Bean.ActivityBean.ActivityListGetBean;
import com.example.scbaby.Model.DTO.Activity.Res.ActivityListGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityListGetBean activityListGetBean;

    @Transactional(readOnly = true)
    public List<ActivityListGetRes> getBabyActivityListByBabyIdAndDate (Long babyId, LocalDate specificDate) {
        return activityListGetBean.exec(babyId, specificDate);
    }

}
