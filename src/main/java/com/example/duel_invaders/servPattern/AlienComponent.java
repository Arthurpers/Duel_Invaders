package com.example.duel_invaders.servPattern;

import javafx.geometry.Bounds;

/**
 * La classe AlienComponent est le composant. AlienWave sera un composite formé d'Alien(classe qui hérite de AlienComponent).
 */
public abstract class AlienComponent {
    private int x;

    private int y;

    private int width;

    private int height;


    public abstract Bounds getBounds();

    public abstract Bounds getOppositeBounds(int sceneWidth, int sceneHeight);

    public abstract void setImage();

    public abstract void kill();





}
