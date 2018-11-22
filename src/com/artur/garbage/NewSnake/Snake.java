package com.artur.garbage.NewSnake;

import java.util.ArrayList;

public class Snake {
    private SnakeDirection direction;
    private boolean isAlive = false;
    private ArrayList<SnakeSection> sections;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public int getX() {
        return sections.get(0).getX();
    }
    public int getY() {
        return sections.get(0).getY();
    }
    public SnakeDirection getDirection() {
        return direction;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public void move() {
        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -1);
        else if (direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 1);
        else if (direction == SnakeDirection.LEFT)
            move(-1, 0);
    }

    private void move(int dx, int dy) {
        // Создаем новую голову - новый "кусочек змеи".
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);

        checkBorders(head);
        if (!isAlive) return;

        checkBody(head);
        if (!isAlive) return;

        Mouse mouse = Game.game.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) {
            sections.add(0, head);
            Game.game.eatMouse();
        } else {
            sections.add(0, head);
            sections.remove(sections.size() - 1);
        }
    }

    private void checkBorders(SnakeSection head) {
        if ((head.getX() < 0 || head.getX() >= Game.game.getWidth()) || head.getY() < 0 || head.getY() >= Game.game.getHeight()) {
            isAlive = false;
        }
    }

    private void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }
}
