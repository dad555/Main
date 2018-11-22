package com.artur.templates.My;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class findCyrillic {
    ArrayList<String> find = new ArrayList<>();

    public static void main(String[] args) {
        new findCyrillic().go();
    }

    public void go() {
        try {
            File file = new File("C:\\Users\\artur\\Downloads\\accounts-operations.xsd");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (Character.UnicodeBlock.of(line.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
                        if(Character.UnicodeBlock.of(line.charAt(i + 1)).equals(Character.UnicodeBlock.BASIC_LATIN)) {
                            find.add(line);
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) { e.printStackTrace(); }

        for(String s : find) {
            System.out.println(s);
        }
    }
}
