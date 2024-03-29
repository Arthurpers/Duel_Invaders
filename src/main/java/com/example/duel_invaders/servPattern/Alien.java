package com.example.duel_invaders.servPattern;

import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Classe permettant de gérer un alien
 */
public class Alien extends AlienComponent {
    private int x;
    private int y;
    private int width;
    private int height;

    private int nbHits = 0;

    public void setNbHits(int nbHits) {
        this.nbHits++;
    }

    public int getNbHits() {
        return nbHits;
    }
    public void incrementHits(){
        this.nbHits++;
    }

    private boolean isAlive;

    private IAlien_death_strategy shoot_strategy;
    Image alienImage;
    ImageView alienView;

    //Public strategy Movement?

    public Alien(int x, int y, int width, int height, IAlien_death_strategy shoot_strategy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shoot_strategy = shoot_strategy;

        /*this.alienImage = new Image("file:src/main/java/com/example/duel_invaders/assets/alienwhite.png");
        this.alienView = new ImageView(alienImage);*/
        this.isAlive = true;
    }

    public void setImage(){
        shoot_strategy.setImage(this);
    }
    public void kill() {

        shoot_strategy.kill(this);

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
    /**
     * Donne les Bounds à partir des coordonnées du plan de base après avoir effectué une rotation à 180 degrés du plan
     */
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
