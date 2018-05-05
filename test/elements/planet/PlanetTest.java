package elements.planet;

import elements.IllegalResourceProductionValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    @Test
    void exceptionThrownTest(){

        assertThrows(IllegalResourceProductionValue.class, () -> new Planet("Mecatol Rex", 7));
    }

}