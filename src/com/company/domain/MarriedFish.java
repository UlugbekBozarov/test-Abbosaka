package com.company.domain;

public class MarriedFish {

    private Fish male_fish;

    private Fish female_fish;

    public MarriedFish(Fish male_fish, Fish female_fish) {
        this.male_fish = male_fish;
        this.female_fish = female_fish;
    }

    public Fish getMale_fish() {
        return male_fish;
    }

    public Fish getFemale_fish() {
        return female_fish;
    }

    @Override
    public String toString() {
        return "MarriedFish{" +
                "male_fish=" + male_fish +
                ", female_fish=" + female_fish +
                '}';
    }
}
