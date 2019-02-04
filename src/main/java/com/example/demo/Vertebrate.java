package com.example.demo;

import java.time.LocalDate;

public class Vertebrate extends Animal {

    protected int bones;
    protected int brokenBones;

    public Vertebrate(String name, String gender, LocalDate dateOfBirth, LocalDate lastTimeFed,
                      int bones) {
        super(name, gender, dateOfBirth, lastTimeFed);
        this.bones = bones;
        this.brokenBones = 0;
    }
}
