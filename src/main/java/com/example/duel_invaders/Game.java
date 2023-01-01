package com.example.duel_invaders;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Animation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class Game extends Application {
    int i;

    double a = 0;

    double y = 0;
    double Frame1 = 5;

    boolean left_cap_1 = false;

    boolean right_cap_1 = false;

    boolean up_cap_1 = false;

    boolean down_cap_1 = false;

    boolean left_cap_2 = false;

    boolean right_cap_2 = false;

    boolean up_cap_2 = false;

    boolean down_cap_2 = false;

    boolean shoot_cap = false;

    boolean random_move = false;

    //Duration FiringInterval = Duration.millis(400);

    //Timeline firing = new Timeline(new KeyFrame(Duration.ZERO)),new KeyFrame(FiringInterval));

    BorderPane root = new BorderPane();

    Scene scene = new Scene(root, 6000, 3000);

    //Canon Canon1 = new Canon(1, 1000,1000,4,4);


    private List<Dart> darts = new ArrayList<>() ;

    private List<Dart> AlienDarts = new ArrayList<>() ;

    private List<Alien> Aliens = new ArrayList<>() ;

    private List<Canon> Canons = new ArrayList<>() ;

    double t = 0;


    public void shoot( Canon c){



        Dart d = new Dart(false, c.getX(),c.getY(),20,40,Color.BLUE);
        //d.move_up();
        darts.add(d);//On ajoute la dart a la liste
        System.out.println(c.getX());
        root.getChildren().add(d);

    }

    public void shoot_alien( Alien a){

        Dart z = new Dart(false, a.getX(), a.getY(),20,20,Color.YELLOW);
        AlienDarts.add(z);
        root.getChildren().add(z);
    }
    /*Duration FiringInterval = Duration.millis(400);
    Timeline firing1 = new Timeline(new KeyFrame(Duration.ZERO, event-> shoot(Canon1)),new KeyFrame(FiringInterval));
    firing1.setCycleCount(Animation.INDEFINITE);*/

    public void shoot_a(Alien a){
        Dart d = new Dart(false, a.x,a.y,40,40,Color.BLUE);
        //d.move_up();
        darts.add(d);//On ajoute la dart a la liste
        System.out.println(a.x);
        root.getChildren().add(d);

    }

    public void create_aliens() {
        for (i = 0; i < 8; i++) {
            Alien a = new Alien(false, 50 + i* 2 * 100, 50 + 3 * 50, Color.YELLOWGREEN);
            Alien b = new Alien(false,150 + 2*i*100,100,Color.RED);
            Alien c = new Alien(false,2*i*100,0,Color.BLANCHEDALMOND);
            b.rec.setFill(Color.RED);
            a.rec.setFill(Color.YELLOW);
            c.rec.setFill(Color.BLUE);
            root.getChildren().add(a.rec);
            root.getChildren().add(b.rec);
            root.getChildren().add(c.rec);
            Aliens.add(a);
            Aliens.add(b);
            Aliens.add(c);
        }
    }

    //Remove dead aliens

    /***
     * This function removes the dead aliens
     */
    public void remove_dead(){

        //root.getChildren().remove(Canon1.rec);
        //root.getChildren().stream();
        Aliens.forEach(s ->{
            if (s.dead){
                root.getChildren().remove(s.rec);
                root.getChildren().remove(s);
                Aliens.remove(s);
            }
        });

        darts.forEach(s ->{
            if (s.dead){
                root.getChildren().remove(s);
                darts.remove(s);
            }
        });

        AlienDarts.forEach(s ->{
            if (s.dead){
                root.getChildren().remove(s);
                AlienDarts.remove(s);
            }
        });

        Canons.forEach( c-> {
            if (c.dead){
                root.getChildren().remove(c.rec);
                root.getChildren().remove(c);
                Canons.remove(c);
            }
        });
    }

    Canon Canon1 = new Canon(false,1, 500,500,60,30);

    Canon Canon2 = new Canon(false,1,100,500,60,30);




    //Création des aliens
    /*

    Alien Alien1 = new Alien(false,1100,100,Color.RED);

    //dAlien1.rec.setFill(Color.RED);
    Alien Alien2 = new Alien(false,100,100,Color.RED);
    Alien Alien3 = new Alien(false,300,100,Color.RED);
    Alien Alien4 = new Alien(false,500,100,Color.RED);
    Alien Alien5 = new Alien(false,700,100,Color.RED);
    Alien Alien6 = new Alien(false,900,100,Color.RED);
    Alien Alien7 = new Alien(false,1300,100,Color.RED);

*/

    //Création des darts

    Dart d2 = new Dart(false,400,200,40,40,Color.AQUAMARINE);
    //darts.add(d2);



    public void start(Stage primarystage) throws IOException {
        Canons.add(Canon1);
        Canons.add(Canon2);


        darts.add(d2);
        //Aliens.add(Alien1);
        //Renderer renderer = new Renderer


        Duration FiringInterval = Duration.millis(400);
        Timeline firing1 = new Timeline(new KeyFrame(Duration.ZERO, event-> shoot(Canon1)),new KeyFrame(FiringInterval));
        firing1.setCycleCount(Animation.INDEFINITE);

        Duration FiringInterval2 = Duration.millis(400);
        Timeline firing2 = new Timeline(new KeyFrame(Duration.ZERO, event-> shoot(Canon2)),new KeyFrame(FiringInterval));
        firing2.setCycleCount(Animation.INDEFINITE);

        create_aliens();


        d2.setFill(Color.RED);
        //Alien1.rec.setFill(Color.RED);


        Canon1.rec.setFill(Color.CHARTREUSE);
        Canon2.rec.setFill(Color.RED);


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


        /*EventHandler<MouseEvent> eventHandler= new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent e) {
                System.out.println("Rectangle Clicked");
                shoot_cap=true;
            }
        };*/
        RotateTransition rt1= new RotateTransition(Duration.seconds(0.5), Canon1.getRec());


        //New Event
//Combination
        //final KeyCombination keyCombR = new KeyCodeCombination(KeyCode.RIGHT,KeyCombination.D);
        EventHandler<KeyEvent> eventHandlerup = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {


                if (e.getCode()== KeyCode.RIGHT){
                    System.out.println("RIGHT");
                    right_cap_1 = true;
                }
                if (e.getCode()== KeyCode.LEFT){
                    System.out.println("LEFT");
                    left_cap_1 = true;
                }
                if (e.getCode()== KeyCode.DOWN){
                    System.out.println("UP");
                    System.out.println(Canon1.getX());
                    up_cap_1 = true;
                }
                if (e.getCode()== KeyCode.UP){
                    System.out.println("DOWN");
                    down_cap_1 = true;
                }
                if (e.getCode()== KeyCode.D){
                    System.out.println("SHOOT");
                    firing1.playFromStart();
                }
                if (e.getCode()== KeyCode.SPACE){
                    System.out.println("SHOOT");
                    firing2.playFromStart();
                }
                if (e.getCode()== KeyCode.N){
                    System.out.println("RIGHT");
                    right_cap_2 = true;
                }
                if (e.getCode()== KeyCode.V){
                    System.out.println("LEFT");
                    left_cap_2 = true;
                }
                if (e.getCode()== KeyCode.G){
                    System.out.println("UP");
                    System.out.println(Canon1.getX());
                    up_cap_2 = true;
                }
                if (e.getCode()== KeyCode.B){
                    System.out.println("DOWN");
                    down_cap_2 = true;
                }



            }
        };

        EventHandler<KeyEvent> eventHandlerdown = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode()== KeyCode.RIGHT){
                    System.out.println("RIGHT");
                    right_cap_1 = false;
                }
                if (e.getCode()== KeyCode.LEFT){
                    System.out.println("LEFT");
                    left_cap_1 = false;
                }
                if (e.getCode()== KeyCode.DOWN){
                    System.out.println("UP");
                    System.out.println(Canon1.getX());
                    up_cap_1 = false;
                }
                if (e.getCode()== KeyCode.UP){
                    System.out.println("DOWN");
                    down_cap_1 = false;
                }
                if (e.getCode()== KeyCode.D){
                    System.out.println("SHOOT");
                    firing1.stop();
                }
                if (e.getCode()== KeyCode.SPACE){
                    System.out.println("SHOOT");
                    firing2.stop();
                }
                if (e.getCode()== KeyCode.N){
                    System.out.println("RIGHT");
                    right_cap_2 = false;
                }
                if (e.getCode()== KeyCode.V){
                    System.out.println("LEFT");
                    left_cap_2 = false;
                }
                if (e.getCode()== KeyCode.G){
                    System.out.println("UP");
                    System.out.println(Canon1.getX());
                    up_cap_2 = false;
                }
                if (e.getCode()== KeyCode.B){
                    System.out.println("DOWN");
                    down_cap_2 = false;
                }



            }
        };



        /*EventHandler<KeyEvent> shoot1 = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent  b) {
                if (b.getCode()== KeyCode.I){
                    System.out.println("SHOOT");
                    //shoot_cap = true;
                    Aliens.forEach(s->{shoot_a(s);

                    });
                    //shoot_a(Aliens);
                }
            }
        };*/

        scene.addEventHandler(KeyEvent.KEY_PRESSED,eventHandlerup);
        scene.addEventHandler(KeyEvent.KEY_RELEASED,eventHandlerdown);
        //scene.addEventHandler(KeyEvent.KEY_PRESSED,shoot1);
        //scene.addEventHandler(KeyEvent.KEY_PRESSED,shoot1);

        /*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override


            }
        });*/



        //Canon1.rec.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        //Canon1.rec.addEventFilter(KeyEvent.KEY_PRESSED, eventHandlerdown);

        //scene.addEventHandler(KeyEvent.KEY_PRESSED,keyListener);
        //scene.addEventHandler(KeyEvent.KEY_PRESSED,shoot1);
        //ADDS TO THE SCREEN

        root.getChildren().add(Canon1.rec);
        root.getChildren().add(Canon2.rec);

        //root.getChildren().add(d2);




        //Adding scene to the stage
        primarystage.setScene(scene);
        //Displaying the contents of the stage
        primarystage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                //shoot();

                int min = 0;
                int max = 4;

                if (a >23){
                    a = 0;
                }
                else{
                    a++;
                }

                System.out.println(a);
                if (a==1.0){
                    random_move = false;}
                if (a ==0.0){
                    random_move = true;}
                update();
                darts.forEach(s -> {
                    s.move_down();
                    Aliens.forEach(d->{


                    if (s.getBoundsInParent().intersects(d.rec.getBoundsInParent())) {
                        d.dead = true;
                        s.dead = true;
                        System.out.println("DEAD ALIEN 1");
                    }
                    });
                });
                AlienDarts.forEach(s-> {
                    s.move_up();
                    Canons.forEach(c->{
                        if (s.getBoundsInParent().intersects(c.rec.getBoundsInParent())) {
                            c.dead = true;
                            s.dead = true;
                            System.out.println("DEAD ALIEN 1");
                        }
                    });
                });




//Alien shoot
                y+= 0.01;
                Aliens.forEach(s->{


                    if (y>0.4 && y < 0.42){
                        if (Math.random()> 0.95){

                        shoot_alien(s);

                        }
                    }
                    if (y>1){
                        y = 0;
                    }
                });

                remove_dead();

                /*root.getChildren().removeIf(n->{
                    Alien s = (Alien.rec) n;
                    return s.dead;
                });*/
                d2.move_down();
            }
        };


        timer.start();




    }

    /*private List<Dart> Darts () {
        return root.getChildren().stream().map(n -> (Dart)n).collect(Collectors .toList());
    }*/

    /***
     * La function update va s'éxécuter à chaque itération du timer
     */
    public void update() {


        if (a==18.0 | a == 19.0 | a== 20.0 | a== 21.0 | a== 22.0 | a== 23.0) {

            Aliens.forEach(s ->{
                s.move_down();
            });
        }
        if (  a==0.0 | a == 1.0 | a== 2.0 | a== 3.0 | a== 4.0 | a==5.0){

            Aliens.forEach(s ->{
                s.move_right();
            });
        }

        if (  a==12.0 | a == 13.0 | a== 14.0 | a== 15.0 | a== 16.0 | a== 17.0){

            Aliens.forEach(s ->{
                s.move_left();
                //shoot_alien(s);
            });
        }

        if (  a==6.0 | a == 7.0 | a== 8.0 | a== 9.0 | a== 10.0 | a== 11.0){

            //System.out.println("RIGHT");
            Aliens.forEach(s ->{
                s.move_up();
            });

        }


        if (left_cap_1){
            Canon1.move_left(Frame1);
        }

        if (right_cap_1){
            Canon1.move_right(Frame1);
        }
        if (up_cap_1){
            Canon1.move_up(Frame1);
        }
        if (down_cap_1){
            Canon1.move_down(Frame1);
        }

        if (left_cap_2){


            Canon2.move_left(Frame1);
        }

        if (right_cap_2){


            Canon2.move_right(Frame1);

        }
        if (up_cap_2){


            Canon2.move_up(Frame1);

        }
        if (down_cap_2){


            Canon2.move_down(Frame1);
            //down_cap = false;
        }

        if (shoot_cap){
            //firing1.playFromStart();
            //shoot(Canon1);
            //shoot_cap = false;
        }

        if (!shoot_cap){
            //firing1.stop();
        }
        remove_dead();
        //REMOVE FROM SCREEN IF DEAD
/*
        root.getChildren().removeIf(n->{
            Dart s = (Dart ) n;
            return s.dead;
        });*/

        /*root.getChildren().removeIf(n->{
            Alien s = (Alien) n;
            return s.dead;
        });*/

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
