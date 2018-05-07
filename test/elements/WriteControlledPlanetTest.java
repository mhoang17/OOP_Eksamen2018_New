package elements;

import elements.galaxy.PresetConfigurations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriteControlledPlanetTest {

    private PresetConfigurations testGalaxy;
    private WriteControlledPlanet writeTest;

    @BeforeEach
    void setUp() throws IOException {

        testGalaxy = new PresetConfigurations();
        writeTest = new WriteControlledPlanet(testGalaxy.getGalaxy());
    }

    @Test
    void correctLineWritten() throws IOException {

        Path existingFile = Paths.get("PlanetaryControl.txt");
        BufferedReader reader = Files.newBufferedReader(existingFile);

        String line;
        List<String> textFile = new ArrayList<>();

        while ((line = reader.readLine()) != null) {

            textFile.add(line);
        }

        assertEquals("Mecatol Rex", textFile.get(1));
    }

}