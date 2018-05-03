package elements;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SystemsTest {

    @Test
    void equals() {
        List planetTest = new ArrayList();
        planetTest.add(new Planet("Mecatol Rex", 3));

        Systems systemOne = new Systems("Center", planetTest);
        Systems systemTwo = new Systems("Center", planetTest);

        assertEquals(systemOne, systemTwo);

    }
}