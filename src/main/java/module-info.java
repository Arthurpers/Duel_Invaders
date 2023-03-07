module com.example.duel_invaders {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    exports com.example.duel_invaders.servPattern;
    opens com.example.duel_invaders.servPattern to javafx.fxml;
    exports com.example.duel_invaders.client;
    opens com.example.duel_invaders.client to javafx.fxml;
    exports com.example.duel_invaders.Tests.Tests_Strategy.unittests;
    exports com.example.duel_invaders.Tests.Tests_Strategy.tests;
}