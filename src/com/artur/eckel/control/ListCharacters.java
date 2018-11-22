package com.artur.eckel.control;

// Перебор всех ASCII-символов нижнего регистра

public class ListCharacters {
    public static void main(String[] args) {
        for (char c = 0; c < 128; c++) {
            if(Character.isLowerCase(c))
            System.out.println("значение: " + (int) c + " символ: " + c);
        }
    }
}
