package com.example.duel_invaders;



import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Dart extends Rectangle {
    boolean dead = false;

    int x;

    int y;

    //Color Color;

    //static double width = 40;
    //static double height = 80;

    //Rectangle rec ;

    public Dart(boolean dead, int x, int y,int w, int h, Color color) {
        super(w,h,color);
        this.dead = dead;
        this.x = x;
        this.y = y;
        //super(w,h,color); Call to super must be the first statement of the constructor
        //this.Color = color;
        //this.rec =  new Rectangle(x, y , width, height);

        setFill(color);
        setTranslateX(x);
        setTranslateY(y);

    }


    public void move_down(){

        setTranslateY(getTranslateY()-10);
    }

    public void move_up(){

        setTranslateY(getTranslateY()+10);
    }


}
