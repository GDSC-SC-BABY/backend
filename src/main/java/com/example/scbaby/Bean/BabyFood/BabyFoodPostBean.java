package com.example.scbaby.Bean.BabyFood;

import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DAO.BasePorridgeDAO;
import com.example.scbaby.Model.DAO.ToppingDAO;
import com.example.scbaby.Model.DTO.BabyFood.Req.BabyFoodPostReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.BabyFoodRepository;
import com.example.scbaby.Repository.BabyRepository;
import com.example.scbaby.Repository.BasePorridgeRepository;
import com.example.scbaby.Repository.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BabyFoodPostBean {
    private final BabyFoodRepository babyFoodRepository;
    private final BabyRepository babyRepository;
    private final BasePorridgeRepository basePorridgeRepository;
    private final ToppingRepository toppingRepository;

    public StateRes exec(BabyFoodPostReq babyFoodPostReq) {
        BabyFoodDAO babyFoodDAO = BabyFoodDAO.builder()
                .baby(babyRepository.findByBabyId(babyFoodPostReq.getBabyId()))
                .dateTime(babyFoodPostReq.getDateTime())
                .amount(babyFoodPostReq.getAmount())
                .imageUrl(babyFoodPostReq.getImageUrl())
                .specialNote(babyFoodPostReq.getSpecialNote())
                .build();

        BabyFoodDAO saveBabyFoodDAO = babyFoodRepository.save(babyFoodDAO);

        BasePorridgeDAO basePorridgeDAO = BasePorridgeDAO.builder()
                .babyFood(saveBabyFoodDAO)
                .basePorridgeName(babyFoodPostReq.getBasePorridgeName())
                .build();
        basePorridgeRepository.save(basePorridgeDAO);

        for(int i=0;i<babyFoodPostReq.getToppingList().size();i++) {
            ToppingDAO toppingDAO = ToppingDAO.builder()
                    .babyFood(saveBabyFoodDAO)
                    .toppingName(babyFoodPostReq.getToppingList().get(i).getName())
                    .amount(babyFoodPostReq.getToppingList().get(i).getAmount())
                    .build();
            toppingRepository.save(toppingDAO);
        }

        return new StateRes(true);
    }



}
