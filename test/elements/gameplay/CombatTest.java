package elements.gameplay;

import elements.galaxy.PresetConfigurations;
import elements.spaceship.spaceshipsClasses.Dreadnought;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    PresetConfigurations testGalaxy;
    Combat combatTest;

    @BeforeEach
    void setUp(){

        testGalaxy = new PresetConfigurations();
        combatTest = new Combat(testGalaxy.getCenterSystem(), testGalaxy.getPlayerBlue(), testGalaxy.getPlayerRed());
    }

    @Test
    void noCombatTest(){

        assertFalse(combatTest.detectCombat());
    }

    @Test
    void doCombatTest(){

        testGalaxy.getCenterSystem().newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));

        assertTrue(combatTest.detectCombat());
    }

    @Test
    void findWinnerTest(){
        testGalaxy.getCenterSystem().newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));



    }


}