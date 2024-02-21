package com.example.scbaby.Bean.Snack;

import com.example.scbaby.Model.DAO.*;
import com.example.scbaby.Model.DTO.Snack.Req.SnackPostReq;
import com.example.scbaby.Model.DTO.StateRes;
import com.example.scbaby.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SnackPostBean {
    private final SnackRepository snackRepository;
    private final BabyRepository babyRepository;
    private final ToppingRepository toppingRepository;

    public StateRes exec(SnackPostReq snackPostReq) {
        SnackDAO snackDAO = SnackDAO.builder()
                .baby(babyRepository.findByBabyId(snackPostReq.getBabyId()))
                .dateTime(snackPostReq.getDateTime())
                .amount(snackPostReq.getAmount())
                .imageUrl(snackPostReq.getImageUrl())
                .SpecialNote(snackPostReq.getSpecialNote())
                .build();

        SnackDAO saveSnackDAO = snackRepository.save(snackDAO);


        for(int i=0;i<snackPostReq.getToppingList().size();i++) {
            ToppingDAO toppingDAO = ToppingDAO.builder()
                    .snack(saveSnackDAO)
                    .toppingName(snackPostReq.getToppingList().get(i).getName())
                    .isAllergy(snackPostReq.getToppingList().get(i).isHasAllergy())
                    .build();
            toppingRepository.save(toppingDAO);
        }

        return new StateRes(true);
    }



}
