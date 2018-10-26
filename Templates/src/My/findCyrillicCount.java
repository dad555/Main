package My;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class findCyrillicCount {

    public static void main(String[] args) {
        new findCyrillicCount().go();
    }

    public void go() {
        try {
            File file = new File("C:\\Users\\artur\\Downloads\\accounts-operations.xsd");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int row = 0;
            int count = 0;
            ArrayList<Character> c = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                row++;
                for (int i = 0; i < line.length(); i++) {
                    if (Character.UnicodeBlock.of(line.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
                        count++;
                        c.add(line.charAt(i));
                    }
                }

                System.out.println("Линия: " + row + " Кол-во: " + count + " " + c.toString());
                count = 0;
                c.clear();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
