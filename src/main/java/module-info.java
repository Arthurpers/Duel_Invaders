module com.example.duel_invaders {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.duel_invaders.servPattern;
    opens com.example.duel_invaders.servPattern to javafx.fxml;
    exports com.example.duel_invaders.client;
    opens com.example.duel_invaders.client to javafx.fxml;
}