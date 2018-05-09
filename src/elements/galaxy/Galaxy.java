// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.galaxy;

import elements.planet.Planet;
import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.systems.Systems;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

    /** Field **/
    private List<Systems> systems = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    /** Constructor **/
    public Galaxy() {
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Systems> getSystems() {
        return systems;
    }

    /** Planets in galaxy **/
    public List<Planet> getPlanets() {

        List planets = new ArrayList<>();

        for (Systems system : systems) {

            for (Planet planet : system.getPlanets()) {

                planets.add(planet);
            }
        }
        return planets;
    }

    /** Spaceships in galaxy **/
    public List<Spaceship> getSpaceships() {

        List spaceships = new ArrayList();

        for (Systems system : systems) {

            for (Spaceship spaceship : system.getSpaceships()) {

                spaceships.add(spaceship);
            }
        }

        return spaceships;
    }

    /** Add player to galaxy **/
    public void addPlayer(Player player) {
        players.add(player);
    }

    /** Add system to galaxy **/
    public void addSystems(Systems system) {
        systems.add(system);
    }

}
