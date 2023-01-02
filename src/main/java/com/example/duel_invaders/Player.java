package com.example.duel_invaders;


import javafx.scene.input.KeyCode;

import java.util.List;

public class Player {
    private List<Alien> aliens;
    private List<Dart> darts;
    private Cannon cannon;
    private String keyRight;
    private String keyLeft;
    private String keyFire;
    public Player(List<Alien> aliens, List<Dart> darts, Cannon cannon,String keyRight,String keyLeft,String keyFire) {
        this.aliens = aliens;
        this.cannon = cannon;
        this.darts = darts;
        this.keyRight = keyRight;
        this.keyLeft = keyLeft;
        this.keyFire = keyFire;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public List<Dart> getDarts() {
        return darts;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public void setDarts(List<Dart> darts) {
        this.darts = darts;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }

    public String getKeyRight() {
        return keyRight;
    }

    public void setKeyRight(String keyRight) {
        this.keyRight = keyRight;
    }

    public String getKeyLeft() {
        return keyLeft;
    }

    public void setKeyLeft(String keyLeft) {
        this.keyLeft = keyLeft;
    }

    public String getKeyFire() {
        return keyFire;
    }

    public void setKeyFire(String keyFire) {
        this.keyFire = keyFire;
    }
}
