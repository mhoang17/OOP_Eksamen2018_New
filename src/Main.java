import elements.Galaxy;
import elements.Planet;
import elements.Systems;
import elements.VerifyGalaxy;
import elements.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Planet> vegaSystem = new ArrayList<>();
        List<Spaceship> spaceships = new ArrayList<>();

        List<Planet> mecRex = new ArrayList();

        mecRex.add(new Planet("Mecatol Rex", 3));

        Planet vegaMin = new Planet("Vega Minor", 3);
        Planet vegMajor = new Planet("Vega Major", 6);

        vegaSystem.add(vegaMin);
        vegaSystem.add(vegMajor);

        Systems systemOne = new Systems("Center", mecRex);
        Systems systemTwo = new Systems("North", vegaSystem);

        List systems = new ArrayList();
        systems.add(systemOne);
        systems.add(systemTwo);

        Galaxy galaxy = new Galaxy(systems);

        VerifyGalaxy verify = new VerifyGalaxy(galaxy);
    }
}
