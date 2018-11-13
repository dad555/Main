package Learning1;

import java.io.*;

public class Game implements Serializable {
    private static final long serialVersionUID = 1138280793224565154L;

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    public void run() {
        UserInterface gui = new UserInterface();
        gui.buildGUI();


    }
}
