package elements;

import elements.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.List;

public class Systems {

    // Fields
    private String position;
    private List<Planet> planets = new ArrayList<>();
    private List<Spaceship> spaceships = new ArrayList<>();

    // Constructor for empty system
    public Systems(String position) {
        this.position = position;
    }

    // Constructor for system with planet(s)
    public Systems(String position, List<Planet> planets) {
        this.position = position;
        this.planets = planets;
    }

    // Add new spaceship to system
    public void newSpaceship(Spaceship spaceship){
        spaceships.add(spaceship);
    }

    public void removeSpaceship(Spaceship spaceship){
        spaceships.remove(spaceship);
    }

    // Move existing spaceship from one system to another
    public void moveSpaceship(Spaceship spaceship, Systems newSystem){
        newSystem.spaceships.add(spaceship);
        spaceships.remove(spaceship);
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public List<Spaceship> getSpaceships() {
        return spaceships;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof List)) {
            return false;
        }

        List<Planet> planet = (ArrayList) o;

        return getPlanets().equals(planet);
    }
}
