package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Zookeeper extends Person implements Employee {
    private ArrayList<Species> animalsInCharge;

    public Zookeeper (String name, int age) {
        super.name = name;
        super.age = age;
        animalsInCharge = new ArrayList<Species>();
    }

    @Override
    public void feedAnimal(Animal animal) {
        LocalDate today = LocalDate.now();
        animal.setLastTimeFed(today);
        System.out.println(this.getName() + ": I just fed a " + animal.toString() + ".");
    }

    @Override
    public void clean() {
        System.out.println(this.getName() + ": I am cleaning the zoo!");
    }

    public void assignAnimal(Species animal) {
        this.animalsInCharge.add(animal);
        System.out.println(super.getName() + ": I am now in charge of " + animal.toString() + ".");
    }

    public String getAnimalsInCharge() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Species anAnimalsInCharge : this.animalsInCharge) {
            stringBuilder.append(anAnimalsInCharge.getName());
        }
        return stringBuilder.toString();
    }
}
