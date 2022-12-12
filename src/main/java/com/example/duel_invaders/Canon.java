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

    private  int x;

    private  int y;

    private final int width;

    private final int height;


    Rectangle rec = new Rectangle(100.0d, 100.0d , 120.0d, 80.0d);





    public Canon(int power, int x, int y, int width, int height) {
        this.power = power;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

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
}
