package com.example.duel_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.util.*;
import java.util.ArrayList;


public class GameEngine {
    private static final int CANNON_SPEED = 5;
    private static final int ALIEN_SPEED = 1;
    private static final int MISSILE_SPEED = 5;

    private int width;
    private int height;

    private Cannon cannon;
    private List<Alien> aliens;
    private List<Dart> darts;


    private GraphicsContext gc;


    public GameEngine(int width, int height, GraphicsContext gc) {
        this.width = width;
        this.height = height;
        this.gc = gc;

        cannon = new Cannon(width / 2, height - 50, 50, 50);
        aliens = new ArrayList<>();
        darts = new ArrayList<>();



        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Alien alien = new Alien(50 + j * 58, 10 + i * 58, 50, 50);
                aliens.add(alien);
            }
        }
    }


    public void update(Set<KeyCode> activeKeys) {

        if (activeKeys.contains(KeyCode.LEFT)) {
            cannon.moveLeft();
        } else if (activeKeys.contains(KeyCode.RIGHT)) {
            cannon.moveRight();
        }

        if (activeKeys.contains(KeyCode.SPACE) && cannon.canFire()) {
            Dart dart = new Dart(cannon.getX() + cannon.getWidth() / 2, cannon.getY(), 5, 15);
            darts.add(dart);
            cannon.fire();
        }

//        aliens.forEach(Alien::moveDown);
        darts.forEach(Dart::moveUp);

        aliens.forEach(alien -> {
            if (alien.getY() > height) {
                alien.kill();
                //ET PARTIE PERDUE
            }
        });

        darts.forEach(dart -> {
            if (dart.getY() < 0) {
                dart.kill();
            }
        });

        aliens.removeIf(alien -> !alien.isAlive());
        darts.removeIf(dart -> !dart.isAlive());

        for (Alien alien : aliens) {
            if (cannon.getBounds().intersects(alien.getBounds())) {
                cannon.kill();
                alien.kill();
                break;
            }

            for (Dart dart : darts) {
                if (dart.getBounds().intersects(alien.getBounds())) {
                    dart.kill();
                    alien.kill();
                    System.out.println("kill");
                    break;
                }
            }
        }
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, width, height);
//        gc.setFill(Color.BLUE);
//        gc.fillRect(cannon.getX(), cannon.getY(), cannon.getWidth(), cannon.getHeight());
        gc.drawImage(cannon.getCannonView().getImage(), cannon.getX(), cannon.getY(), cannon.getWidth(), cannon.getHeight());
//        gc.setFill(Color.GREEN);
//        aliens.forEach(alien -> gc.fillRect(alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight()));
        aliens.forEach(alien -> gc.drawImage(alien.getAlienView().getImage(), alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight()));

        gc.setFill(Color.RED);
        darts.forEach(dart -> gc.fillRect(dart.getX(), dart.getY(), dart.getWidth(), dart.getHeight()));
    }
}


