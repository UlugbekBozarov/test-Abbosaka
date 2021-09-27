package com.company.repository;

import com.company.domain.Fish;
import com.company.domain.MarriedFish;

import java.util.List;

public class MarriedFishRepo {

    private List<MarriedFish> marriedFishList;

    public MarriedFishRepo(List<MarriedFish> marriedFishList) {
        this.marriedFishList = marriedFishList;
    }

    public void createMarridfish(MarriedFish marriedFish) {
        marriedFishList.add(marriedFish);
    }

    public boolean containsMalefish(Fish fish) {
        for (int i = 0; i < marriedFishList.size(); i++) {
            if (marriedFishList.get(i).getMale_fish() == fish) {
                return true;
            }
        }
        return false;
    }

    public boolean containsFemalefish(Fish fish) {
        for (int i = 0; i < marriedFishList.size(); i++) {
            if (marriedFishList.get(i).getFemale_fish() == fish) {
                return true;
            }
        }
        return false;
    }
}
