package com.artur.garbage.Learning1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    JPanel mainPanel;
    JFrame theFrame;
    JLabel speedLabel;
    JLabel count;
    Ship ship = new Ship();
    Distance distance = new Distance();

    public void buildGUI() {
        theFrame = new JFrame("com.artur.templates.My First Game");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GRAY);
        speedLabel = new JLabel("ygiy");
        speedLabel.setText(String.valueOf(ship.getSpeed()));
        JButton startButton = new JButton("Start!");
        startButton.addActionListener(new StartListener());
        JButton stopButton = new JButton("Stop!");

        bottomPanel.add(speedLabel);
        bottomPanel.add(startButton);
        bottomPanel.add(stopButton);

        theFrame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);

        JPanel logs = new JPanel();
        logs.setBackground(Color.WHITE);
        JTextArea logsArea = new JTextArea(null, null, 30,20);
        logsArea.setBackground(Color.GRAY);
        logs.add(logsArea);

        theFrame.getContentPane().add(BorderLayout.WEST, logs);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        count = new JLabel("0.0000");
        mainPanel.add(count);

        theFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        theFrame.setSize(900,500);
        theFrame.setVisible(true);

        theFrame.repaint();
    }

    public class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //ship.setEngineOn(true);
            ship.setSpeed(1.23);
        }
    }
}
