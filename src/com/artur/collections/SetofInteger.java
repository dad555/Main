package com.artur.collections;

import java.util.*;

public class SetofInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        LinkedHashSet<Integer> intset = new LinkedHashSet<Integer>();
        for (int i = 0; i < 100; i++)
            intset.add(random.nextInt(30));
        System.out.println(intset);

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 10000; i++)
            hashSet.add(random.nextInt(30));
        System.out.println(hashSet);

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10000; i++)
            treeSet.add(random.nextInt(30));
        System.out.println(treeSet);
    }
}
