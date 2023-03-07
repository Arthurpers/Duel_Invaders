package com.example.duel_invaders.Tests.Tests_Strategy.unittests;

import com.example.duel_invaders.servPattern.Death1_Alien_Strategy;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class testunitstrategy {
    @Test
    public void testStrategy() {
        Death1_Alien_Strategy Strat1 = new Death1_Alien_Strategy();
        assertNotNull(Strat1);
    }
}
