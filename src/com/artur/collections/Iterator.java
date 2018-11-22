package com.artur.collections;

import java.util.*;

public class Iterator {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1, "Cat"));
        pets.add(new Pet(2, "Dog"));
        pets.add(new Pet(3, "Mouse"));
        pets.add(new Pet(4, "Minx"));
        pets.add(new Pet(5, "Rat"));

        ListIterator<Pet> it = pets.listIterator();

        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + ", ");
        }
        System.out.println();

        while (it.hasPrevious()) {
            System.out.print(it.previous().getId() + " ");
        }

        System.out.println();
        System.out.println(pets);

        it = pets.listIterator(2);
        while (it.hasNext()) {
            it.next();
            it.set(new Pet(15, "Lion"));
        }

        System.out.println(pets);
    }
}

class Pet {
    private int id;
    private String name;

    public Pet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
