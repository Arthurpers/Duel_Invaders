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

    private boolean leftPressed;
    private boolean rightPressed;
    private boolean spacePressed;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);


        primaryStage.setTitle("Duel Invaders");
        primaryStage.setScene(scene);
        primaryStage.show();


        GameEngine gameEngine = new GameEngine(800, 600, gc);
        InputHandler inputHandler = new InputHandler();
        scene.setOnKeyPressed(inputHandler);
        scene.setOnKeyReleased(inputHandler);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameEngine.update(inputHandler.getActiveKeys());
                gameEngine.draw(gc);
            }
        };
        timer.start();
    }
}

