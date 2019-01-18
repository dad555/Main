package com.artur;

import java.util.Random;

public class Random100 {
    public static void main(String[] args) {
        System.out.println(new Random(System.currentTimeMillis()).nextInt(100));
    }
}
