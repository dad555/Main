package operators;

import java.util.Random;

public class MathOps {
    public static void main(String[] args) {
        Random rand = new Random();
        int i, j, k;
        j = rand.nextInt(1000) + 1;
        System.out.println("j : " + j);
        k = rand.nextInt(1000) + 1;
        System.out.println("k : " + k);
        i = j + k;
        System.out.println("j + k : " + i);

        Integer i1 = new Integer(47);
        Integer i2 = new Integer(47);
        System.out.println(i1.equals(i2));

        int big = Integer.MAX_VALUE;
        System.out.println(big);

        long bigger = (long) big * 4;
        System.out.println(bigger);
    }
}
