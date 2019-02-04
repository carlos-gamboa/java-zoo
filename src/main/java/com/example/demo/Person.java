package com.example.demo;

public abstract class Person {
    protected String name;
    protected int age;

    public void askForMoney() {
        System.out.println("Please pay me! My kids are starving.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
