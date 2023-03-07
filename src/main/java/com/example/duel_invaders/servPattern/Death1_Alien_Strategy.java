package com.example.duel_invaders.servPattern;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Death1_Alien_Strategy implements IAlien_death_strategy {

    @Override
    public void kill(Alien a) {
        a.setAlive(false);
    }

    @Override
    public void setImage(Alien a) {
        a.alienImage = new Image("file:src/main/java/com/example/duel_invaders/assets/alienwhite.png");
        a.alienView = new ImageView(a.alienImage);
    }
}
