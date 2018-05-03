package elements;

import elements.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

    // Field
    private List<Systems> systems = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    // Constructor
    public Galaxy() {}

    // Add system
    public void addSystems(Systems system){

        systems.add(system);
    }

    // Add players
    public void addPlayer(Player player){

        players.add(player);
    }

    // Get players
    public List<Player> getPlayers() {
        return players;
    }

    // Get systems
    public List<Systems> getSystems() {

        return systems;
    }

    // Get planets
    public List<Planet> getPlanets(){

        List planets = new ArrayList();

        for(Systems system : systems){

            for(Planet planet : system.getPlanets()){

                planets.add(planet);
            }
        }
        return planets;
    }

    // Get spaceships
    public List<Spaceship> getSpaceship(){

        List spaceships = new ArrayList();

        for(Systems system : systems){

            for(Spaceship spaceship : system.getSpaceships()){

                spaceships.add(spaceship);
            }
        }

        return spaceships;
    }
}
