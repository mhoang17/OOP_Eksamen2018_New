package elements.planet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    @Test
    void exceptionThrownTest(){

        assertThrows(Planet.IllegalResourceProductionValue.class, () -> new Planet("Mecatol Rex", 7));
    }

}