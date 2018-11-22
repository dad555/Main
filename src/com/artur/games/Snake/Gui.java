package com.artur.games.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Gui extends Thread {
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);
    private JFrame frame;
    private Snake snake;
    private Room room;
    private Mouse mouse;

    @Override
    public void run() {
        frame = new JFrame("com.artur.games.Snake Game!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel panel = new MyDrawPanel();
        frame.getContentPane().add(panel);
        frame.setSize(20,20);
        frame.setVisible(true);

        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.exit(0);
            }
        });

        frame.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                //do nothing
            }

            public void keyReleased(KeyEvent e) {
                //do nothing
            }

            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }
        });

        panel.repaint();
    }

    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
        return keyEvents.poll();
    }

    class MyDrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0,0, this.getWidth(), this.getHeight());

            g.setColor(Color.BLACK);
            g.fillRect(snake.getSections().get(0).getX(),snake.getSections().get(0).getY(), 1,1);

            g.setColor(Color.BLUE);
            g.fillRect(mouse.getX(), mouse.getY(), 1, 1);
        }
    }
}
