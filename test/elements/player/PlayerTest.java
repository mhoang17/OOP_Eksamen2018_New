// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    /** Field **/
    private Player player = new Player("Crassus", "The Emirates of Hacan", "Blue");

    @Test
    /* Test that getters give the correct value */
    void createPlayerTest() {

        String nameTest = player.getName();
        String raceTest = player.getRace();
        String colourTest = player.getColour();

        Player playerTest = new Player(nameTest, raceTest, colourTest);

        assertEquals(player, playerTest);

    }

    @Test
    /* Test that two different object types can't be compared */
    void equalsTest(){

        Integer test = 0;

        assertFalse(player.equals(test));
    }

    @Test
    void toStringTest(){

        assertEquals("Player: Crassus, The Emirates of Hacan, Blue", player.toString());
    }

}