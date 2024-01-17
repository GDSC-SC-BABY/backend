package com.example.scbaby.Bean.BabyFood;

import com.example.scbaby.Model.DAO.BabyFoodDAO;
import com.example.scbaby.Model.DAO.BasePorridgeDAO;
import com.example.scbaby.Model.DAO.ToppingDAO;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodDetailGetRes;
import com.example.scbaby.Model.DTO.BabyFood.Res.BabyFoodGetRes;
import com.example.scbaby.Repository.BabyFoodRepository;
import com.example.scbaby.Repository.BasePorridgeRepository;
import com.example.scbaby.Repository.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BabyFoodGetBean {
    private final BabyFoodRepository babyFoodRepository;
    private final ToppingRepository toppingRepository;
    private final BasePorridgeRepository basePorridgeRepository;

    public BabyFoodDetailGetRes exec(Long babyFoodId) {
        BabyFoodDAO babyFoodDAO = babyFoodRepository.findByBabyFoodId(babyFoodId);

        List<BasePorridgeDAO> basePorridgeDAOS = basePorridgeRepository.findByBabyFood(babyFoodDAO);
        List<BabyFoodDetailGetRes.BasePorridge> basePorridgeList = basePorridgeDAOS.stream()
                .map(basePorridgeDAO -> BabyFoodDetailGetRes.BasePorridge.builder()
                        .name(basePorridgeDAO.getBasePorridgeName())
                        .hasAllergy(basePorridgeDAO.isAllergy())
                        .build())
                .toList();

        List<ToppingDAO> toppingNames = toppingRepository.findByBabyFood(babyFoodDAO);
        List<BabyFoodDetailGetRes.Topping> toppingList = toppingNames.stream()
                .map(toppingDAO -> BabyFoodDetailGetRes.Topping.builder()
                        .name(toppingDAO.getToppingName())
                        .hasAllergy(toppingDAO.isAllergy())
                        .build())
                .toList();


        BabyFoodDetailGetRes babyFoodDetailGetRes = BabyFoodDetailGetRes.builder()
                .dateTime(babyFoodDAO.getDateTime())
                .amount(babyFoodDAO.getAmount())
                .imageUrl(babyFoodDAO.getImageUrl())
                .SpecialNote(babyFoodDAO.getSpecialNote())
                .basePorridgeList(basePorridgeList)
                .toppingList(toppingList)
                .build();

        return babyFoodDetailGetRes;
    }
}
