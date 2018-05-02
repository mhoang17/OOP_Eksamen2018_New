package elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player playerOne;
    Player playerTwo;
    Player playerThree;

    @BeforeEach
    void setUp() {

        playerOne = new Player("Crassus", "The Emirates of Hacan", "Blue");
        playerTwo = new Player("Crassus", "The Emirates of Hacan", "Blue");

    }

    @Test
    void getColour() {

        assertEquals(playerOne.getColour(), "Blue");

    }

    // Ny test til assertTrue?
    @Test
    void equals() {

        assertEquals(playerOne, playerTwo);
        assertTrue(playerOne.hashCode() == playerTwo.hashCode());

    }

}