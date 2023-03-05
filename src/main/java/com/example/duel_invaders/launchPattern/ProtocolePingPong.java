package com.example.duel_invaders.launchPattern;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import com.example.duel_invaders.servPattern.IContext;
import com.example.duel_invaders.servPattern.IProtocole;


public class ProtocolePingPong implements IProtocole {

    public void execute( IContext c , InputStream unInput , OutputStream unOutput ) {
        while(true){
            String inputReq;
            BufferedReader is = new BufferedReader(new InputStreamReader(
                    unInput));
            PrintStream os = new PrintStream(unOutput);

            try {
                String valeurExpediee = "";

                if ((inputReq = is.readLine()) != null) {
                    System.out.println(" Ordre Recu " + inputReq);
                    String chaines[] = inputReq.split(" ");

                    if (chaines[0].contentEquals("PING")) {
                        valeurExpediee = "PONG";
                        System.out.println(" Reponse serveur "	+ valeurExpediee);
                    }
                    os.println(valeurExpediee);
                }
            } catch ( Exception e) {
                System.out.println(" Pb d'exception ");
            }
        }
    }
}
