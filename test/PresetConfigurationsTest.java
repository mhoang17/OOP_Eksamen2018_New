import elements.planet.Planet;
import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Dreadnought;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PresetConfigurationsTest {

    final static int NUMBER_OF_SYSTEMS = 7;

    private PresetConfigurations test;
    private Player playerTest;
    private List<Planet> mecRex = new ArrayList<>();
    private Spaceship dreadnought;

    @BeforeEach
    void setUp(){

        test = new PresetConfigurations();
        playerTest = new Player("Crassus", "The Emirates of Hacan", "Blue");
        mecRex.add(new Planet("Mecatol Rex", 3));
        dreadnought = new Dreadnought(playerTest);
    }

   @Test
    // Test if the player is correctly initialised
    void playerTest(){

        assertEquals(test.getPlayerBlue(), playerTest);
    }

    @Test
    // Test that the players aren't the same
    void playerTestFalse(){

        assertFalse(test.getPlayerBlue().hashCode() == test.getPlayerRed().hashCode());
    }

    @Test
    // Test if correct planet is in system
    void planetTest(){

        assertEquals(test.getCenterSystem().getPlanets(), mecRex);
    }

    @Test
    // Test that all systems are in the galaxy
    void galaxySize(){

        assertEquals(test.getGalaxy().getSystems().size(), NUMBER_OF_SYSTEMS);
    }

    @Test
    // Test if spaceships have been added
    void insertSpaceship(){

        assertEquals(test.getCenterSystem().getSpaceships().get(0), dreadnought);
    }

}