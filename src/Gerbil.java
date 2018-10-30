import java.util.ArrayList;

public class Gerbil {
    private static int counter;
    private final int gerbilNumber;

    private Gerbil() {
        gerbilNumber = counter++;
    }

    private String hop() {
        return gerbilNumber + "GerbilNumber";
    }

    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil());
        gerbils.add(new Gerbil());
        gerbils.add(new Gerbil());

        for(Gerbil g : gerbils) {
            System.out.println(g.hop());
        }
    }
}


