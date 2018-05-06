// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.systems;

import elements.planet.Planet;
import elements.spaceship.Spaceship;

import java.util.*;

public class Systems {

    // Fields
    private String position;
    private List<Planet> planets = new ArrayList<>();
    private List<Spaceship> spaceships = new ArrayList<>();

    private List<Integer> coordinates = new ArrayList();
    private int x;
    private int y;

    // Constructor for empty system
    public Systems(String position, List<Planet> planets) {
        this.position = position;
        this.planets = planets;

        getCoordinates();

    }

    // Constructor for system with planet(s)
    public Systems(String position) {
        this.position = position;

        getCoordinates();
    }

    public String getPosition() {
        return position;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public List<Spaceship> getSpaceships() {
        return spaceships;
    }

    // Add new spaceship to system
    public void newSpaceship(Spaceship spaceship) {
        spaceships.add(spaceship);
    }

    public void removeSpaceship(Spaceship spaceship) {
        spaceships.remove(spaceship);
    }

    public void moveSpaceship(Spaceship spaceship, Systems newSystem) {
        newSystem.spaceships.add(spaceship);
        spaceships.remove(spaceship);
    }

    //Only works for one layer of systems
    public HashMap<String, List<Integer>> setCoordinates(){

        HashMap<String, List<Integer>> compass = new HashMap<>();

        // Set coordinates for one layer
        List<Integer> center = new ArrayList();
        List<Integer> north = new ArrayList();
        List<Integer> northEast = new ArrayList();
        List<Integer> southEast = new ArrayList();
        List<Integer> south = new ArrayList();
        List<Integer> southWest = new ArrayList();
        List<Integer> northWest = new ArrayList();

        center.add(0);
        center.add(0);

        north.add(0);
        north.add(1);

        northEast.add(1);
        northEast.add(1);

        southEast.add(1);
        southEast.add(-1);

        south.add(0);
        south.add(-1);

        southWest.add(-1);
        southWest.add(-1);

        northWest.add(-1);
        northWest.add(1);

        compass.put("Center", center);
        compass.put("North", north);
        compass.put("North-East", northEast);
        compass.put("South-East", southEast);
        compass.put("South", south);
        compass.put("South-West", southWest);
        compass.put("North-West", northWest);

        return compass;
    }

    public void getCoordinates(){

        // Make coordinates
        setCoordinates();

        // Set view of mappings in map
        Set set = setCoordinates().entrySet();
        Iterator iter = set.iterator();

        while(iter.hasNext()){

            // See what map entry is in current iteration
            Map.Entry posEntry = (Map.Entry) iter.next();

            if(posEntry.getKey().equals(position)){

                coordinates = (List) posEntry.getValue();
            }
        }

        x = coordinates.get(0);
        y = coordinates.get(1);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Systems)) {
            return false;
        }

        Systems system = (Systems) o;

        return getPlanets().equals(system.getPlanets());
    }

    @Override
    public String toString() {
        return this.position + ": " + this.planets;
    }
}
