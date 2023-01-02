package com.example.duel_invaders;


import javafx.scene.input.KeyCode;

import java.util.List;

public class Player {
    private AlienWave alienWave;
    private List<Dart> darts;
    private Cannon cannon;
    private String keyRight;
    private String keyLeft;
    private String keyFire;
    public Player(AlienWave aliens, List<Dart> darts, Cannon cannon,String keyRight,String keyLeft,String keyFire) {
        this.alienWave = aliens;
        this.cannon = cannon;
        this.darts = darts;
        this.keyRight = keyRight;
        this.keyLeft = keyLeft;
        this.keyFire = keyFire;

    }

    public AlienWave getAlienWave() {
        return alienWave;
    }

    public void setAlienWave(AlienWave alienWave) {
        this.alienWave = alienWave;
    }

    public List<Dart> getDarts() {
        return darts;
    }

    public Cannon getCannon() {
        return cannon;
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
