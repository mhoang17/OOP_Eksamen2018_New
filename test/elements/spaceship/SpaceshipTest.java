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

    private Player playerTest;
    private Spaceship spaceshipTest;

    @BeforeEach
    void setUp(){

        playerTest = new Player("Name", "Race", "Colour");
    }

    @Test
    void toStringTest(){

        spaceshipTest = new Carrier(playerTest);
        assertEquals("Colour: Carrier", spaceshipTest.toString());
    }

    @Test
    void equalsSame(){

        spaceshipTest = new Carrier(playerTest);
        assertTrue(spaceshipTest.equals(spaceshipTest));
    }

    @Test
    void equalsFalse(){

        spaceshipTest = new Carrier(playerTest);
        assertFalse(spaceshipTest.equals(playerTest));
    }

    @Test
    void carrierMovementSpeedTest(){

        spaceshipTest = new Carrier(playerTest);
        assertEquals(1, spaceshipTest.getMovementSpeed());
    }

    @Test
    void carrierCapacityTest(){

        spaceshipTest = new Carrier(playerTest);
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