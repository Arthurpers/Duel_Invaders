package com.example.duel_invaders;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class Cannon {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isFiring;
    private boolean isAlive;
    final Image cannonImage;
    private ImageView cannonView;
    private long lastFireTime;

    public Cannon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lastFireTime = 0;
        this.isAlive = true;
        this.cannonImage = new Image("C:\\Users\\etudiant\\IdeaProjects\\Duel_Invaders\\src\\main\\java\\com\\example\\duel_invaders\\pngegg.png");
        this.cannonView = new ImageView(cannonImage);
    }

    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x += 5;
    }

    public boolean canFire() {
        return System.currentTimeMillis() - lastFireTime >= 700;
    }
    public void fire() {
        lastFireTime = System.currentTimeMillis();
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
    public void kill() {
        isAlive = false;
    }
    public Bounds getBounds() {
        return new Rectangle(x, y, width, height).getBoundsInLocal();
    }
    public ImageView getCannonView() {
        return cannonView;
    }


}
