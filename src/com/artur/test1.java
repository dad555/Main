package com.artur;

import com.artur.garbage.pets.Dog;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class test1 {
    public static void main(String[] args) {
        String s = "Good news everyone!";

        StringTokenizer tokenizer = new StringTokenizer(s,"ne");
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }

        ArrayList<Apple> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new Gala());

        Gala newGala = (Gala) list.get(1);

        Dog dog = new Dog("Bobik");
        dog.setName("Kozlina");
        System.out.println(dog.getName());
    }
}

class Apple {




}

class Gala extends Apple {

}

