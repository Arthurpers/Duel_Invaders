package com.example.duel_invaders;

import com.example.duel_invaders.Canon;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.security.Key;

import static javafx.application.Application.launch;

public class Game extends Application {

    public void start(Stage primarystage) throws IOException {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 6000, 3000);

        Canon Canon1 = new Canon(1, 2,2,4,4);
        Canon1.rec.setFill(Color.YELLOW);


        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(0.20), Canon1.getRec());
        transition1.setByX(100f);


        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(0.20), Canon1.getRec());
        transition2.setByY(100f);

        TranslateTransition transition5 = new TranslateTransition(Duration.seconds(0.20), Canon1.getRec());
        transition5.setByY(-100f);

        TranslateTransition transition3 = new TranslateTransition(Duration.seconds(0.20), Canon1.getRec());
        transition3.setByX(100f);

        TranslateTransition transition4 = new TranslateTransition(Duration.seconds(0.20), Canon1.getRec());
        transition4.setByX(-100f);
        //Creating the mouse event handler

        transition1.setByX(100f);


        EventHandler<MouseEvent> eventHandler= new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent e) {
                System.out.println("Rectangle Clicked");
                transition1.play();
            }
        };
        RotateTransition rt1= new RotateTransition(Duration.seconds(0.5), Canon1.getRec());

        EventHandler<KeyEvent> eventHandlerdown = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode()== KeyCode.RIGHT){
                    System.out.println("RIGHT");
                    transition3.play();
                }
                if (e.getCode()== KeyCode.LEFT){
                    System.out.println("LEFT");
                    transition4.play();
                }
                if (e.getCode()== KeyCode.UP){
                    System.out.println("DOWN");
                    transition5.play();
                }
                if (e.getCode()== KeyCode.DOWN){
                    System.out.println("UP");
                    transition2.play();
                }
            }
        };




        Canon1.rec.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        //Canon1.rec.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);

        //scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);
        scene.addEventHandler(KeyEvent.KEY_PRESSED,eventHandlerdown);

        root.getChildren().add(Canon1.rec);
        //Adding scene to the stage
        primarystage.setScene(scene);
        //Displaying the contents of the stage
        primarystage.show();


    }



    public static void main(String[] args) {
        launch();
    }
}
