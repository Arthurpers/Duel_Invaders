package com.example.duel_invaders.servPattern;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.util.*;


/**
 * Classe permettant de verifier les interactions entre les entités affichées, la mise à jour de ces entités et le dessin
 * de ces entités à chaque boucle du timer
 */
public class GameEngine {
    private String gameState;
    private int width;
    private int height;
    private GameSetup gamesetup;
    private GraphicsContext gc;
    private Player player1, player2;
    long now, last_update;

    public GameEngine(int width, int height, GraphicsContext gc, String gameState) {
        this.width = width;
        this.height = height;
        this.gc = gc;
        this.gameState = gameState;

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

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    /**
     * Vérifie les intersections entre entités, applique les déplacements et met à jour les entités
     * @param activeKeys touches du claviers activés
     * @param gc
     * @param player joueur principal considéré pour l'update
     * @param oppositePlayer joueur opposé considéré pour l'update
     * @param now temps donné par le timer
     */
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
                gameState = "LOSE";
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
                gameState = "LOSE";
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
        for (Dart dart : player.getDarts()) {
            if (dart.getBounds().intersects(oppositePlayer.getCannon().getOppositeBounds(width,height))){
                dart.kill();
                oppositePlayer.getCannon().kill();
                gameState = "LOSE";
                break;
            }
        }
        if (!player.getAlienWave().getAliens().isEmpty() && now - player.getAlienWave().getLast_update() >= 700_000_000){
            if(player.getAlienWave().shouldGoDown(width,player.getAlienWave().getClosestToBorder())){
                player.getAlienWave().moveDown();
            } else {
                player.getAlienWave().animateAlien();
            }
            player.getAlienWave().setLast_update(now);
            }
        if (player.getAlienWave().getAliens().isEmpty() && player2.getAlienWave().getAliens().isEmpty()){
            gameState = "WIN";
        }
        }


    /**
     * Dessine pour un joueur : son canon, ses darts et ses aliens
     * @param gc
     * @param player
     */
    public void draw(GraphicsContext gc,Player player) {
        gc.drawImage(player.getCannon().getCannonView().getImage(), player.getCannon().getX(), player.getCannon().getY(), player.getCannon().getWidth(), player.getCannon().getHeight());
        player.getAlienWave().getAliens().forEach(alien -> gc.drawImage(alien.getAlienView().getImage(), alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight()));
        gc.setFill(Color.RED);
        player.getDarts().forEach(dart -> gc.fillRect(dart.getX(), dart.getY(), dart.getWidth(), dart.getHeight()));
    }
}


