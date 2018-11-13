package Collections;

import java.util.*;

public class SetofInteger {
    public static void main(String[] args) {
        Random random = new Random(47);
        HashSet<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++)
            intset.add(random.nextInt(30));
        System.out.println(intset);
    }
}
