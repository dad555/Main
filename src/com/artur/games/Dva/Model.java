package com.artur.games.Dva;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score;
    protected int maxTile;


    //для реализации возврата хода
    private Stack<Integer> previousScores;
    private Stack<Tile[][]> previousStates;
    private boolean isSaveNeeded = true;


    public Model() {
        resetGameTiles();
        this.score = 0;
        this.maxTile = 0;
        this.previousScores = new Stack<>();
        this.previousStates = new Stack<>();
    }

    // сброс всех клеток
    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                this.gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    // вовзращает лист пустых клеток
    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    // добавляет рандомно клетку 2 или 4 (соотношение 1 к 9)
    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles != null && emptyTiles.size() != 0) {
            emptyTiles.get((int) (emptyTiles.size() * Math.random())).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    // сжатие одного ряда влево
    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        Tile temp;

        for (int out = 0; out < 3; out++) {
            for (int in = 0; in < 3; in++) {
                if (tiles[in].getValue() == 0 && tiles[in + 1].getValue() != 0) {
                    temp = tiles[in];
                    tiles[in] = tiles[in + 1];
                    tiles[in + 1] = temp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    // сложение клеток
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].getValue() != 0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() * 2);
                tiles[j + 1].setValue(0);
                if (tiles[j].getValue() > maxTile) maxTile = tiles[j].getValue();
                score += tiles[j].getValue();
                isChanged = true;

            }
        }

        if (isChanged) {
            Tile temp;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                }
            }
        }
        return isChanged;
    }

    public void left() {
        if (isSaveNeeded) saveState(this.gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }

        if (isChanged) {
            addTile();
            isSaveNeeded = true;
        }
    }

    public void up() {
        saveState(this.gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    // поворот матрицы на 90 градусов против часовой стрелки
    private void rotate() {
        int len = FIELD_WIDTH;
        for (int k = 0; k < len / 2; k++) // border -> center
        {
            for (int j = k; j < len - 1 - k; j++) // left -> right
            {

                Tile tmp = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][len - 1 - k];
                gameTiles[j][len - 1 - k] = gameTiles[len - 1 - k][len - 1 - j];
                gameTiles[len - 1 - k][len - 1 - j] = gameTiles[len - 1 - j][k];
                gameTiles[len - 1 - j][k] = tmp;
            }
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }

    // сохраняет состояние в стек
    private void saveState(Tile[][] tile) {
        Tile[][] tileToSave = new Tile[tile.length][tile[0].length];
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[0].length; j++) {
                tileToSave[i][j] = new Tile(tile[i][j].getValue());
            }
        }

        previousStates.push(tileToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
        isSaveNeeded = false;
    }

    // откат на один ход назад
    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            this.score = previousScores.pop();
            this.gameTiles = previousStates.pop();
        }
    }

    // делает ход в случайном направлении
    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0: left(); break;
            case 1: up(); break;
            case 2: right(); break;
            case 3: down(); break;
        }
    }

    // проверка измененя поля
    private boolean hasBoardChanged() {
        boolean result = false;
        int sumNow = 0;
        int sumPrevious = 0;
        Tile[][] tmp = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                sumNow += gameTiles[i][j].getValue();
                sumPrevious += tmp[i][j].getValue();
            }
        }
        return sumNow != sumPrevious;
    }

    // проверка эффективности хода
    private MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();

        return moveEfficiency;
    }

    // реализация выбора эффективного хода из возможных
    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }
}
