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

    private PresetConfigurations testGalaxy;
    private Combat combatTest;

    @BeforeEach
    void setUp(){

        /* Use PresetConfigurations class to quickly make a galaxy for testing */
        /* No need to make a galaxy from the bottom */
        testGalaxy = new PresetConfigurations();

        /* Only looking at the center system */
        combatTest = new Combat(testGalaxy.getCenter(), testGalaxy.getPlayerBlue(), testGalaxy.getPlayerRed());
    }

    @Test
    /* No combat occurs because only blue ships in system */
    void noCombatTest(){

        assertFalse(combatTest.detectCombat());
    }

    @Test
    void doCombatTest(){

        /* Add red ship to system to make a combat */
        testGalaxy.getCenter().newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));

        assertTrue(combatTest.detectCombat());
    }

    @Test
    void destroyShipTest(){

        /* List containing one ship */
        List<Spaceship> spaceshipList = new ArrayList<>();
        spaceshipList.add(new Carrier(testGalaxy.getPlayerBlue()));

        combatTest.destroyShip(spaceshipList, 5);

        /* All spaceships are removed */
        assertEquals(0, spaceshipList.size());
    }

    @Test
    void blueWinner(){

        testGalaxy.getCenter().newSpaceship(new Destroyer(testGalaxy.getPlayerRed()));
        /* Low risk of test failing */
        assertEquals(testGalaxy.getPlayerBlue(), combatTest.findWinner());
    }

    @Test
    void redWinner(){

        /* New system */
        Systems systemTest = new Systems("North");
        systemTest.newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));
        systemTest.newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));
        systemTest.newSpaceship(new Dreadnought(testGalaxy.getPlayerRed()));
        systemTest.newSpaceship(new Destroyer(testGalaxy.getPlayerBlue()));

        Combat combat = new Combat(systemTest, testGalaxy.getPlayerBlue(), testGalaxy.getPlayerRed());

        /* Low risk of test failing */
        assertEquals(testGalaxy.getPlayerRed(), combat.findWinner());
    }
}