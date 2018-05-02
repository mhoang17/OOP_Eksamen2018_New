import elements.Galaxy;
import elements.Planet;
import elements.Player;
import elements.Systems;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PresetConfigurations {

    //Players
    private Player playerBlue = new Player("Crassus", "The Emirates of Hacan", "Blue");
    private Player playerRed = new Player("Pompey", "Federation of Sol", "Red");

    //Planets
    private List<Planet> mecRex = new ArrayList();
    private List<Planet> vegaSystem = new ArrayList<>();
    private List<Planet> indus = new ArrayList<>();
    private List<Planet> rigelSystem = new ArrayList<>();
    private List<Planet> mirage = new ArrayList<>();

    //Systems
    private Systems centerSystem;

    //Galaxy
    private Galaxy galaxy;

    public void presetConfigurations() {

        // Mecatol Rex
        mecRex.add(new Planet("Mecatol Rex", 3));

        // Vaga planets
        vegaSystem.add(new Planet("Vega Minor", 3));
        vegaSystem.add(new Planet("Vega Major", 6));

        // Industrex
        indus.add(new Planet("Industrex", 6));

        // Rigel planets
        rigelSystem.add(new Planet("Rigel I", 1));
        rigelSystem.add(new Planet("Rigel II", 4));

        //Mirage
        mirage.add(new Planet("Mirage", 2));

        // Systems
        centerSystem = new Systems("Center", mecRex);
        Systems northSystem = new Systems("North", vegaSystem);
        Systems northEastSystem = new Systems("North-East");
        Systems southEast = new Systems("South-East", indus);
        Systems south = new Systems("South", rigelSystem);
        Systems southWest = new Systems("South-West");
        Systems northWest = new Systems("North-West", mirage);

        // Insert ships into systems
        centerSystem.newSpaceship(new Dreadnought(playerBlue));
        centerSystem.newSpaceship(new Dreadnought(playerBlue));
        centerSystem.newSpaceship(new Destroyer(playerBlue));

        northSystem.newSpaceship(new Cruiser(playerRed));
        northSystem.newSpaceship(new Cruiser(playerRed));
        northSystem.newSpaceship(new Carrier(playerRed));

        // Insert systems to galaxy
        List systems = new ArrayList();
        systems.add(centerSystem);
        systems.add(northSystem);
        systems.add(northEastSystem);
        systems.add(southEast);
        systems.add(south);
        systems.add(southWest);
        systems.add(northWest);

        // Make galaxy
        galaxy = new Galaxy(systems);
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }

    public Systems getCenterSystem() {
        return centerSystem;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }


}
