package com.example.duel_invaders;

import java.util.List;

import static java.lang.Math.abs;

public class AlienWave {

    private List<Alien> aliens;
    private int direction;
    private long last_update;
    public AlienWave(List<Alien> aliens, int direction, long last_update) {
        this.aliens=aliens;
        this.direction=direction;
        this.last_update= last_update;
    }

    public boolean shouldGoDown(int sceneWidth, int closestToWall) {
        if (direction == 1) {
            return (abs(aliens.get(closestToWall).getX()-sceneWidth) < aliens.get(0).getWidth()+20);
        } else {
            return (abs(aliens.get(closestToWall).getX()) < aliens.get(0).getWidth()+20);
        }
    }

    public void animateAlien() {
            for (Alien alien: aliens) {
                alien.setX(alien.getX()+direction*20);
            }
    }
    public void moveDown(){
        for (Alien alien: aliens) {
            alien.setY(alien.getY()+alien.getHeight());
        }
        direction *=-1;
    }

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
