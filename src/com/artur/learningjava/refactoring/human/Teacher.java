package com.artur.learningjava.refactoring.human;

public class Teacher extends UniversityPerson {
    private int course;
    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public int getCourse() {
        return course;
    }

    public String getPosition() {
        return "Преподаватель";
    }
}