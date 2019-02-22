package com.artur.templates.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// вспомогательный класс, для чтения или записи в консоль
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) { // вывод с консоль
        System.out.println(message);
    }

    public static String readString() { // чтение строки из консоли
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
    }

    public static int readInt() { // чтение числа из строки
        while (true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }
}
