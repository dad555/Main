package com.artur.games.Example2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Рудик", 37));
        persons.add(new Person("Диана", 32));
        persons.add(new Person("Давид", 3));
        persons.add(new Person("Геворг", 35));
        persons.add(new Person("Артур", 33));

        for(Person s : persons) {
            System.out.println(s);
        }

        int sum = 0;
        int adultPersons = 0;
        for(Person p : persons) {
            if(p.getAge() >= 32) {
                sum += p.getAge();
                adultPersons++;
            }
        }
        double averageAge = (double) sum / adultPersons;
        System.out.println();
        System.out.println("averageAge(>= 32) = " + averageAge);

        System.out.println();

        double averageAge2 = persons.stream().
                filter(p -> p.getAge() >= 32).
                mapToInt(p -> p.getAge()).average().getAsDouble();

        System.out.println();

        System.out.println("averageAge(>= 32) = " + averageAge2);

        persons.stream().
                // фильтр свыше 33 по параметру age
                filter(p -> p.getAge() >= 33).
                // сортировка по name
                sorted(Comparator.comparing(Person::getName)).
                // вывод только name
                map(Person::getName).
                // по всей коллекции
                forEach(System.out::println);

    }
}
