package com.artur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[a-z0-9]{0,}[\\.-]{0,1}[a-z0-9]{0,}@[a-z0-9]{0,10}([\\.-]{1}([a-z]{2,4}))+");
        Matcher m = p.matcher("box-arthur@gmail.com.ru");
        boolean ft = m.matches();

        System.out.println("ft = " + ft);
    }
}
