package elements.gameplay;

import elements.galaxy.PresetConfigurations;
import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;
import elements.systems.Systems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    PresetConfigurations testGalaxy;
    Combat combatTest;

    @BeforeEach
    void setUp(){

        testGalaxy = new PresetConfigurations();
        combatTest = new Combat(testGalaxy.getCenter(), testGalaxy.getPlayerBlue(), testGalaxy.getPlayerRed());
    }

    @Test
    void noCombatTest(){

        assertFalse(combatTest.detectCombat());
    }

    @Test
    void doCombatTest(){

        testGalaxy.getCenter().newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));

        assertTrue(combatTest.detectCombat());
    }

    @Test
    void destroyShipTest(){

        List<Spaceship> spaceshipList = new ArrayList<>();
        spaceshipList.add(new Carrier(testGalaxy.getPlayerBlue()));
        combatTest.destroyShip(spaceshipList, 5);

        assertEquals(0, spaceshipList.size());
    }

    @Test
    void blueWinner(){

        testGalaxy.getCenter().newSpaceship(new Destroyer(testGalaxy.getPlayerRed()));
        //Low risk of test failing
        assertEquals(testGalaxy.getPlayerBlue(), combatTest.findWinner());
    }

    @Test
    void redWinner(){

        Systems systemTest = new Systems("North");
        systemTest.newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));
        systemTest.newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));
        systemTest.newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));
        systemTest.newSpaceship(new Destroyer(testGalaxy.getPlayerBlue()));

        Combat combat = new Combat(systemTest, testGalaxy.getPlayerBlue(), testGalaxy.getPlayerRed());

        //Low risk of test failing
        assertEquals(testGalaxy.getPlayerRed(), combat.findWinner());
    }


}