package com.example.duel_invaders.launchPattern;

import com.example.duel_invaders.client.ClientTCP;

public class MainClient {

    public static void main(String[] args) {
        ClientTCP myClt = new ClientTCP("172.26.160.1", 6666 );

        if ( myClt.connecterAuServeur() ) {
            myClt.transmettreChaine("PING");
            myClt.deconnecterDuServeur();
        }

    }

}
//On a le meme main pour lancer le serveur et le client
//On a deux processus