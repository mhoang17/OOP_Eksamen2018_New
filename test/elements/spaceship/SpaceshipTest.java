// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.spaceship;

import elements.player.Player;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceshipTest {

    /** Fields **/
    private Player playerTest;
    private Spaceship spaceshipTest;

    @BeforeEach
    void setUp(){

        playerTest = new Player("Name", "Race", "Colour");
        spaceshipTest = new Carrier(playerTest);
    }

    @Test
    void toStringTest(){

        assertEquals("Colour: Carrier", spaceshipTest.toString());
    }

    @Test
    void equalsSame(){

        assertTrue(spaceshipTest.equals(spaceshipTest));
    }

    @Test
    void equalsFalse(){

        assertFalse(spaceshipTest.equals(playerTest));
    }

    @Test
    void carrierMovementSpeedTest(){

        assertEquals(1, spaceshipTest.getMovementSpeed());
    }

    @Test
    void carrierCapacityTest(){

        assertEquals(6, spaceshipTest.getCapacity());
    }

    @Test
    void cruiserResourceCost(){

        spaceshipTest = new Cruiser(playerTest);
        assertEquals(2, spaceshipTest.getResourceCost());
    }

    @Test
    void cruiserMovementSpeedTest(){

        spaceshipTest = new Cruiser(playerTest);
        assertEquals(2, spaceshipTest.getMovementSpeed());
    }

    @Test
    void cruiserCapacity(){

        spaceshipTest = new Cruiser(playerTest);
        assertEquals(0, spaceshipTest.getCapacity());
    }

    @Test
    void destroyerMovementSpeed(){

        spaceshipTest = new Destroyer(playerTest);
        assertEquals(2, spaceshipTest.getMovementSpeed());
    }

    @Test
    void destroyerCapacity(){

        spaceshipTest = new Destroyer(playerTest);
        assertEquals(0, spaceshipTest.getCapacity());
    }

    @Test
    void dreadnoughtMovementSpeed(){

        spaceshipTest = new Dreadnought(playerTest);
        assertEquals(1, spaceshipTest.getMovementSpeed());
    }

    @Test
    void dreadnoughtCapacity(){

        spaceshipTest = new Dreadnought(playerTest);
        assertEquals(0, spaceshipTest.getCapacity());
    }

}