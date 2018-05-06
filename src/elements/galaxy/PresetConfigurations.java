package elements.galaxy;// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

import elements.WriteControlledPlanet;
import elements.galaxy.Galaxy;
import elements.galaxy.VerifyGalaxy;
import elements.gameplay.Combat;
import elements.planet.Planet;
import elements.player.Player;
import elements.player.PlayerSpaceships;
import elements.systems.Systems;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PresetConfigurations {

    //Players
    private Player playerBlue = new Player("Crassus", "The Emirates of Hacan", "Blue");
    private Player playerRed = new Player("Pompey", "Federation of Sol", "Red");

    //Systems
    private Systems centerSystem;

    //Galaxy
    private Galaxy galaxy;

    public PresetConfigurations() {

        // Mecatol Rex
        List<Planet> mecRex = new ArrayList();
        mecRex.add(new Planet("Mecatol Rex", 3));

        // Vaga planets
        List<Planet> vegaSystem = new ArrayList<>();
        vegaSystem.add(new Planet("Vega Minor", 3));
        vegaSystem.add(new Planet("Vega Major", 6));

        // Industrex
        List<Planet> indus = new ArrayList<>();
        indus.add(new Planet("Industrex", 6));

        // Rigel planets
        List<Planet> rigelSystem = new ArrayList<>();
        rigelSystem.add(new Planet("Rigel I", 1));
        rigelSystem.add(new Planet("Rigel II", 4));

        //Mirage
        List<Planet> mirage = new ArrayList<>();
        mirage.add(new Planet("Mirage", 2));

        // Systems
        centerSystem = new Systems("Center", mecRex);
        Systems northSystem = new Systems("North", vegaSystem);
        Systems northEastSystem = new Systems("North-East");
        Systems southEast = new Systems("South-East", indus);
        Systems southSystem = new Systems("South", rigelSystem);
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
        galaxy = new Galaxy();

        galaxy.addPlayer(playerBlue);
        galaxy.addPlayer(playerRed);

        galaxy.addSystems(centerSystem);
        galaxy.addSystems(northSystem);
        galaxy.addSystems(northEastSystem);
        galaxy.addSystems(southEast);
        galaxy.addSystems(southSystem);
        galaxy.addSystems(southWest);
        galaxy.addSystems(northWest);

        try {
            WriteControlledPlanet write = new WriteControlledPlanet(galaxy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters for testing
    public Player getPlayerBlue() {
        return playerBlue;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public Systems getCenterSystem() {
        return centerSystem;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }


}
