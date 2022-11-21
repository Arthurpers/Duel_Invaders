module com.example.duel_invaders {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.duel_invaders to javafx.fxml;
    exports com.example.duel_invaders;
}