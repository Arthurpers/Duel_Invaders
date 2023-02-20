package com.example.duel_invaders.client;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.util.*;

/**
 * Classe permettant d'obtenir la liste des touche du clavier actives
 */
public class InputHandler implements EventHandler<KeyEvent> {
    final private Set<KeyCode> activeKeys = new HashSet<>();

    @Override
    public void handle(KeyEvent event) {
        if (KeyEvent.KEY_PRESSED.equals(event.getEventType())) {
            activeKeys.add(event.getCode());
        } else if (KeyEvent.KEY_RELEASED.equals(event.getEventType())) {
            activeKeys.remove(event.getCode());
        }
    }

    public Set<KeyCode> getActiveKeys() {
        return Collections.unmodifiableSet(activeKeys);
    }
}