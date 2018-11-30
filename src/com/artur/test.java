package com.artur;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss:SSS");
        Date d1 = new Date(1537803399596L);
        System.out.println("1537803399596 - " + sdf.format(d1));
        Date d2 = new Date(1537803399504L);
        System.out.println("1537803399504 - " + sdf.format(d2));
        Date d3 = new Date(1_577_739_600_000L);
        System.out.println("1577739600000 - " + sdf.format(d3));

        System.currentTimeMillis();

        System.out.println(System.currentTimeMillis());

        Calendar futureTime = Calendar.getInstance();
        futureTime.set(Calendar.HOUR, 15);
        futureTime.set(Calendar.MINUTE, 0);
        futureTime.set(Calendar.SECOND, 0);
        System.out.println(futureTime.getTimeInMillis());

        Date d4 = new Date(1537876800000L);
        System.out.println("1537876800000 - " + sdf.format(d4));

        String s1 = "com.artur.test";
        String s2 = s1 + "test2";

        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append("test2");
        String s3 = sb.toString();

        StringBuffer stringBuffer = new StringBuffer();

        System.out.println(s2);
        System.out.println(s3);

        System.out.print("Привет, сегодня: ");
        System.out.print(new Date());

        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));


        String s = "Тест " + Math.random();

        System.out.println(s);

        System.out.println(new Random().nextInt(999999));

    }
}
