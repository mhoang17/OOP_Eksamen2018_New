package elements.systems;

import elements.planet.Planet;
import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Carrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SystemsTest {

    private Systems system;
    private Player playerTest;
    private Spaceship spaceshipTest;

    @BeforeEach
    void setUp(){

        system = new Systems("North");
        playerTest = new Player("Name", "Race", "Colour");
        spaceshipTest = new Carrier(playerTest);
        system.newSpaceship(spaceshipTest);
    }

    @Test
    /* Test for constructor which takes both position and planets */
    void systemConstructor(){

        List<Planet> planetList = new ArrayList<>();
        planetList.add(new Planet("Name", 0));
        Systems systemtest = new Systems("South", planetList);

        assertEquals(planetList, systemtest.getPlanets());
    }

    @Test
    /* Test that x coordinate for North is correct */
    void xCoordinate(){

        assertEquals(0, system.getX());
    }

    @Test
    /* Test that y coordinate for North is correct */
    void yCoordinate(){

        assertEquals(1, system.getY());
    }

    @Test
    void addPlanetTest(){

        Planet planetTest = new Planet("Name", 0);
        system.addPlanet(planetTest);
        assertEquals(planetTest, system.getPlanets().get(0));
    }

    @Test
    void removeSpaceshipTest(){

        system.removeSpaceship(spaceshipTest);
        assertEquals(0, system.getSpaceships().size());
    }

    @Test
    void moveSpaceshipAddTest(){

        Systems systemMove = new Systems("North-East");
        system.moveSpaceship(spaceshipTest, systemMove);
        assertEquals(spaceshipTest, systemMove.getSpaceships().get(0));

    }

    @Test
    void moveSpaceshipRemoveTest(){

        Systems systemMove = new Systems("North-East");
        system.moveSpaceship(spaceshipTest, systemMove);
        assertEquals(0, system.getSpaceships().size());

    }

    @Test
    void toStringTest(){

        assertEquals("North: []", system.toString());
    }

    @Test
    void equalsSame(){

        assertEquals(system, system);
    }

    @Test
    void equalsFalse(){

        assertFalse(system.equals(1));
    }

}