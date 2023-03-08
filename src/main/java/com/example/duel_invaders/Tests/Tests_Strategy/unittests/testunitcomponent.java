package com.example.duel_invaders.Tests.Tests_Strategy.unittests;

import com.example.duel_invaders.servPattern.Alien;
import com.example.duel_invaders.servPattern.AlienWave;
import com.example.duel_invaders.servPattern.Death1_Alien_Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class testunitcomponent {

    @Test
            public void testcomponent(){
        Alien alien1 = new Alien(20,20,40,40,new Death1_Alien_Strategy());
        List<Alien> aliens1 = new ArrayList<>();




        AlienWave AlienWave1 = new AlienWave(aliens1,2,0);
        //assertNotNull(Strat1);
        assertNotNull(AlienWave1);
    }

}
