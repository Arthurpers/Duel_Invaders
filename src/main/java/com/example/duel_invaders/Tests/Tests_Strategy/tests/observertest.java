package com.example.duel_invaders.Tests.Tests_Strategy.tests;

import com.example.duel_invaders.servPattern.Cannon;
import com.example.duel_invaders.servPattern.GameEngine;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class observertest {

    @Test
    public void testNotification(){
        Stage newWindow = new Stage();

        Pane root1 = new Pane();
        StackPane root2 = new StackPane();
        Stage stage1 = new Stage();
        Scene scene2 = new Scene(root2, 800,700);
        Canvas canvas = new Canvas(800, 700);
        root2.getChildren().add(canvas);

        GraphicsContext gc =canvas.getGraphicsContext2D();

        Scene scene = new Scene(root1, 450, 250);




        //GraphicsContext gc = canvas.getGraphicsContext2D();
        GameEngine gameEngine = new GameEngine(800, 700, gc, "ON");




        //création de l'observeur

        //GameEngine gameEngine = new GameEngine(800, 700, gc, "ON");

        //Création de l'observé
        Cannon Canon1 = new Cannon(20,20,40,40,400,400,2);

        //Ajout de la GameEngine comme observateur des sujets
        Canon1.addObserver(gameEngine);
        //Notifications des observateurs
        Canon1.kill();
        //Vérifier si l'observateur GameEngine a été notifié
        assertFalse(gameEngine.getGameState()== "LOSE");
    }
}
