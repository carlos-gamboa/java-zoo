package com.example.demo;

public abstract class Person {
    protected String name;
    protected int age;

    public void askForMoney() {
        System.err.println(this.name + ": Please pay me! My kids are starving.");
    }

    public String getName() {
        return name;
    }
}
