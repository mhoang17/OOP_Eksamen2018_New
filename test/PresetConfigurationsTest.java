import elements.galaxy.PresetConfigurations;
import elements.planet.Planet;
import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
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
    private Player playerTestTwo;
    private List<Spaceship> spaceshipsList = new ArrayList<>();

    @BeforeEach
    void setUp(){

        test = new PresetConfigurations();
        playerTest = new Player("Crassus", "The Emirates of Hacan", "Blue");
        playerTestTwo = new Player("Pompey", "Federation of Sol", "Red");

        spaceshipsList.add(new Dreadnought(playerTest));
        spaceshipsList.add(new Dreadnought(playerTest));
        spaceshipsList.add(new Destroyer(playerTest));
        spaceshipsList.add(new Cruiser(playerTestTwo));
        spaceshipsList.add(new Cruiser(playerTestTwo));
        spaceshipsList.add(new Carrier(playerTestTwo));
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

        List<Planet> mecRex = new ArrayList<>();
        mecRex.add(new Planet("Mecatol Rex", 3));
        assertEquals(test.getCenterSystem().getPlanets(), mecRex);
    }

    @Test
    // Test that all system inserted are in the galaxy
    void galaxySize(){

        assertEquals(test.getGalaxy().getSystems().size(), NUMBER_OF_SYSTEMS);
    }

    @Test
    // Test if spaceships have been added
    void insertSpaceship(){

        assertEquals(test.getCenterSystem().getSpaceships().get(0), spaceshipsList.get(0));
    }

    @Test
    void getSpaceship(){

        assertEquals(test.getGalaxy().getSpaceship(), spaceshipsList);
    }

}