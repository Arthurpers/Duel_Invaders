package com.example.duel_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.util.*;
import java.util.ArrayList;


public class GameEngine {
    private boolean gameOn;
    private int width;
    private int height;
    private GameSetup gamesetup;
    private GraphicsContext gc;
    private Player player1, player2;
    long now, last_update;

    public GameEngine(int width, int height, GraphicsContext gc, boolean gameOn) {
        this.width = width;
        this.height = height;
        this.gc = gc;
        this.gameOn = gameOn;

        gamesetup = new GameSetup(width,height);
        this.player1 = gamesetup.getPlayer1();
        this.player2 = gamesetup.getPlayer2();

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

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    public void update(Set<KeyCode> activeKeys, GraphicsContext gc, Player player, Player oppositePlayer, long now) {
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

        player.getAlienWave().getAliens().forEach(alien -> {
            if (alien.getY() > height) {
                alien.kill();
                gameOn = false;
            }
        });

        player.getDarts().forEach(dart -> {
            if (dart.getY() < 0) {
                dart.kill();
            }
        });

        player.getAlienWave().getAliens().removeIf(alien -> !alien.isAlive());
        player.getDarts().removeIf(dart -> !dart.isAlive());

        for (Alien alien : player.getAlienWave().getAliens()) {
            if (player.getCannon().getBounds().intersects(alien.getBounds())) {
                player.getCannon().kill();
                gameOn = false;
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
        for (Alien alien : oppositePlayer.getAlienWave().getAliens()) {
            for (Dart dart : player.getDarts()) {
                if (dart.getBounds().intersects(alien.getOppositeBounds(width,height))) {
                    dart.kill();
                    alien.kill();
                    break;
                }
            }

        }
        if (now - player.getAlienWave().getLast_update() >= 700_000_000){
            if(player.getAlienWave().shouldGoDown(width,player.getAlienWave().getClosestToBorder())){
                player.getAlienWave().moveDown();
            } else {
                player.getAlienWave().animateAlien();
            }
            player.getAlienWave().setLast_update(now);
            }
        }


    public void draw(GraphicsContext gc,Player player) {
        gc.drawImage(player.getCannon().getCannonView().getImage(), player.getCannon().getX(), player.getCannon().getY(), player.getCannon().getWidth(), player.getCannon().getHeight());
        player.getAlienWave().getAliens().forEach(alien -> gc.drawImage(alien.getAlienView().getImage(), alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight()));
        gc.setFill(Color.RED);
        player.getDarts().forEach(dart -> gc.fillRect(dart.getX(), dart.getY(), dart.getWidth(), dart.getHeight()));

    }
}


