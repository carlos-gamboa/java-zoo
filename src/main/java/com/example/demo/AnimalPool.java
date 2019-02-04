package com.example.demo;

import java.util.Random;

public class AnimalPool {


    public static String getRandomSpecies() {
        String[] species = new String[] {"Cow", "Horse", "Elephant"};
        Random random = new Random();
        int n = random.nextInt(species.length);
        return species[n];
    }

    public static String getRandomName() {
        String[] names = new String[] {"Charlie", "Jeffrey", "Silvia", "Bailin", "Alonso", "Alvaro",
                "Tenorio", "Elías", "Sebastián", "Mariam", "Jorge", "Josué"};
        Random random = new Random();
        int n = random.nextInt(names.length);
        return names[n];
    }
}
