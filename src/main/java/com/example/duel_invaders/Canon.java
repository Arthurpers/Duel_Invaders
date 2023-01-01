package com.example.duel_invaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
public class Canon {

    boolean dead = false;
    private final int power;

    public  int x;

    public  int y;

    public int points;

    private final int width;

    private final int height;

    Rectangle rec;
    //Rectangle rec = new Rectangle(x, y , width, height);





    public Canon(boolean dead, int power, int x, int y, int width, int height) {
        this.dead = dead;
        this.power = power;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //this.points = 0;

        this.rec = new Rectangle(x, y , width, height);

        //rec.setTranslateX(x);
        //rec.setTranslateY(y);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPoint(){
        return points;
    }
    public Rectangle getRec(){
        return rec;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getPower() {
        return power;
    }

    public void move_left(double Frame){
        rec.setTranslateX(rec.getTranslateX()-Frame);
        x-=Frame;
    }

    public void move_right(double Frame){
        rec.setTranslateX(rec.getTranslateX()+Frame);
        x+=Frame;
    }

    public void move_down(double Frame){
        rec.setTranslateY(rec.getTranslateY()- Frame);
        y-=Frame;
    }

    public void move_up(double Frame){
        rec.setTranslateY(rec.getTranslateY()+Frame);
        y+=Frame;
    }
}
