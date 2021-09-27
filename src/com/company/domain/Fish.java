package com.company.domain;

import com.company.enumeration.Gender;

import java.util.Date;
import java.util.Random;

public class Fish {

    private long id;

    private String name;

    private Gender gender;

    private int life;

    private boolean married;

    private Date birth_day;

    public Fish(long id, Gender gender) {
        this.id = id;
        this.name = "Fish_" + id;
        this.gender = gender;
        this.life = new Random().nextInt(5);
        married = false;
        this.birth_day = new Date();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getLife() {
        return life;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Date getBirth_day() {
        return birth_day;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", life=" + life +
                ", birth_day=" + birth_day +
                '}';
    }
}
