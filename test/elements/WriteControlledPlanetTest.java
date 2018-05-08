// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

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

import static org.junit.jupiter.api.Assertions.assertEquals;

class WriteControlledPlanetTest {

    private static int SECOND_LINE = 1;

    @BeforeEach
    void setUp() throws IOException {

        PresetConfigurations testGalaxy = new PresetConfigurations();
        testGalaxy.setPresetConfigurations();
        WriteControlledPlanet writeTest = new WriteControlledPlanet(testGalaxy.getGalaxy());
    }

    @Test
    void correctLineWritten() throws IOException {

        Path existingFile = Paths.get("PlanetaryControl.txt");
        BufferedReader reader = Files.newBufferedReader(existingFile);

        String line;

        /* Save each line of file into an arraylist */
        List<String> textFile = new ArrayList<>();

        while ((line = reader.readLine()) != null) {

            textFile.add(line);
        }

        /* Picked second line, but any line could be chosen, as long
        as the correct expected string is known */
        assertEquals("Mecatol Rex", textFile.get(SECOND_LINE));
    }

}