// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.galaxy;

import elements.planet.Planet;
import elements.player.Player;
import elements.systems.Systems;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;

public class PresetConfigurations {

    /* Players */
    private Player playerBlue = new Player("Crassus", "The Emirates of Hacan", "Blue");
    private Player playerRed = new Player("Pompey", "Federation of Sol", "Red");

    /* Systems */
    private Systems center;

    /* Galaxy */
    private Galaxy galaxy;

    public PresetConfigurations() {

        /* Systems */
        center = new Systems("Center");
        Systems north = new Systems("North");
        Systems northEast = new Systems("North-East");
        Systems southEast = new Systems("South-East");
        Systems south = new Systems("South");
        Systems southWest = new Systems("South-West");
        Systems northWest = new Systems("North-West");

        /* Add planets to systems */
        center.addPlanet(new Planet("Mecatol Rex", 0));
        north.addPlanet(new Planet("Vega Minor", 3));
        north.addPlanet(new Planet("Vega Major", 6));
        southEast.addPlanet(new Planet("Industrex", 6));
        south.addPlanet(new Planet("Rigel I", 1));
        south.addPlanet(new Planet("Rigel II", 4));
        northWest.addPlanet(new Planet("Mirage", 2));

        /* Insert ships into systems */
        center.newSpaceship(new Dreadnought(playerBlue));
        center.newSpaceship(new Dreadnought(playerBlue));
        center.newSpaceship(new Destroyer(playerBlue));

        north.newSpaceship(new Cruiser(playerRed));
        north.newSpaceship(new Cruiser(playerRed));
        north.newSpaceship(new Carrier(playerRed));

        /* Insert systems to galaxy */
        galaxy = new Galaxy();

        galaxy.addPlayer(playerBlue);
        galaxy.addPlayer(playerRed);

        galaxy.addSystems(center);
        galaxy.addSystems(north);
        galaxy.addSystems(northEast);
        galaxy.addSystems(southEast);
        galaxy.addSystems(south);
        galaxy.addSystems(southWest);
        galaxy.addSystems(northWest);
    }

    /** Getters for testing **/
    public Player getPlayerBlue() {
        return playerBlue;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public Systems getCenter() {
        return center;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }


}
