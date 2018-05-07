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

    private RandomGalaxy test;
    private Player playerBlue;
    private Player playerRed;
    private List<Player> playerList;

    @BeforeEach
    void setUp(){

        playerBlue = new Player("NameOne", "RaceOne", "Blue");
        playerRed = new Player("NameTwo", "RaceTwo", "Red");

        playerList = new ArrayList<>();
        playerList.add(playerBlue);
        playerList.add(playerRed);

        test = new RandomGalaxy(playerList);
    }

    @Test
    //Test that the last system in random galaxy is Mecatol Rex
    void centerSystem(){

        Systems centerSystem = new Systems("Center");
        centerSystem.addPlanet(new Planet("Mecatol Rex", 0));

        assertEquals(centerSystem, test.getGalaxy().getSystems().get(6));
    }

}