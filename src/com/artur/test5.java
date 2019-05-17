package com.artur;

import java.util.*;

public class test5 {
    public static void main(String[] args) {
        print(3);
    }

    public static void print(int x) {
        if (x <=0) System.out.println("Boom!");
        else {
            System.out.println(x);
            print(x - 1);
            System.out.println(x);
        }
    }
}
