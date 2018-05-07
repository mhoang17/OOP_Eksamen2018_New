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

        // Systems
        centerSystem = new Systems("Center");
        Systems north = new Systems("North");
        Systems northEast = new Systems("North-East");
        Systems southEast = new Systems("South-East");
        Systems south = new Systems("South");
        Systems southWest = new Systems("South-West");
        Systems northWest = new Systems("North-West");

        //Add planets to systems
        centerSystem.addPlanet(new Planet("Mecatol Rex", 0));
        north.addPlanet(new Planet("Vega Minor", 3));
        north.addPlanet(new Planet("Vega Major", 6));
        southEast.addPlanet(new Planet("Industrex", 6));
        south.addPlanet(new Planet("Rigel I", 1));
        south.addPlanet(new Planet("Rigel II", 4));
        northWest.addPlanet(new Planet("Mirage", 2));

        // Insert ships into systems
        centerSystem.newSpaceship(new Dreadnought(playerBlue));
        centerSystem.newSpaceship(new Dreadnought(playerBlue));
        centerSystem.newSpaceship(new Destroyer(playerBlue));

        north.newSpaceship(new Cruiser(playerRed));
        north.newSpaceship(new Cruiser(playerRed));
        north.newSpaceship(new Carrier(playerRed));

        // Insert systems to galaxy
        galaxy = new Galaxy();

        galaxy.addPlayer(playerBlue);
        galaxy.addPlayer(playerRed);

        galaxy.addSystems(centerSystem);
        galaxy.addSystems(north);
        galaxy.addSystems(northEast);
        galaxy.addSystems(southEast);
        galaxy.addSystems(south);
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
