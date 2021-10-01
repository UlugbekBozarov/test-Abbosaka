package com.company.services;

import com.company.domain.Fish;
import com.company.enumeration.Gender;
import com.company.generated.GenerateIdAuto;
import com.company.repository.FishRepo;

public class Services {

    private FishRepo fishRepo;

    private GenerateIdAuto auto;

    public Services(FishRepo fishRepo, GenerateIdAuto auto) {
        this.fishRepo = fishRepo;
        this.auto = auto;
    }

    public void createOneFish(int malefish, int femalefish) {
        System.out.println("Erkaka baliqlar: " + malefish +
                " ta, Urg'ochi baliqlar: " + femalefish + " ta." +
                "\n\nAkvariumga tushgan baliqlar soni: " + (malefish + femalefish) + " ta.");
        for (int i = 0; i < malefish; i++) {
            Fish fish = new Fish(auto.getId(), Gender.MALE);
            fishRepo.createFish(fish);
        }
        for (int i = 0; i < femalefish; i++) {
            Fish fish = new Fish(auto.getId(), Gender.FEMALE);
            fishRepo.createFish(fish);
        }
    }

    public void createFish(int malefish, int femalefish) {
        for (int i = 0; i < malefish; i++) {
            Fish fish = new Fish(auto.getId(), Gender.MALE);
            fishRepo.createFish(fish);
        }
        for (int i = 0; i < femalefish; i++) {
            Fish fish = new Fish(auto.getId(), Gender.FEMALE);
            fishRepo.createFish(fish);
        }
        System.out.println(fishRepo.toString());
    }

}
