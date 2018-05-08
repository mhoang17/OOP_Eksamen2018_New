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

    public Galaxy() {
    }

    public Galaxy(List<Systems> systems) {
        this.systems = systems;
    }

    public void addSystems(Systems system) {

        systems.add(system);
    }

    public void addPlayer(Player player) {

        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Systems> getSystems() {

        return systems;
    }

    public List<Planet> getPlanets() {

        List planets = new ArrayList<>();

        for (Systems system : systems) {

            for (Planet planet : system.getPlanets()) {

                planets.add(planet);
            }
        }
        return planets;
    }

    public List<Spaceship> getSpaceship() {

        List spaceships = new ArrayList();

        for (Systems system : systems) {

            for (Spaceship spaceship : system.getSpaceships()) {

                spaceships.add(spaceship);
            }
        }

        return spaceships;
    }

}
