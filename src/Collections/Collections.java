package Collections;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        ((ArrayList<Integer>) collection).addAll(Arrays.asList(moreInts));

        ArrayList<String> str = new ArrayList<>(Arrays.asList("один", "два", "три"));
        for (String s : str) {
            System.out.println(s);
        }
    }
}
