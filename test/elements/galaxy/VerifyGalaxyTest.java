// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.galaxy;

import elements.galaxy.exceptions.IllegalCenterSystem;
import elements.galaxy.exceptions.IllegalPlanetOccurrence;
import elements.galaxy.exceptions.IllegalPosition;
import elements.galaxy.exceptions.IllegalSystemSize;
import elements.planet.Planet;
import elements.systems.Systems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VerifyGalaxyTest {

    @Test
    void legalCenterPlanetTest(){

        Systems systemTest = new Systems("Center");
        systemTest.addPlanet(new Planet("Test", 0));

        Galaxy galaxyTest = new Galaxy();
        galaxyTest.addSystems(systemTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        /* Not correct planet in center */
        assertThrows(IllegalCenterSystem.class, test::legalCenterPlanet);

    }

    @Test
    void legalPlanetTest(){

        Systems systemTest = new Systems("North");
        systemTest.addPlanet(new Planet("Test", 0));
        systemTest.addPlanet(new Planet("Test", 0));

        Galaxy galaxyTest = new Galaxy();
        galaxyTest.addSystems(systemTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        /* Same planet occurs in galaxy twice */
        assertThrows(IllegalPlanetOccurrence.class, test::legalPlanet);
    }

    @Test
    void legalSystemSizeTest(){

        /* Add three more planets so planetList size is 4 */
        Systems systemTest = new Systems("North");
        systemTest.addPlanet(new Planet("TestOne", 1));
        systemTest.addPlanet(new Planet("TestTwo", 1));
        systemTest.addPlanet(new Planet("TestThree", 1));
        systemTest.addPlanet(new Planet("TestFour", 1));

        Galaxy galaxyTest = new Galaxy();
        galaxyTest.addSystems(systemTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertThrows(IllegalSystemSize.class, test::legalSystemSize);

    }

    @Test
    /* Test that north is north of south */
    void northAndSouthTest(){

        Systems systemOne = new Systems("North");
        Systems systemTwo = new Systems("South");
        systemOne.getCoordinates();
        systemTwo.getCoordinates();

        Galaxy galaxyTest = new Galaxy();
        galaxyTest.addSystems(systemOne);
        galaxyTest.addSystems(systemTwo);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertTrue(test.verifyPosition(galaxyTest.getSystems().get(0), galaxyTest.getSystems().get(1)));
    }

    @Test
    /* Test that south is south of north */
    void southAndNorthTest(){

        Systems systemOne = new Systems("North");
        Systems systemTwo = new Systems("South");
        systemOne.getCoordinates();
        systemTwo.getCoordinates();

        Galaxy galaxyTest = new Galaxy();
        galaxyTest.addSystems(systemOne);
        galaxyTest.addSystems(systemTwo);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertTrue(test.verifyPosition(galaxyTest.getSystems().get(1), galaxyTest.getSystems().get(0)));
    }

    @Test
    /* Test that if they aren't north and south for each other */
    void isNotNorthSouth(){

        Systems systemOne = new Systems("North");
        Systems systemTwo = new Systems("North-East");
        systemOne.getCoordinates();
        systemTwo.getCoordinates();

        Galaxy galaxyTest = new Galaxy();
        galaxyTest.addSystems(systemOne);
        galaxyTest.addSystems(systemTwo);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertThrows(IllegalPosition.class,
                     () -> test.verifyPosition(galaxyTest.getSystems().get(0), galaxyTest.getSystems().get(1)));

    }

}