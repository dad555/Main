package com.artur.eckel.interfaces.RandomDoubles;

import java.util.*;

public class RandomDoubles {
    private static Random r = new Random(47);
    public double next() {
        return r.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        for(int i = 0; i < 7; i++) {
            System.out.print(rd.next() + " ");
        }
    }
}
