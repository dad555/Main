package com.artur.learningjava.refactoring.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double value) {
        for(Student s : students) {
            if(s.getAverageGrade() == value) {
                return s;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = null;
        double maxAverageGrade = 0;
        for(Student s : students) {
            if(s.getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = null;
        double minAverageGrade = 100;
        for(Student s : students) {
            if(s.getAverageGrade() < minAverageGrade) {
                minAverageGrade = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}