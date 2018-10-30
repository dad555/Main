package NewSnake;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Game extends Thread {
    private JFrame frame;
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Game game;
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);


    public Game(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public static void main(String[] args) {
        game = new Game(800, 800, new Snake(260,260));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }

    public void run() {
        frame = new JFrame("Новая змейка!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawGamePanel panel = new DrawGamePanel();
        frame.getContentPane().add(panel);
        frame.setSize(width, height);
        frame.setVisible(true);

        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) { }
            @Override
            public void focusLost(FocusEvent e) {
                System.exit(0);
            }
        });

        frame.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) { }
            public void keyReleased(KeyEvent e) { }
            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }
        });

        while (snake.isAlive()) {
            if (game.hasKeyEvents()) {
                KeyEvent event = game.getEventFromTop();
                if (event.getKeyChar() == 'q') return;

                if (event.getKeyCode() == KeyEvent.VK_LEFT) snake.setDirection(SnakeDirection.LEFT);
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT) snake.setDirection(SnakeDirection.RIGHT);
                else if (event.getKeyCode() == KeyEvent.VK_UP) snake.setDirection(SnakeDirection.UP);
                else if (event.getKeyCode() == KeyEvent.VK_DOWN) snake.setDirection(SnakeDirection.DOWN);
            }
            snake.move();
            sleep();
            panel.repaint();
        }
    }

    class DrawGamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0,0, this.getWidth(), this.getHeight());

            for (int i = 0; i < snake.getSections().size(); i++) {
                g.setColor(Color.BLACK);
                g.fillRect(snake.getSections().get(i).getX(), snake.getSections().get(i).getY(),20,20);
            }

            g.setColor(Color.BLUE);
            g.fillRect(mouse.getX(),mouse.getY(),20,20);
        }
    }

    public void createMouse() {
        int x;
        int y;
        while (true) {
            x = (int) (Math.random() * width);
            y = (int) (Math.random() * height);
            if (x % 20 == 0 && y % 20 == 0) {
                mouse = new Mouse(x, y);
                break;
            }
        }
    }

    public void eatMouse() { createMouse(); }
    public Snake getSnake() { return snake; }
    public Mouse getMouse() { return mouse; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public boolean hasKeyEvents() { return !keyEvents.isEmpty(); }
    public KeyEvent getEventFromTop() { return keyEvents.poll(); }

    private int initialDelay = 320;
    private int delayStep = 20;

    public void sleep() {
        try {
            int level = snake.getSections().size();
            int delay = level < 15 ? (initialDelay - delayStep * level) : 200;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}
