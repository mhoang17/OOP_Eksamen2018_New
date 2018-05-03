import elements.Planet;
import elements.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Dreadnought;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PresetConfigurationsTest {

    private PresetConfigurations test;
    private Player playerOne;
    private List<Planet> mecRex = new ArrayList<>();
    private Spaceship dreadnought;

    @BeforeEach
    void setUp(){

        test = new PresetConfigurations();
        playerOne = new Player("Crassus", "The Emirates of Hacan", "Blue");
        mecRex.add(new Planet("Mecatol Rex", 3));
        dreadnought = new Dreadnought(playerOne);
    }

   @Test
    void playerTest(){

        assertEquals(test.getPlayerBlue(), playerOne);
        assertTrue(test.getPlayerBlue().hashCode() == playerOne.hashCode());

    }

    /*@Test
    void planetTest(){

        assertSame(test.getCenterSystem().getPlanets(), mecRex);
    }

    @Test
    void insertSpaceship(){

        assertEquals(test.getCenterSystem().getSpaceships().get(0), dreadnought);
    }*/

}