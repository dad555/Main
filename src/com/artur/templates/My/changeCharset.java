// Считывает из файла байты (зная кодировку) и записывает в новый файл со сменой кодировки

package com.artur.templates.My;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class changeCharset {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte[] buffer = new byte[1000];
        inputStream.read(buffer);
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(utf8);
        outputStream.write(buffer);
    }
}