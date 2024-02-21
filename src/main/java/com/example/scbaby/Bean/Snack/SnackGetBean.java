package com.example.scbaby.Bean.Snack;

import com.example.scbaby.Model.DAO.*;
import com.example.scbaby.Model.DTO.Snack.Res.SnackDetailGetRes;
import com.example.scbaby.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SnackGetBean {
    private final SnackRepository snackRepository;
    private final ToppingRepository toppingRepository;

    public SnackDetailGetRes exec(Long snackId) {
        SnackDAO snackDAO = snackRepository.findBySnackId(snackId);

        List<ToppingDAO> toppingNames = toppingRepository.findBySnack(snackDAO);
        List<SnackDetailGetRes.Topping> toppingList = toppingNames.stream()
                .map(toppingDAO -> SnackDetailGetRes.Topping.builder()
                        .name(toppingDAO.getToppingName())
                        .hasAllergy(toppingDAO.isAllergy())
                        .build())
                .toList();


        SnackDetailGetRes snackDetailGetRes = SnackDetailGetRes.builder()
                .dateTime(snackDAO.getDateTime())
                .amount(snackDAO.getAmount())
                .imageUrl(snackDAO.getImageUrl())
                .toppingList(toppingList)
                .build();

        return snackDetailGetRes;
    }
}
