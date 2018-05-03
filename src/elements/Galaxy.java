package elements;

import elements.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

    // Field
    private List<Systems> systems;

    // Constructor
    public Galaxy(List<Systems> systems) {

        this.systems = systems;
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
