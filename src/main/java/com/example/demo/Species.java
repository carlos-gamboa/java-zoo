package com.example.demo;

import java.time.LocalDate;
import java.util.Random;

public class Species extends Vertebrate {

    private String speciesName;
    private BirthMethod birthMethod;
    private double reproductionChance;


    public Species(String name, String gender, LocalDate dateOfBirth, LocalDate lastTimeFed, int bones) {
        super(name, gender, dateOfBirth, lastTimeFed, bones);
    }

    public Species(String name, String gender, LocalDate dateOfBirth, LocalDate lastTimeFed, int bones,
                   String speciesName) {
        super(name, gender, dateOfBirth, lastTimeFed, bones);
        this.speciesName = speciesName;
        this.reproductionChance = 0.5;
    }

    public Species(String name, String gender, LocalDate dateOfBirth, LocalDate lastTimeFed, int bones,
                   String speciesName, BirthMethod birthMethod, double reproductionChance) {
        super(name, gender, dateOfBirth, lastTimeFed, bones);
        this.speciesName = speciesName;
        this.birthMethod = birthMethod;
        this.reproductionChance = reproductionChance;
    }

    public Species mate(Species couple) {
        if (this.equals(couple)) {
            Random random = new Random();
            if (random.nextDouble() > this.reproductionChance) {
                String babiesName = this.getName() + "+" + couple.getName();
                LocalDate today = LocalDate.now();
                System.out.println(">> " + this.toString() + " just had a baby with " + couple.toString());
                return new Species(babiesName, "", today, null, this.bones, this.speciesName,
                        this.birthMethod, this.reproductionChance);
            }
            else {
                System.out.println(this.toString() + " tried to have a baby with " + couple.toString() +
                        " but the sperm was weak.");
            }
        }
        else {
            System.out.println(this.toString() + " couldn't mate with " + couple.toString() +
                    " because they are not the same species.");
        }
        return null;
    }

    public void die() {
        super.isAlive = false;
        System.err.println(this.toString() + " just died.");
    }

    public boolean equals(Species species) {
        return this.speciesName.equals(species.speciesName);
    }

    public String toString() {
        return super.name + " the " + this.speciesName;
    }
}
