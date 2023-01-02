package com.example.duel_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.util.*;
import java.util.ArrayList;


public class GameEngine {
    private static final int CANNON_SPEED = 5;
    private static final int ALIEN_SPEED = 1;
    private static final int MISSILE_SPEED = 5;

    final int width;
    final int height;

    private Cannon cannon1, cannon2;

    private List<Alien> aliens1, aliens2, allAliens;
    private List<Dart> darts1, darts2, allDarts;

    private GraphicsContext gc;
    private Player player1, player2;


    public GameEngine(int width, int height, GraphicsContext gc) {
        this.width = width;
        this.height = height;
        this.gc = gc;

        cannon1 = new Cannon(width / 2, height - 50, 40, 40);
        aliens1 = new ArrayList<>();
        darts1 = new ArrayList<>();
        Player player1 = new Player(aliens1,darts1,cannon1,"RIGHT","LEFT","UP");

        cannon2 = new Cannon(width / 2,  height-50, 40, 40);
        aliens2 = new ArrayList<>();
        darts2 = new ArrayList<>();
        Player player2 = new Player(aliens2,darts2,cannon2,"D","Q","Z");

        this.player1 = player1;
        this.player2 = player2;

        int xi = 50;
        int yi = height/2 +10;
        int size_alien = 35;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 10; j++) {
                Alien alien1 = new Alien(xi + j * (size_alien+3), yi + i * (size_alien+3), size_alien, size_alien);
                Alien alien2 = new Alien(xi + j * (size_alien+3), yi + i * (size_alien+3), size_alien, size_alien);
                aliens1.add(alien1);
                aliens2.add(alien2);
            }
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void update(Set<KeyCode> activeKeys, GraphicsContext gc, Player player, Player oppositePlayer) {
        if (activeKeys.contains(KeyCode.valueOf(player.getKeyLeft()))) {
            player.getCannon().moveLeft();
        } else if (activeKeys.contains(KeyCode.valueOf(player.getKeyRight()))) {
            player.getCannon().moveRight();
        }

        if (activeKeys.contains(KeyCode.valueOf(player.getKeyFire())) && player.getCannon().canFire()) {
            Dart dart = new Dart(player.getCannon().getX() + player.getCannon().getWidth() / 2, player.getCannon().getY(), 5, 15);
            player.getDarts().add(dart);
            player.getCannon().fire();
        }

        player.getDarts().forEach(Dart::moveUp);

        player.getAliens().forEach(alien -> {
            if (alien.getY() > height) {
                alien.kill();
                //ET PARTIE PERDUE
            }
        });

        player.getDarts().forEach(dart -> {
            if (dart.getY() < 0) {
                dart.kill();
            }
        });

        player.getAliens().removeIf(alien -> !alien.isAlive());
        player.getDarts().removeIf(dart -> !dart.isAlive());

        for (Alien alien : player.getAliens()) {
            if (player.getCannon().getBounds().intersects(alien.getBounds())) {
                player.getCannon().kill();
                alien.kill();
                break;
            }

            for (Dart dart : player.getDarts()) {
                if (dart.getBounds().intersects(alien.getBounds())) {
                    dart.kill();
                    alien.kill();
                    break;
                }
            }

        }
        for (Alien alien : oppositePlayer.getAliens()) {
            for (Dart dart : player.getDarts()) {
                if (dart.getBounds().intersects(alien.getBounds())) {
                    dart.kill();
                    alien.kill();
                    break;
                }
            }

        }
    }


    public void draw(GraphicsContext gc,Player player) {
        gc.drawImage(player.getCannon().getCannonView().getImage(), player.getCannon().getX(), player.getCannon().getY(), player.getCannon().getWidth(), player.getCannon().getHeight());
        player.getAliens().forEach(alien -> gc.drawImage(alien.getAlienView().getImage(), alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight()));
        gc.setFill(Color.RED);
        player.getDarts().forEach(dart -> gc.fillRect(dart.getX(), dart.getY(), dart.getWidth(), dart.getHeight()));

    }
}


