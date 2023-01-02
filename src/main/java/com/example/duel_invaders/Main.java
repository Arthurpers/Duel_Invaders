package com.example.duel_invaders;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;





public class Main extends Application {
    private Player player1, player2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(800, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        root.setStyle("-fx-background-color: black;");

        Scene scene = new Scene(root);


        primaryStage.setTitle("Duel Invaders");
        primaryStage.setScene(scene);
        primaryStage.show();


        GameEngine gameEngine = new GameEngine(800, 700, gc);
        player1 = gameEngine.getPlayer1();
        player2 = gameEngine.getPlayer2();

        InputHandler inputHandler = new InputHandler();
        scene.setOnKeyPressed(inputHandler);
        scene.setOnKeyReleased(inputHandler);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.clearRect(0, 0, gameEngine.getWidth(), gameEngine.getHeight());
                gameEngine.update(inputHandler.getActiveKeys(),gc,player1,player2);
                gameEngine.update(inputHandler.getActiveKeys(),gc,player2,player1);
                gameEngine.draw(gc,player1);
                gc.save();
                gc.rotate(180);
                gc.translate(-gameEngine.getWidth(),-gameEngine.getHeight());
                gameEngine.draw(gc,player2);
                gc.restore();

            }
        };
        timer.start();
    }
}

