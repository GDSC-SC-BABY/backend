package com.example.scbaby;


import com.example.scbaby.Bean.BabyBean.BabyRegistBean;
import com.example.scbaby.Bean.BabyFood.BabyFoodPostBean;
import com.example.scbaby.Bean.BathBean.BathRegistBean;
import com.example.scbaby.Bean.DefecationBean.DefecationRegistBean;
import com.example.scbaby.Bean.GrowthRecordBean.GrowthRecordRegistBean;
import com.example.scbaby.Bean.MedicineBean.MedicineRegistBean;
import com.example.scbaby.Bean.SleepBean.SleepRegistBean;
import com.example.scbaby.Bean.Snack.SnackPostBean;
import com.example.scbaby.Bean.UserBean.UserRegistBean;
import com.example.scbaby.Model.DTO.Baby.Req.BabyRegistReq;
import com.example.scbaby.Model.DTO.BabyFood.Req.BabyFoodPostReq;
import com.example.scbaby.Model.DTO.Bath.Req.BathRegistReq;
import com.example.scbaby.Model.DTO.Defecation.Req.DefecationRegistReq;
import com.example.scbaby.Model.DTO.GrowthRecord.Req.GrowthRecordRegistReq;
import com.example.scbaby.Model.DTO.Medicine.Req.MedicineRegistReq;
import com.example.scbaby.Model.DTO.Sleep.Req.SleepRegistReq;
import com.example.scbaby.Model.DTO.Snack.Req.SnackPostReq;
import com.example.scbaby.Model.DTO.User.Req.UserRegistReq;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TestData {

    private final UserRegistBean userRegistBean;
    private final BabyRegistBean babyRegistBean;
    private final SleepRegistBean sleepRegistBean;
    private final DefecationRegistBean defecationRegistBean;
    private final BathRegistBean bathRegistBean;
    private final GrowthRecordRegistBean growthRecordRegistBean;
    private final SnackPostBean snackPostBean;
    private final BabyFoodPostBean babyFoodPostBean;

    public TestData(UserRegistBean userRegistBean, BabyRegistBean babyRegistBean, SleepRegistBean sleepRegistBean, MedicineRegistBean medicineRegistBean, DefecationRegistBean defecationRegistBean, BathRegistBean bathRegistBean, GrowthRecordRegistBean growthRecordRegistBean, SnackPostBean snackPostBean, BabyFoodPostBean babyFoodPostBean) {
        this.userRegistBean = userRegistBean;
        this.babyRegistBean = babyRegistBean;
        this.sleepRegistBean = sleepRegistBean;
        this.medicineRegistBean = medicineRegistBean;
        this.defecationRegistBean = defecationRegistBean;
        this.bathRegistBean = bathRegistBean;
        this.growthRecordRegistBean = growthRecordRegistBean;
        this.snackPostBean = snackPostBean;
        this.babyFoodPostBean = babyFoodPostBean;
    }

    @Test
    public void userData(){

        List<String> RelationList = List.of(new String[]{
                "아빠", "엄마", "할아버지", "할머니", "삼촌", "이모", "형", "누나", "동생", "친구"
        });

        for(int i = 0; i < 4; i++){
            UserRegistReq userRegistReq = UserRegistReq.builder()
                    .userId("user" + i)
                    .name("name" + i)
                    .relation(RelationList.get(i))
                    .imageUri("data:image/jpeg;base64,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")
                    .build();
            userRegistBean.exec(userRegistReq);
        }
    }

    @Test
    public void babyData() throws IOException {

        for (int i = 0; i < 10; i++) {
            BabyRegistReq babyRegistReq = BabyRegistReq.builder()
                    .name("babyName" + i)
                    .gender(i % 2 == 0 ? "남자" : "여자")
                    .dateTime(LocalDateTime.now())
                    .imgUrl("data:image/jpeg;base64,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")
                    .birthHeight("birthHeight" + i)
                    .birthWeight("birthWeight" + i)
                    .userId("user" + i % 4)
                    .build();
            babyRegistBean.exec(babyRegistReq);
        }
    }

    @Test
    public void sleepData() {

        for(int i = 0; i < 10; i++){
            SleepRegistReq sleepRegistReq = SleepRegistReq.builder()
                    .babyId((long) (i + 1))
                    .startTime(LocalDateTime.now())
                    .endTime(LocalDateTime.now().plusHours(1))
                    .memo("memo" + i)
                    .build();
            sleepRegistBean.exec(sleepRegistReq, sleepRegistReq.getBabyId());
        }
    }

    private final MedicineRegistBean medicineRegistBean;

    @Test
    public void medicineData() {

        for(int i = 0; i < 10; i++){
             MedicineRegistReq medicineRegistReq = MedicineRegistReq.builder()
                     .babyId((long) (i + 1))
                     .startTime(LocalDateTime.now())
                     .medicineType("medicineType" + i)
                     .memo("memo" + i)
                     .build();
            medicineRegistBean.exec(medicineRegistReq, medicineRegistReq.getBabyId());
        }
    }

    @Test
    public void defecationData() {

        for(int i = 0; i < 10; i++){
            DefecationRegistReq defecationRegistReq = DefecationRegistReq.builder()
                    .babyId((long) (i + 1))
                    .startTime(LocalDateTime.now())
                    .defecationStatus("defecationStatus" + i)
                    .memo("memo" + i)
                    .build();
            defecationRegistBean.exec(defecationRegistReq, defecationRegistReq.getBabyId());
        }
    }

    @Test
    public void bathData() {

        for(int i = 0; i < 10; i++){
            BathRegistReq bathRegistReq = BathRegistReq.builder()
                    .babyId((long) (i + 1))
                    .startTime(LocalDateTime.now())
                    .endTime(LocalDateTime.now().plusHours(1))
                    .memo("memo" + i)
                    .build();
            bathRegistBean.exec(bathRegistReq, bathRegistReq.getBabyId());
        }
    }

    @Test
    public void growthRecordData() {

        for(int i = 0; i < 10; i++){
             GrowthRecordRegistReq growthRecordRegistReq = GrowthRecordRegistReq.builder()
                     .babyId((long) (i + 1))
                     .height(i + 1)
                     .weight(i + 1)
                     .headSize(i + 1)
                     .dateTime(LocalDateTime.now())
                     .build();
            growthRecordRegistBean.exec(growthRecordRegistReq, growthRecordRegistReq.getBabyId());
        }
    }

    @Test
    public void snackData() {

        List<SnackPostReq.Topping> toppingList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 5; j++) {
                SnackPostReq.Topping topping = SnackPostReq.Topping.builder()
                        .name("name" + j)
                        .hasAllergy(j % 2 == 0)
                        .build();
                toppingList.add(topping);
            }
            
            SnackPostReq snackPostReq = SnackPostReq.builder()
                    .babyId((long) (i + 1))
                    .imageUrl("https://oasisproduct.cdn.ntruss.com/64351/detail/detail_64351_1_5b28d026-39e6-440b-b98d-7972411d9d8d.jpg")
                    .dateTime(LocalDateTime.now())
                    .amount(i + 1)
                    .specialNote("specialNote" + i)
                    .toppingList(toppingList)
                    .build();

            snackPostBean.exec(snackPostReq);
        }
    }

    @Test
    public void babyFoodData() {

        List<BabyFoodPostReq.Topping> toppingList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 5; j++) {
                BabyFoodPostReq.Topping topping = BabyFoodPostReq.Topping.builder()
                        .name("name" + j)
                        .amount(i + 1)
                        .build();
                toppingList.add(topping);
            }

            BabyFoodPostReq babyFoodPostReq = BabyFoodPostReq.builder()
                    .babyId((long) (i + 1))
                    .imageUrl("https://oasisproduct.cdn.ntruss.com/64351/detail/detail_64351_1_5b28d026-39e6-440b-b98d-7972411d9d8d.jpg")
                    .dateTime(LocalDateTime.now())
                    .amount(i + 1)
                    .specialNote("specialNote" + i)
                    .basePorridgeName("basePorridgeName" + i)
                    .toppingList(toppingList)
                    .build();

            babyFoodPostBean.exec(babyFoodPostReq);
        }
    }
}
