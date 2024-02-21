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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestData {

    private final UserRegistBean userRegistBean;
    private final BabyRegistBean babyRegistBean;
    private final SleepRegistBean sleepRegistBean;
    private final DefecationRegistBean defecationRegistBean;
    private final BathRegistBean bathRegistBean;
    private final GrowthRecordRegistBean growthRecordRegistBean;
    private final SnackPostBean snackPostBean;
    private final BabyFoodPostBean babyFoodPostBean;

    @Autowired
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
    public void TestDataImport() throws IOException {
        userData();
        babyData();
        sleepData();
        medicineData();
        defecationData();
        bathData();
        growthRecordData();
        snackData();
        babyFoodData();
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
                    .imageUri("https://img.freepik.com/free-photo/portrait-of-white-man-isolated_53876-40306.jpg?size=626&ext=jpg&ga=GA1.1.632798143.1708473600&semt=ais")
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
                    .imgUrl("https://health.chosun.com/site/data/img_dir/2020/03/09/2020030901652_0.jpg")
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
                        .hasAllergy(false)
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
                    .imageUrl("https://i.namu.wiki/i/92of6qgixR3Ek99iZDDcYGU8OL09KEXvUBCQve2UuFK9uJHdzsoCLlTX_QXFCX4DCw_i39A4zSOoSpu_Isa73w.webp")
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
