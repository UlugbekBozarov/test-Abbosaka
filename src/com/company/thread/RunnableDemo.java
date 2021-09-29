package com.company.thread;

import com.company.domain.Fish;
import com.company.domain.MarriedFish;
import com.company.enumeration.Gender;
import com.company.generated.GenerateIdAuto;
import com.company.repository.FishRepo;
import com.company.repository.MarriedFishRepo;
import com.company.services.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunnableDemo implements Runnable {

    private Thread t;

    private Fish fish;

    private FishRepo fishRepo;

    private MarriedFishRepo marriedFishRepo;

    private Services services;

    private GenerateIdAuto idAuto;

    public RunnableDemo(Fish fish, FishRepo fishRepo, MarriedFishRepo marriedFishRepo, Services services, GenerateIdAuto idAuto) {
        this.fish = fish;
        this.fishRepo = fishRepo;
        this.idAuto = idAuto;
        this.marriedFishRepo = marriedFishRepo;
        this.services = services;
    }

    public void run() {
        Random random = new Random();
        try {
            MarriedFish marriedFish = null;
            for (int i = 0; i < fish.getLife(); i++) {
                if (i == fish.getLife() - 1) {
                    fishRepo.removeFish(fish);
                    System.out.println(fish.getName() + " baliq o'ldi.");
                } else {
                    if (i == 0 && fish.getLife() >= 2) {
                        System.out.println(fish.getName() + " - nomli baliq ulg'aydi");
                    } else if (i == 1 && fish.getLife() >= 3) {
                        if (fish.getGender() == Gender.MALE) {
                            if (!marriedFishRepo.containsMalefish(fish)) {
                                List<Fish> list = new ArrayList<>();
                                for (int j = 0; j < fishRepo.getFishSize(); j++) {
                                    if (fishRepo.getFishList().get(j) != null && fishRepo.getFishList().get(j).getLife() == 4 && fishRepo.getFishList().get(j).getGender().equals(Gender.FEMALE)) {
                                        list.add(fishRepo.getFishList().get(j));
                                    }
                                }
                                if (list.size() > 0) {
                                    Fish femalefish = list.get(random.nextInt(list.size()));
                                    fishRepo.removeFish(femalefish);
                                    marriedFish = new MarriedFish(fish, femalefish);
                                    marriedFishRepo.createMarridfish(marriedFish);
                                    System.out.println("Ikki baliq juftlashidi: " + marriedFish.toString());
                                    fishRepo.removeFish(fish);
                                }
                            } else {
                                fishRepo.removeFish(fish);
                            }
                        } else {
                            if (!marriedFishRepo.containsFemalefish(fish)) {
                                List<Fish>list = new ArrayList<>();
                                for (int j = 0; j < fishRepo.getFishSize(); j++) {
                                    if (fishRepo.getFishList().get(j) != null && fishRepo.getFishList().get(j).getLife() == 4 && fishRepo.getFishList().get(j).getGender().equals(Gender.MALE)) {
                                        list.add(fishRepo.getFishList().get(j));
                                    }
                                }
                                if (list.size() > 0) {
                                    Fish malefish = list.get(random.nextInt(list.size()));
                                    fishRepo.removeFish(malefish);
                                    marriedFish = new MarriedFish(malefish, fish);
                                    marriedFishRepo.createMarridfish(marriedFish);
                                    System.out.println("Ikki baliq juftlashdi: " + marriedFish.toString());
                                    fishRepo.removeFish(fish);
                                }
                            } else {
                                fishRepo.removeFish(fish);
                            }
                        }
                    } else if (i == 2 && fish.getLife() >= 4) {
                        if (marriedFish != null && fish.getGender().equals(Gender.MALE)) {
                            int child_malefish = random.nextInt(100);
                            int child_femalefish = random.nextInt(100);
                            System.out.println(marriedFish.toString() + " baliqlar ko'payishdi. Ulardan " + child_malefish + " ta erkak va " + child_femalefish + " ta urgochi baliq dunyoga keldi.");
                            services.createFish(child_malefish, child_femalefish);
                            for (int j = 0; j < fishRepo.getFishSize(); j++) {

                                if (fishRepo.getFishList().get(j) != null && fishRepo.getFishList().get(j).getLife() > 0) {
                                    new RunnableDemo(fishRepo.getFishList().get(j), fishRepo, marriedFishRepo, services, idAuto).start();
                                } else {
                                    if (fishRepo.getFishList().contains(fishRepo.getFishList().get(j))) {
                                        fishRepo.removeFish(fishRepo.getFishList().get(j));
                                        System.out.println(fish.getName() + " baliq o'ldi.");
                                    }
                                }
                            }
                        }
                    }
                }

                Thread.sleep((2000));
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, fish.toString());
            t.start ();
        }
    }
}