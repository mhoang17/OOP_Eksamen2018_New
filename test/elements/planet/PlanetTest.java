package elements.planet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    private Planet planetTest;

    @BeforeEach
    void setUp(){

        planetTest = new Planet("Name", 0);
    }

    @Test
    void exceptionThrownTest(){

        /* Too high value of a resource production */
        assertThrows(IllegalResourceProduction.class, () -> new Planet("Mecatol Rex", 7));
    }

    @Test
    void equalsFalse(){

        assertFalse(planetTest.equals(1));
    }

    @Test
    void hashCodeTest(){

        assertTrue(planetTest.hashCode() == planetTest.hashCode());
    }
}