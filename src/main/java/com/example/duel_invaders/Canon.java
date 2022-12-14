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
    private final int power;

    public  int x;

    public  int y;

    private final int width;

    private final int height;

    Rectangle rec;
    //Rectangle rec = new Rectangle(x, y , width, height);





    public Canon(int power, int x, int y, int width, int height) {
        this.power = power;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

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

    public void move_left(){
        rec.setTranslateX(rec.getTranslateX()-20);
        x-=20;
    }

    public void move_right(){
        rec.setTranslateX(rec.getTranslateX()+20);
        x+=20;
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
