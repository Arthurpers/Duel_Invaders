package com.example.duel_invaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Alien extends Rectangle {
    boolean dead = false;
    int x;
    int y;
    Color color;

    public Alien(boolean dead, int x, int y, Color color) {
        this.dead = dead;
        this.x = x;
        this.y = y;
        this.color = color;

        setTranslateX(x);
        setTranslateY(y);
    }

    public void move_left(){
        setTranslateX(getTranslateX()-5);
    }

    public void move_right(){
        setTranslateX(getTranslateX()+5);
    }

}
