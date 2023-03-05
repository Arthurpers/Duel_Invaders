package com.example.duel_invaders.servPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant d'initialiser les joueurs avec leur canon, leur vague d'alien et leurs darts au lancement du jeu
 *
 * Par rapport à la modification du projet, on utilise le pattern sujet/Observateur pour implémenter un nombre de vies du joueur.
 */
public class GameSetup {

    private Cannon cannon1, cannon2;
    private List<Alien> aliens1, aliens2;
    private List<Dart> darts1, darts2;
    private AlienWave alienWave1, alienWave2;
    private Player player1, player2;
    public GameSetup(int scenewitdh,int sceneheight) {
        cannon1 = new Cannon(scenewitdh / 2, sceneheight - 50, 40, 40,scenewitdh,sceneheight,2);
        aliens1 = new ArrayList<>();
        darts1 = new ArrayList<>();

        cannon2 = new Cannon(scenewitdh / 2, sceneheight - 50, 40, 40,scenewitdh,sceneheight,2);
        aliens2 = new ArrayList<>();
        darts2 = new ArrayList<>();

        int xi = 50;
        int yi = sceneheight / 2 + 10;
        int size_alien = 35;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 10; j++) {
                Alien alien1 = new Alien(xi + j * (size_alien + 3), yi + i * (size_alien + 3), size_alien, size_alien);
                Alien alien2 = new Alien(xi + j * (size_alien + 3), yi + i * (size_alien + 3), size_alien, size_alien);
                aliens1.add(alien1);
                aliens2.add(alien2);
            }
        }
        alienWave1 = new AlienWave(aliens1,1,0);
        alienWave2 = new AlienWave(aliens2, 1,0);
        Player player1 = new Player(alienWave1, darts1, cannon1, "RIGHT", "LEFT", "UP");
        Player player2 = new Player(alienWave2, darts2, cannon2, "D", "Q", "Z");

        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
