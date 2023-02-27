package com.example.duel_invaders.launchPattern;

import com.example.duel_invaders.client.ClientTCP;
import com.example.duel_invaders.client.InputHandler;

public class MainClient {

    public static void main(String[] args) {
        InputHandler Input1 = new InputHandler();
        ClientTCP myClt = new ClientTCP("localhost", 6666, Input1 );

        if ( myClt.connecterAuServeur() ) {
            myClt.transmettreChaine(String.valueOf(myClt.inPut.getActiveKeys()));
            //myClt.transmettreChaine("PAF");
            //myClt.transmettreChaineConnexionPonctuelle("PAAF");
            //myClt.deconnecterDuServeur();
        }

    }

}




