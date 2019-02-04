package com.example.demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Zookeeper extends Person implements Employee {
    private ArrayList<Species> allAnimals;
    private ArrayList<Species> animalsInCharge;
    private Random random;

    public Zookeeper (ArrayList<Species> allAnimals, String name, int age) {
        super.name = name;
        super.age = age;
        this.allAnimals = allAnimals;
        animalsInCharge = new ArrayList<Species>();
        this.random = new Random();
    }

    @Override
    public void feedAnimal() {
        if (this.animalsInCharge.size() > 0){
            Species animal = this.animalsInCharge.get(this.random.nextInt(this.animalsInCharge.size()));
            if (animal.isAlive()) {
                LocalDate today = LocalDate.now();
                animal.setLastTimeFed(today);
                System.out.println(this.getName() + ": I just fed " + animal.toString() + ".");
            }
            else {
                int animalInChargeIndex = this.animalsInCharge.indexOf(animal);
                this.animalsInCharge.remove(animalInChargeIndex);
                System.err.println(this.getName() + ": I just found " + animal.toString() + " dead.");
                this.allAnimals.remove(animal);
                System.out.println("The remains of " + animal.toString() + " were removed from the zoo.");
            }
        }
        else {
            System.out.println(this.getName() + ": I don't have any animals to feed.");
        }
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
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public  ArrayList<Species>  wasFired(){
        System.out.println("&& " + this.getName() +" was fired.");
        System.out.println("&& " + this.name + " had: " + this.getAnimalsInCharge());
        return this.animalsInCharge;
    }

    public ArrayList<Species>  quit(){
        System.out.println("&& " + this.getName() +" quit.");
        System.out.println("&& " + this.name + " had: " + this.getAnimalsInCharge());
        return this.animalsInCharge;
    }
}
