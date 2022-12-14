package com.example.duel_invaders;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

/**
 * Permet de lancer le jeu
 * Création des scènes et du AnimationTimer
 */
public class Main extends Application {
    private Player player1, player2;
    private String GameState;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root1 = new Pane();
        StackPane root2 = new StackPane();

        Scene scene1 = new Scene(root1, 800,700);
        Scene scene2 = new Scene(root2,800,700);

        Button startButton = new Button("Start Game");
        startButton.setBackground(Background.fill(Color.BLACK));
        startButton.setFont(new Font("Lato", 40));
        startButton.setStyle("-fx-text-fill: white");
        startButton.setLayoutX(270);
        startButton.setLayoutY(550);
        startButton.setPrefHeight(100);
        startButton.setPrefWidth(260);
        root1.getChildren().add(startButton);
        startButton.setOnAction(event -> {
            primaryStage.setScene(scene2);
        });

        Canvas canvas = new Canvas(800, 700);
        root2.getChildren().add(canvas);

        root2.setStyle("-fx-background-color: black;");
        Image img = new Image("https://static1.cbrimages.com/wordpress/wp-content/uploads/2020/08/Space-Invaders-Monster.jpg",800,700,false,false);
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        root1.setBackground(bGround);
        primaryStage.setTitle("Duel Invaders");
        primaryStage.setScene(scene1);
        primaryStage.show();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        GameEngine gameEngine = new GameEngine(800, 700, gc, "ON");
        player1 = gameEngine.getPlayer1();
        player2 = gameEngine.getPlayer2();

        InputHandler inputHandler = new InputHandler();
        scene2.setOnKeyPressed(inputHandler);
        scene2.setOnKeyReleased(inputHandler);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (gameEngine.getGameState().equals("ON")) {
                    gc.clearRect(0, 0, gameEngine.getWidth(), gameEngine.getHeight());
                    gameEngine.update(inputHandler.getActiveKeys(), gc, player1, player2, now);
                    gameEngine.update(inputHandler.getActiveKeys(), gc, player2, player1, now);
                    gameEngine.draw(gc, player1);
                    gc.save();
                    gc.rotate(180);
                    gc.translate(-gameEngine.getWidth(), -gameEngine.getHeight());
                    gameEngine.draw(gc, player2);
                    gc.restore();
                }
                else {
                    this.stop();
                    Text gameovertext = new Text();
                    gameovertext.setTextAlignment(TextAlignment.CENTER);
                    gameovertext.setFont(Font.font("Lato", FontWeight.BOLD, 40));
                    gameovertext.setFill(Color.WHITE);
                    gameovertext.setStroke(Color.GREEN);
                    if (gameEngine.getGameState().equals("LOSE")) {
                        gameovertext.setText("GAME OVER");
                    }
                    else {
                        gameovertext.setText("YOU WIN");
                    }
                    StackPane.setAlignment(gameovertext, Pos.CENTER);
                    root2.getChildren().add(gameovertext);

                }
            }
        };
        timer.start();

    }

}

