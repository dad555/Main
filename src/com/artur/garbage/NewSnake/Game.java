package com.artur.garbage.NewSnake;

import javax.swing.*;
import java.awt.*;

public class Game {
    private JFrame frame;
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public static Game game;

    public Game(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
        game = this;
    }

    public static void main(String[] args) {
        game = new Game(800, 800, new Snake(250,250));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.go();
    }

    void go() {
        frame = new JFrame("Новая змейка!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawGamePanel panel = new DrawGamePanel();
        frame.getContentPane().add(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    class DrawGamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0,0, this.getWidth(), this.getHeight());

            g.setColor(Color.BLACK);
            g.fillRect(snake.getSections().get(0).getX(), snake.getSections().get(0).getY(),20,20);

            g.setColor(Color.BLUE);
            g.fillRect(mouse.getX(),mouse.getY(),20,20);
        }
    }

    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }

    public void eatMouse() {
        createMouse();
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
