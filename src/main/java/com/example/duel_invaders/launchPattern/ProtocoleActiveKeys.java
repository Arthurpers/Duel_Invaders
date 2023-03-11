package com.example.duel_invaders.launchPattern;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import com.example.duel_invaders.servPattern.IContext;
import com.example.duel_invaders.servPattern.IProtocole;
import javafx.scene.input.KeyCode;


public class ProtocoleActiveKeys implements IProtocole {

    private Set<KeyCode> activeKeys = new HashSet<>();

    private Object monitor = new Object();

    public void execute( IContext c , InputStream unInput , OutputStream unOutput ) {
        while(true){
            String inputReq;
            BufferedReader is = new BufferedReader(new InputStreamReader(
                    unInput));
            PrintStream os = new PrintStream(unOutput);

            try {
                String valeurExpediee = "";

                if ((inputReq = is.readLine()) != null) {
                    inputReq = inputReq.substring(1,inputReq.length()-1); //suppression des crochets
//                    System.out.println(" Ordre Recu " + inputReq);
                    String[] keysArray = inputReq.split(", ");
                    activeKeys.clear();
                    for (String keyString : keysArray) {
                        try {
                            if (keyString.trim().equals("UP")) {
                                activeKeys.add(KeyCode.valueOf("Z"));
                            }
                            if (keyString.trim().equals("LEFT")) {
                                activeKeys.add(KeyCode.valueOf("Q"));
                            }
                            if (keyString.trim().equals("RIGHT")) {
                                activeKeys.add(KeyCode.valueOf("D"));
                            }
                        } catch (IllegalArgumentException e) {
//                            System.out.println("La clé '" + keyString.trim() + "' n'est pas valide.");
                        }
                    }
                    valeurExpediee = "OK";

                    System.out.println(activeKeys);


                    os.println(valeurExpediee);
                }
            } catch ( Exception e) {
//                System.out.println(" Pb d'exception ");
            }
        }
    }
    public Set<KeyCode> getActiveKeys() {
        synchronized(this) {
            return activeKeys;
        }
    }
}
