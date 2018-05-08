// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.player;

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

class PlayerSpaceshipsTest {

    private Player player = new Player("Crassus", "The Emirates of Hacan", "Blue");
    private List<Spaceship> expectedList = new ArrayList<>();
    private List<Spaceship> testList = new ArrayList<>();
    private PlayerSpaceships test;

    @BeforeEach
    void setUp(){

        /* Expected sorted list */
        expectedList.add(new Dreadnought(player));
        expectedList.add(new Dreadnought(player));
        expectedList.add(new Cruiser(player));
        expectedList.add(new Destroyer(player));
        expectedList.add(new Destroyer(player));
        expectedList.add(new Carrier(player));

        /* List in random order */
        testList.add(new Dreadnought(player));
        testList.add(new Destroyer(player));
        testList.add(new Cruiser(player));
        testList.add(new Carrier(player));
        testList.add(new Destroyer(player));
        testList.add(new Dreadnought(player));

        test = new PlayerSpaceships(testList, player);
    }

   @Test
   /* Test that the list is sorted correctly */
   void ownedShipsTest(){

       assertEquals(expectedList, test.getOwnedSpaceships());

   }

}