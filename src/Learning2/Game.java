package Learning2;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Game {
    JFrame theFrame;
    MyPanel mainPanel;
    JPanel bottomPanel;
    JButton stop, tap, upgrade;
    Ship ship = new Ship();

    public static void main(String[] args) {
        Game game = new Game();
        game.buildGUI();
        game.run();
    }

    public void buildGUI() {
        theFrame = new JFrame("My Second Game");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new MyPanel();

        bottomPanel = new JPanel();
        stop = new JButton("Stop!");
        stop.addActionListener(new StopListener());
        bottomPanel.add(stop);

        tap = new JButton("Tap!");
        tap.addActionListener(new TapListener());
        bottomPanel.add(tap);

        upgrade = new JButton("Upgrade!");
        upgrade.addActionListener(new UpgradeListener());
        bottomPanel.add(upgrade);


        theFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        theFrame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        theFrame.setSize(600,400);
        theFrame.setVisible(true);
    }

    public void run() {
        while (ship.isEngineOn()) {
            theFrame.repaint();
            ship.go();
        }
    }

    public class StopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ship.setEngineOn(false);
        }
    }


    public class TapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ship.tap(0.01);
        }
    }

    public class UpgradeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ship.setUpgrade(1.10);
        }
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            Font labelFont = new Font("monospaced bold", Font.PLAIN, 48);
            g.setFont(labelFont);
            String destStr = new DecimalFormat("#0.000").format(ship.getDistance());
            g.drawString("Distance: " + destStr, 100, 100);
            String speedStr = new DecimalFormat("#0.000").format(ship.getSpeed());
            g.drawString("Speed: " + speedStr, 100, 150);
        }
    }
}


