// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.galaxy;

import elements.planet.Planet;
import elements.player.Player;
import elements.systems.Systems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomGalaxyTest {

    /** Field **/
    private RandomGalaxy test;

    @BeforeEach
    void setUp(){

        Player playerBlue = new Player("NameOne", "RaceOne", "Blue");
        Player playerRed = new Player("NameTwo", "RaceTwo", "Red");

        List<Player> playerList = new ArrayList<>();
        playerList.add(playerBlue);
        playerList.add(playerRed);

        test = new RandomGalaxy(playerList);
        test.randomSystems();

        /* Verify that the random galaxy made meets all requirements */
        VerifyGalaxy verifyGalaxy = new VerifyGalaxy(test.getGalaxy());
        verifyGalaxy.legalCenterPlanet();
        verifyGalaxy.legalPlanet();
        verifyGalaxy.legalSystemSize();
    }

    @Test
    /* Test that the last system in random galaxy is Mecatol Rex */
    void centerSystem(){

        Systems centerSystem = new Systems("Center");
        centerSystem.addPlanet(new Planet("Mecatol Rex", 0));

        assertEquals(centerSystem, test.getGalaxy().getSystems().get(6));
    }

    @Test
    /* Test that at least 4 spaceships are in galaxy.
    This means that there is the possibility that at least two systems,
    has spaceships from two players.
     */
    void addSpaceshipsTest(){

        test.addSpaceships();

        System.out.println(test.getGalaxy().getSpaceships().size());

        assertTrue(test.getGalaxy().getSpaceships().size() >= 4);
    }

}