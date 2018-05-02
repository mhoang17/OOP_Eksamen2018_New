package elements.spaceship;

import elements.Player;
import elements.spaceship.spaceshipsClasses.Carrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceshipTest {

    Player playerTest;
    Carrier shipTest;

    @BeforeEach
    void setUp(){

        playerTest = new Player("Crassus", "The Emirates of Hacan", "Blue");
        shipTest = new Carrier(playerTest);
    }

    @Test
    void costTest(){

        assertEquals(shipTest.getResourceCost(), 3);
    }

}