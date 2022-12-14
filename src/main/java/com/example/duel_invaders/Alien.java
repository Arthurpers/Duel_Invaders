package com.example.duel_invaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Alien  {
    boolean dead = false;
    int x;
    int y;
    Color color;

    static double width = 40;
    static double height= 40;

    Rectangle rec = new Rectangle(50.0d, 50.0d , width, height);

    public Alien(boolean dead, int x, int y, Color color) {
        this.dead = dead;
        this.x = x;
        this.y = y;
        this.color = color;

        rec.setTranslateX(x);
        rec.setTranslateY(y);
    }
//NON-STATIC VARIABLES CANNOT BE ACCESSED BY SAYING CLASS.VARIABLES
    public void move_left(){
        rec.setTranslateX(rec.getTranslateX()-3);

        //rec.setTranslateX(rec.getTranslateX()+2);
        x-=3;
    }

    public void move_right(){
        rec.setTranslateX(rec.getTranslateX()+3);
        x+=3;
    }

    public void move_up(){
        rec.setTranslateY(rec.getTranslateY()+3);
        y+=3;
    }

    public void move_down(){
        rec.setTranslateY(rec.getTranslateY()-3);
        y-=3;
    }

    public Rectangle getRec() {
        return rec;
    }
}
