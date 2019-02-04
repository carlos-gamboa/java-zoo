package com.example.demo;

import java.time.LocalDate;

public class Animal {
    protected String name;
    protected String gender;
    protected LocalDate dateOfBirth;
    protected LocalDate lastTimeFed;

    public Animal(String name, String gender, LocalDate dateOfBirth, LocalDate lastTimeFed) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.lastTimeFed = lastTimeFed;
    }

    public String getName() {
        return name;
    }

    public void setLastTimeFed(LocalDate lastTimeFed) {
        this.lastTimeFed = lastTimeFed;
    }
}
