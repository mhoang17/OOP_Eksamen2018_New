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

    private List<Planet> planetListTest = new ArrayList();
    private List posPlanetTest = new ArrayList();
    private List<Systems> systemListTest = new ArrayList();

    @BeforeEach
    void setUp(){

        planetListTest.add(new Planet("Test", 1));
        posPlanetTest.add(new Planet("TestTwo", 1));
    }

    @Test
    void legalCenterPlanetTest(){

        systemListTest.add(new Systems("Center", planetListTest));
        Galaxy galaxyTest = new Galaxy(systemListTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        /* Not correct planet in center */
        assertThrows(IllegalCenterSystem.class, () -> test.legalCenterPlanet());

    }

    @Test
    void legalPlanetTest(){

        /* Add the same planet into planetList */
        planetListTest.add(new Planet("Test", 1));
        systemListTest.add(new Systems("North", planetListTest));
        Galaxy galaxyTest = new Galaxy(systemListTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        /* Same planet occurs in galaxy twice */
        assertThrows(IllegalPlanetOccurrence.class, () -> test.legalPlanet());
    }

    @Test
    void legalSystemSizeTest(){

        /* Add three more planets so planetList size is 4 */
        planetListTest.add(new Planet("TestOne", 1));
        planetListTest.add(new Planet("TestTwo", 1));
        planetListTest.add(new Planet("TestThree", 1));
        systemListTest.add(new Systems("North", planetListTest));
        Galaxy galaxyTest = new Galaxy(systemListTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertThrows(IllegalSystemSize.class, () -> test.legalSystemSize());

    }

    @Test
    /* Test that north is north of south */
    void northAndSouthTest(){

        systemListTest.add(new Systems("North", planetListTest));
        systemListTest.add(new Systems("South", posPlanetTest));
        Galaxy galaxyTest = new Galaxy(systemListTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertTrue(test.verifyPosition(galaxyTest.getSystems().get(0), galaxyTest.getSystems().get(1)));
    }

    @Test
    /* Test that south is south of north */
    void southAndNorthTest(){

        systemListTest.add(new Systems("North", planetListTest));
        systemListTest.add(new Systems("South", posPlanetTest));

        Galaxy galaxyTest = new Galaxy(systemListTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertTrue(test.verifyPosition(galaxyTest.getSystems().get(1), galaxyTest.getSystems().get(0)));
    }

    @Test
    /* Test that if they aren't north and south for each other */
    void isNotNorthSouth(){

        systemListTest.add(new Systems("North", planetListTest));
        systemListTest.add(new Systems("North-East", posPlanetTest));

        Galaxy galaxyTest = new Galaxy(systemListTest);
        VerifyGalaxy test = new VerifyGalaxy(galaxyTest);

        assertThrows(IllegalPosition.class,
                     () -> test.verifyPosition(galaxyTest.getSystems().get(0), galaxyTest.getSystems().get(1)));

    }

}