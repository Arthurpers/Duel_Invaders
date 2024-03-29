package com.example.duel_invaders.servPattern;
import java.io.IOException;
import java.net.Socket;

class Processus extends Thread {

	private Socket clientSocket;
	private ServeurTCP monServeurTCP;

	public Processus(Socket uneSocket, ServeurTCP unServeur) {
		super("ServeurThread");
		clientSocket = uneSocket;
		System.out.println("[Processus] CLIENT : " + clientSocket);
		monServeurTCP = unServeur;
	} 

	public void run() {        
		try {

			monServeurTCP.getProtocole().execute( monServeurTCP.getContexte() , clientSocket.getInputStream() , clientSocket.getOutputStream() );

			System.out.println("Processus fait");
		} catch (IOException e) {
			System.err.println("[Processus Exception : " + e );
			e.printStackTrace();
		}
	} 
}
