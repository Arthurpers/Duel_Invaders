package com.example.duel_invaders;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        
        BorderPane root = new BorderPane();
        //Creating a scene object
        Scene scene = new Scene(root,600,300);
        
        //Drawing a rectangle
        Rectangle rec = new Rectangle(100.0d, 100.0d , 120.0d, 80.0d);
        
        rec.setFill(Color.RED);
        
        //Creating Translate transition
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.50), rec);
        transition.setByX(50f);
        
        //Creating the mous eevent handler

        transition.setByX(50f);
        EventHandler<MouseEvent> eventHandler= new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent e) {
                    System.out.println("Rectangle Clicked");
                    transition.play();
                }
            };
            //Create Rotate Transition
            RotateTransition rt= new RotateTransition(Duration.seconds(0.5), rec);
            //Creating the key event handler
            EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent e) {
                    // +45 Degrees on up key
                    if(e.getCode()== KeyCode.UP){
                        System.out.println("UP");
                        rt.setByAngle(45);
                        rt.play();
                    }
                    // -45 Degrees on down key
                    if(e.getCode()==KeyCode.DOWN) {
                        System.out.println("DOWN");
                        rt.setByAngle(-45);
                        rt.play();
                    }
                }
            };

            //Registering the event filter
            rec.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            //Add the keyEvent handler to the scene and not to the rectangle
            scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);

            root.getChildren().add(rec);
            //Adding scene to the stage
            primarystage.setScene(scene);
            //Displaying the contents of the stage
            primarystage.show();

        }


        
        


    public static void main(String[] args) {
        launch();
    }
}