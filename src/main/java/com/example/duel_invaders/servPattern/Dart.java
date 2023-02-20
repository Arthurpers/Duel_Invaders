package com.example.duel_invaders.servPattern;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

/**
 * Classe permettant de gérer un missile tiré par un canon
 */
public class Dart {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isAlive;

    public Dart(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
    }

    /**
     * Déplacement vers le haut du dart
     */
    public void moveUp() {
        y -= 5;
    }

    public void kill() {
        isAlive = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bounds getBounds() {
        return new Rectangle(x, y, width, height).getBoundsInLocal();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
