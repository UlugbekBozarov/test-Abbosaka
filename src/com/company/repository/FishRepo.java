package com.company.repository;

import com.company.domain.Fish;
import java.util.List;

public class FishRepo {

    private List<Fish> fishList;

    public FishRepo(List<Fish> fishList) {
        this.fishList = fishList;
    }

    public void createFish(Fish fish) {
        this.fishList.add(fish);
    }

    public List<Fish> getFishList() {
        return this.fishList;
    }

    public void removeFish(Fish fish) {
        if (fish != null && fishList.contains(fish)) {
            fishList.remove(fish);
        }
    }

    public boolean contains(Fish fish) {
        return this.fishList.contains(fish);
    }

    public long getFishSize() {
        return this.fishList.size();
    }
}
