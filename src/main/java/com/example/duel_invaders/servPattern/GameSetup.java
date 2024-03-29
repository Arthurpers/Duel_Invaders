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


            for (int j = 0; j <= 10; j++) {
                Alien alien1 = new Alien(xi + j * (size_alien + 3), yi + 1 * (size_alien + 3), size_alien, size_alien, new Death3_Alien_Strategy());
                Alien alien2 = new Alien(xi + j * (size_alien + 3), yi + 1 * (size_alien + 3), size_alien, size_alien, new Death3_Alien_Strategy());
                //Alien qui auront trois vies

                Alien alien3 = new Alien(xi + j * (size_alien + 3), yi + 2 * (size_alien + 3), size_alien, size_alien, new Death2_Alien_Strategy());
                Alien alien4 = new Alien(xi + j * (size_alien + 3), yi + 2 * (size_alien + 3), size_alien, size_alien, new Death2_Alien_Strategy());
                //Alien qui auront deux vies
                Alien alien5 = new Alien(xi + j * (size_alien + 3), yi + 3 * (size_alien + 3), size_alien, size_alien, new Death1_Alien_Strategy());
                Alien alien6 = new Alien(xi + j * (size_alien + 3), yi + 3 * (size_alien + 3), size_alien, size_alien, new Death1_Alien_Strategy());
                //Alien qui auront une seule vie
                aliens1.add(alien1);
                aliens2.add(alien2);
                aliens1.add(alien3);
                aliens2.add(alien4);
                aliens1.add(alien5);
                aliens2.add(alien6);
            }
        for (Alien a:aliens1){
            a.setImage();
        }
        for (Alien b:aliens2){
            b.setImage();
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
