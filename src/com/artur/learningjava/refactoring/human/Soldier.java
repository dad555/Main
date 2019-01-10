package com.artur.learningjava.refactoring.human;

public class Soldier extends Human {
    protected boolean isSoldier;
    private int course;

    public Soldier(String name, int age) {
        super(name, age);

    }

    public void live() {
        fight();
    }

    public void fight() {
    }

    public int getCourse() {
        return course;
    }
}
