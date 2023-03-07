package com.example.duel_invaders.Tests.Tests_Strategy.tests;

import com.example.duel_invaders.servPattern.Alien;
import com.example.duel_invaders.servPattern.Death1_Alien_Strategy;
import com.example.duel_invaders.servPattern.Death2_Alien_Strategy;
import com.example.duel_invaders.servPattern.Death3_Alien_Strategy;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class strategytest {
    @Test
    /**
     * La classe teststrategy1 permet de vérifier le bon fonctionnement de la première strategy, celle ou un touché peut tuer l'alien.
     */
    public void teststrategy1() {
        Alien Alien1 = new Alien(20, 20, 25, 25, new Death1_Alien_Strategy());

        assertTrue(Alien1.isAlive());
        Alien1.kill();
        assertFalse(Alien1.isAlive());

    }

    /**
     * La class teststrategy2 permet de vérifier le bon fonctionnement de la deuxième strategy de mort de l'Alien, celle ou
     * deux touché peut le tuer.
     */
    @Test
    public void teststrategy2() {
        Alien Alien1 = new Alien(20, 20, 25, 25, new Death2_Alien_Strategy());

        assertTrue(Alien1.isAlive());
        Alien1.kill();
        assertTrue(Alien1.isAlive());
        Alien1.kill();
        assertFalse(Alien1.isAlive());

    }

    /**
     * Permet de vérifier la troisième strategy, celle ou 3 touché tue l'Alien.
     */
    @Test
    public void teststrategy3() {
        Alien Alien1 = new Alien(20, 20, 25, 25, new Death3_Alien_Strategy());

        assertTrue(Alien1.isAlive());
        Alien1.kill();
        assertTrue(Alien1.isAlive());
        Alien1.kill();
        assertTrue(Alien1.isAlive());
        Alien1.kill();
        assertFalse(Alien1.isAlive());

    }



}
