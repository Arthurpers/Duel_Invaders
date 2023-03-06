package com.example.duel_invaders.servPattern;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shoot2_Alien_Strategy implements IAlien_K_strategy{

    public void kill(Alien a) {



        a.setNbHits(1);

        if (a.getNbHits() >2){
            a.setAlive(false);
        }


    }
    public void setImage(Alien a) {
        a.alienImage = new Image("file:src/main/java/com/example/duel_invaders/assets/alienred.png");
        a.alienView = new ImageView(a.alienImage);
    }
}
