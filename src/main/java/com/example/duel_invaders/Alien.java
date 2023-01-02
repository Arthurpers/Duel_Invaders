package com.example.duel_invaders;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Alien {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isAlive;
    final Image alienImage;
    final ImageView alienView;

    public Alien(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.alienImage = new Image("C:\\Users\\etudiant\\IdeaProjects\\Duel_Invaders\\src\\main\\java\\com\\example\\duel_invaders\\alienwhite.png");
        this.alienView = new ImageView(alienImage);
        this.isAlive = true;
    }

    public void moveDown() {
        y += 5;
    }

    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x += 5;
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
    public Bounds getOppositeBounds(int sceneWidth, int sceneHeight) {
        return new Rectangle(sceneWidth-x-width, sceneHeight-y-height, width, height).getBoundsInLocal();
    }

    public ImageView getAlienView() {
        return alienView;
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
