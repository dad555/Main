package com.artur;

import sun.misc.VM;

public class test5 {
    public static void main(String[] args) {
        int x = 100;
        Integer y = new Integer(100);
        Integer z = 100;

        System.out.println(x==y); // true
        System.out.println(x==z); // true
        System.out.println(y==z); // true
        System.out.println(y.getClass().getSimpleName().hashCode());
        System.out.println(z.getClass().hashCode());



        System.out.println();

        int _x = 300;
        Integer _y = 300;
        Integer _z = 300;

        System.out.println(_x==_y); // true
        System.out.println(_x==_z); // true
        System.out.println(_y==_z); // true

        System.out.println(_y.getClass().getSimpleName().hashCode());
        System.out.println(_z.getClass().getSimpleName().hashCode());
    }
}
