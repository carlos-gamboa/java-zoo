package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Zoo {
    private Random random;
    private ArrayList<Species> animals;
    private ArrayList<Zookeeper> people;
    private LocalTime openingTime;

    public void stockZoo(int numberOfAnimals, int numberOfEmployees) {
        this.animals = new ArrayList<Species>();
        this.people = new ArrayList<Zookeeper>();
        this.random = new Random();

        for (int i = 0; i < numberOfAnimals; ++i) {
            this.buyAnimal();
        }

        for (int i = 0; i < numberOfEmployees; ++i) {
            this.hireEmployee();
        }

        this.assignAnimalsToEmployees();
    }

    public void openZoo() {
        this.openingTime = LocalTime.now();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-------------------------------\n");
        stringBuilder.append("--- The Zoo opened at ");
        stringBuilder.append(this.openingTime.getHour());
        stringBuilder.append(":");
        stringBuilder.append(this.openingTime.getMinute());
        stringBuilder.append(" ---\n");
        stringBuilder.append("-------------------------------\n");
        System.out.println(stringBuilder.toString());

        this.startZoo();
    }

    public void startZoo() {
        LocalTime closingTime = this.openingTime.plusSeconds(20);
        int zookeeperIndex;
        int animalIndex;
        int coupleIndex;
        while (LocalTime.now().isBefore(closingTime)) {
            switch (this.random.nextInt(4)) {
                case 0:
                    zookeeperIndex = this.random.nextInt(this.people.size());
                    this.people.get(zookeeperIndex).clean();
                    break;
                case 1:
                    zookeeperIndex = this.random.nextInt(this.people.size());
                    animalIndex = random.nextInt(this.animals.size());
                    this.people.get(zookeeperIndex).feedAnimal(this.animals.get(animalIndex));
                    break;
                case 2:
                    animalIndex = random.nextInt(this.animals.size());
                    coupleIndex = random.nextInt(this.animals.size());
                    Species baby = this.animals.get(animalIndex).mate(this.animals.get(coupleIndex));
                    if (baby != null) {
                        this.animals.add(baby);
                        zookeeperIndex = this.random.nextInt(this.people.size());
                        this.people.get(zookeeperIndex).assignAnimal(baby);
                    }
                    break;
                case 3:
                    LocalDate birth = LocalDate.now();
                    Species species = new Species(AnimalPool.getRandomName(), "M", birth, null, random.nextInt(250)+1, AnimalPool.getRandomSpecies(), null, this.random.nextDouble());
                    this.buyAnimal(species);
                    break;
                case 4:
                    Zookeeper person = new Zookeeper(AnimalPool.getRandomName(), this.random.nextInt(60) + 16);
                    this.hireEmployee(person);
                    break;
                case 5:
                    break;
                case 6:
                    if(this.people.size()>1) {
                        zookeeperIndex = this.random.nextInt(this.people.size());
                        ArrayList<Species> animals = this.people.get(zookeeperIndex).wasFired();
                        this.reasigAnimals(zookeeperIndex, animals);
                        System.out.println("&& All the animals are reassigned");
                    }
                    break;
                case 7:
                    if(this.people.size()>1) {
                        zookeeperIndex = this.random.nextInt(this.people.size());
                        ArrayList<Species> animals = this.people.get(zookeeperIndex).quit();
                        this.reasigAnimals(zookeeperIndex, animals);
                        System.out.println("&& All the animals are reassigned");
                    }
                    break;
            }
            this.waitZoo();
        }
    }

    private void reasigAnimals(int zookeeperIndex, ArrayList<Species> animals){
        this.people.remove(zookeeperIndex);
        for (int i = 0; i < animals.size(); i++) {
            zookeeperIndex = this.random.nextInt(this.people.size());
            this.people.get(zookeeperIndex).assignAnimal(animals.get(i));
        }
    }

    public void waitZoo() {
        try
        {
            Thread.sleep(500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void buyAnimal() {
        LocalDate today = LocalDate.now();
        Species newAnimal = new Species(AnimalPool.getRandomName(), "F", today, null,
                8, AnimalPool.getRandomSpecies());
        this.animals.add(newAnimal);
        System.out.println("$$ The zoo bought " + newAnimal.toString());
    }

    public void buyAnimal(Species animal) {
        this.animals.add(animal);
        System.out.println("$$ The zoo bought " + animal.toString());
    }

    public void hireEmployee (Zookeeper employee) {
        this.people.add(employee);
        System.out.println("## The zoo just hired " + employee.getName());
    }

    public void hireEmployee () {
        Zookeeper newEmployee = new Zookeeper(AnimalPool.getRandomName(), this.random.nextInt(50) + 16);
        this.people.add(newEmployee);
        System.out.println("## The zoo just hired " + newEmployee.getName());
    }

    public void assignAnimalsToEmployees() {
        int employeeIndex;
        for (Species anAnimal : this.animals) {
            employeeIndex = this.random.nextInt(this.people.size());
            this.people.get(employeeIndex).assignAnimal(anAnimal);
        }
    }
}
