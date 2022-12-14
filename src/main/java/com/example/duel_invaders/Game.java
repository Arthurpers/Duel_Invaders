package com.example.duel_invaders;

import javafx.animation.AnimationTimer;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Game extends Application {
    int i;

    double a;
    double Frame1 = 15;

    boolean left_cap = false;

    boolean right_cap = false;

    boolean up_cap = false;

    boolean down_cap = false;

    boolean shoot_cap = false;

    boolean random_move = false;

    BorderPane root = new BorderPane();

    Scene scene = new Scene(root, 6000, 3000);

    //Canon Canon1 = new Canon(1, 1000,1000,4,4);


    private List<Dart> darts = new ArrayList<>() ;

    double t = 0;


    public void shoot( Canon c){


        Dart d = new Dart(false, c.getX(),c.getY(),40,40,Color.BLUE);
        //d.move_up();
        darts.add(d);//On ajoute la dart a la liste
        System.out.println(c.getX());
        root.getChildren().add(d);

    }


    public void create_aliens() {
        for (i = 0; i < 8; i++) {
            Alien a = new Alien(false, 100 + i * 100, 50 + 5 * 50, Color.YELLOWGREEN);
            root.getChildren().add(a.rec);
        }
    }


    Canon Canon1 = new Canon(1, 500,500,50,50);


    //Création des aliens

    Alien Alien1 = new Alien(false,1100,100,Color.RED);
    Alien Alien2 = new Alien(false,100,100,Color.RED);
    Alien Alien3 = new Alien(false,300,100,Color.RED);
    Alien Alien4 = new Alien(false,500,100,Color.RED);
    Alien Alien5 = new Alien(false,700,100,Color.RED);
    Alien Alien6 = new Alien(false,900,100,Color.RED);
    Alien Alien7 = new Alien(false,1300,100,Color.RED);



    //Création des darts

    Dart d2 = new Dart(false,400,200,40,40,Color.AQUAMARINE);
    //darts.add(d2);



    public void start(Stage primarystage) throws IOException {


        darts.add(d2);
        //Renderer renderer = new Renderer




        create_aliens();


        d2.setFill(Color.RED);


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


        //New Event


        EventHandler<KeyEvent> eventHandlerdown = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode()== KeyCode.RIGHT){
                    System.out.println("RIGHT");
                    //transition3.play();
                    //Canon1.move_right();
                    right_cap = true;
                }
                if (e.getCode()== KeyCode.LEFT){
                    System.out.println("LEFT");
                    //transition4.play();
                    //Canon1.move_left();
                    left_cap = true;
                }
                if (e.getCode()== KeyCode.DOWN){
                    System.out.println("UP");
                    System.out.println(Canon1.getX());
                    //transition5.play();
                    //Canon1.move_up();
                    up_cap = true;
                }
                if (e.getCode()== KeyCode.UP){
                    System.out.println("DOWN");
                    //transition2.play();
                    //Canon1.move_down(Frame1);
                    down_cap = true;
                }


                if (e.getCode()== KeyCode.D){
                    System.out.println("SHOOT");
                    shoot_cap = true;
                    shoot(Canon1);
                }
            }
        };


        scene.addEventHandler(KeyEvent.KEY_PRESSED,eventHandlerdown);









        Canon1.rec.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        //Canon1.rec.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);

        //scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);
        //scene.addEventHandler(KeyEvent.KEY_PRESSED,eventHandlerdown);
        //ADDS TO THE SCREEN

        root.getChildren().add(Canon1.rec);
        root.getChildren().add(Alien1.rec);
        root.getChildren().add(Alien2.rec);
        root.getChildren().add(Alien3.rec);
        root.getChildren().add(Alien4.rec);
        root.getChildren().add(Alien5.rec);
        root.getChildren().add(Alien6.rec);
        root.getChildren().add(Alien7.rec);
        root.getChildren().add(d2);




        //Adding scene to the stage
        primarystage.setScene(scene);
        //Displaying the contents of the stage
        primarystage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                /*Alien1.move_left();
                Alien6.move_right();
                Alien2.move_right();*/

                //shoot();
                a = Math.round(Math.random());
                System.out.println(a);
                if (a==1.0){
                    random_move = false;}
                if (a ==0.0){
                    random_move = true;}
                update();
                darts.forEach(s -> {
                    s.move_down();
                });


                d2.move_down();
            }
        };


        timer.start();



    }

    /*private List<Dart> Darts () {
        return root.getChildren().stream().map(n -> (Dart)n).collect(Collectors .toList());
    }*/
    public void update() {

        if (a==1.0) {

            System.out.println("LEFT");
            Alien1.move_left();
            Alien6.move_left();
            Alien2.move_left();
            Alien3.move_left();
            Alien4.move_left();
            Alien5.move_left();


        }

        if (  a==0.0){

            System.out.println("RIGHT");
            Alien1.move_right();
            Alien6.move_right();
            Alien2.move_right();
            Alien3.move_right();
            Alien4.move_right();
            Alien5.move_right();
        }

        if (  a==2.0){

            System.out.println("RIGHT");
            Alien1.move_up();
            Alien6.move_up();
            Alien2.move_up();
            Alien3.move_up();
            Alien4.move_up();
            Alien5.move_up();
        }

        if (  a==3.0){

            System.out.println("RIGHT");
            Alien1.move_down();
            Alien6.move_down();
            Alien2.move_down();
            Alien3.move_down();
            Alien4.move_down();
            Alien5.move_down();
        }
            /*darts.forEach(s -> {
                s.move_up();
            });*/

        System.out.println("UPDATE");
        if (left_cap){


            Canon1.move_left();
            left_cap = false;
        }
        if (right_cap){


            Canon1.move_right();
            right_cap = false;
        }
        if (up_cap){


            Canon1.move_up(Frame1);
            up_cap= false;
        }
        if (down_cap){


            Canon1.move_down(Frame1);
            down_cap = false;
        }
        if (shoot_cap){
            shoot(Canon1);
            shoot_cap = false;
        }





        //if keys.isDown(KeyCode.UP)



        /*EventHandler<KeyEvent> eventHandlerdown = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode()== KeyCode.RIGHT){
                    System.out.println("RIGHT");
                    //transition3.play();
                    Canon1.move_right();
                }
                if (e.getCode()== KeyCode.LEFT){
                    System.out.println("LEFT");
                    //transition4.play();
                    Canon1.move_left();
                }
                if (e.getCode()== KeyCode.DOWN){
                    System.out.println("UP");
                    System.out.println(Canon1.getX());
                    //transition5.play();
                    Canon1.move_up();
                }
                if (e.getCode()== KeyCode.UP){
                    System.out.println("DOWN");
                    //transition2.play();
                    Canon1.move_down(Frame1);
                }


            }
        };


        scene.addEventHandler(KeyEvent.KEY_PRESSED,eventHandlerdown);
*/



    }
    //private  void update(Alien){
    //    Alien1.get.move_left();
    //}


    public static void main(String[] args) {
        launch();
    }
}
