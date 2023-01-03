package com.example.duel_invaders;

import java.util.List;

import static java.lang.Math.abs;

/**
 * Classe permettant de gérer une vague d'alien
 */
public class AlienWave {

    private List<Alien> aliens;
    /**
     * Déplacement selon les x positifs : direction==1,
     * selon les x négatifs : direction==-1
     */
    private int direction;
    /**
     * temps donnée par animation timer correspondant au dernier mouvement de la vague d'alien
     */
    private long last_update;
    public AlienWave(List<Alien> aliens, int direction, long last_update) {
        this.aliens=aliens;
        this.direction=direction;
        this.last_update= last_update;
    }

    /**
     * Vérifie si une vague d'alien est arrivée au bout de l'écran est devrait descendre d'une ligne
     * @param sceneWidth
     * @param closestToWall
     * @return
     */
    public boolean shouldGoDown(int sceneWidth, int closestToWall) {
        if (direction == 1) {
            return (abs(aliens.get(closestToWall).getX()-sceneWidth) < aliens.get(0).getWidth()+20);
        } else {
            return (abs(aliens.get(closestToWall).getX()) < aliens.get(0).getWidth()+20);
        }
    }

    /**
     * Déplace une vague d'alien horizontalement
     */
    public void animateAlien() {
            for (Alien alien: aliens) {
                alien.setX(alien.getX()+direction*20);
            }
    }

    /**
     * Déplace une vague d'alien vers le bas
     */
    public void moveDown(){
        for (Alien alien: aliens) {
            alien.setY(alien.getY()+alien.getHeight());
        }
        direction *=-1;
    }

    /**
     * Détermine l'alien le plus proche du bord vers lequel se déplace la vague d'alien
     * @return l'indice de la liste correspondant à l'alien le plus proche du bord
     */
    public int getClosestToBorder() {
        if (aliens.isEmpty()) {
            return -1;
        }
        else {
            int closest = 0;
            for (int i=0; i< aliens.size();i++) {
                if (direction ==1 && aliens.get(i).getX()>aliens.get(closest).getX()){
                    closest =i;
                }
                else if (direction ==-1 && aliens.get(i).getX()<aliens.get(closest).getX()){
                    closest =i;
                }
            }
            return closest;
        }
    }

    public long getLast_update() {
        return last_update;
    }

    public void setLast_update(long last_update) {
        this.last_update = last_update;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
