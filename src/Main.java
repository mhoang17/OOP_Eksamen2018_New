import elements.Galaxy;
import elements.Planet;
import elements.Systems;
import elements.VerifyGalaxy;
import elements.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Planet> mecRex = new ArrayList();
        List<Planet> vegaSystem = new ArrayList<>();
        List<Planet> rigelSystem = new ArrayList<>();

        List<Spaceship> spaceships = new ArrayList<>();

        mecRex.add(new Planet("Mecatol Rex", 3));

        Planet vegaMin = new Planet("Vega Minor", 3);
        Planet vegMajor = new Planet("Vega Major", 6);

        vegaSystem.add(vegaMin);
        vegaSystem.add(vegMajor);

        rigelSystem.add(new Planet("Rigel I", 1));
        rigelSystem.add(new Planet("Rigel II", 4));

        Systems systemOne = new Systems("Center", mecRex);
        Systems systemTwo = new Systems("North", vegaSystem);
        Systems systemThree = new Systems("North-East", rigelSystem);

        List systems = new ArrayList();
        systems.add(systemOne);
        systems.add(systemTwo);
        systems.add(systemThree);

        Galaxy galaxy = new Galaxy(systems);

        VerifyGalaxy verify = new VerifyGalaxy(galaxy);

    }
}
