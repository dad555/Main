package com.artur.games.game2048;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame window = new JFrame();
        window.setTitle("2048");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(450, 500);
        window.setResizable(false);

        window.add(controller.getView());

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
