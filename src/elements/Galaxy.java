package elements;

import elements.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

    private List<Systems> systems = new ArrayList<>();

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

        for(int i = 0; i < systems.size(); i++){

            for(int j = 0; j < systems.get(i).getPlanets().size(); j++){

                planets.add(systems.get(i).getPlanets().get(j));
            }
        }
        return planets;
    }

    // Get spaceships
    public List<Spaceship> getSpaceship(){

        List spaceships = new ArrayList();

        for(int i = 0; i < systems.size(); i++){

            for(int j = 0; j < systems.get(i).getSpaceships().size(); j++){

                spaceships.add(systems.get(i).getSpaceships().get(j));
            }
        }

        return spaceships;
    }
}
