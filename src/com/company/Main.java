package com.company;

import com.company.domain.Fish;
import com.company.domain.MarriedFish;
import com.company.enumeration.Gender;
import com.company.generated.GenerateIdAuto;
import com.company.repository.FishRepo;
import com.company.repository.MarriedFishRepo;
import com.company.services.Services;
import com.company.thread.RunnableDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        List<Fish> fishList = new ArrayList<>();
        List<MarriedFish> marriedFishList = new ArrayList<>();

        FishRepo fishRepo = new FishRepo(fishList);
        MarriedFishRepo marriedFishRepo = new MarriedFishRepo(marriedFishList);
        GenerateIdAuto idAuto = new GenerateIdAuto();

        Services services = new Services(fishRepo, idAuto);

        int malefish = random.nextInt(40);
        int femalefish = random.nextInt(40);

        services.createOneFish(malefish, femalefish);

        try {
//            System.out.println(fishRepo.getFishList().toString());
//            do {
//
//                Thread.sleep((9000));
//            } while (fishRepo.getFishSize() > 0);
            for (int i = 0; i < fishRepo.getFishSize(); i++) {
                if (fishRepo.getFishList().get(i) != null && fishRepo.getFishList().get(i).getLife() > 0) {
                    new RunnableDemo(fishRepo.getFishList().get(i), fishRepo, marriedFishRepo, services, idAuto).start();
                } else {
                    fishRepo.removeFish(fishRepo.getFishList().get(i));
                    System.out.println(fishRepo.getFishList().get(i).getName() + " baliq o'ldi.");
                }
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted: " + e);
        }

    }
}
