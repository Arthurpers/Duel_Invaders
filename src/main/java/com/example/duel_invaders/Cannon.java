package com.example.duel_invaders;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Classe permettant de gérer un canon
 */
public class Cannon {
    private int x;
    private int y;
    private int width;
    private int height;
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

        this.cannonImage = new Image("file:src/main/java/com/example/duel_invaders/assets/pngegg.png");
        this.cannonView = new ImageView(cannonImage);
    }

    /**
     * Déplacement du canon vers la gauche
     */
    public void moveLeft() {
        x -= 5;
    }

    /**
     * Déplacement du canon vers la droite
     */
    public void moveRight() {
        x += 5;
    }

    /**
     * Vérifie si le délai de récupération du canon est terminé pour pouvoir tirer à nouveau
     * @return bool
     */
    public boolean canFire() {
        return System.currentTimeMillis() - lastFireTime >= 700;
    }

    /**
     * Lance un nouveau délai de récupération
     */
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

    /**
     * Donne les Bounds à partir des coordonnées du plan de base après avoir effectué une rotation à 180 degrés du plan
     */
    public Bounds getOppositeBounds(int sceneWidth, int sceneHeight) {
        return new Rectangle(sceneWidth-x-width, sceneHeight-y-height, width, height).getBoundsInLocal();
    }


}
