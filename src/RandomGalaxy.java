import elements.*;
import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Design choice: like the board game some planets will always be in the same system eg. the Vega system

public class RandomGalaxy {

    // Constants
    final static int ADD_SPACESHIP = 2;
    final static int NO_SPACESHIP = 1;

    //Planets
    private List<Planet> mecRex = new ArrayList();
    private List<Planet> vegaSystem = new ArrayList<>();
    private List<Planet> rigelSystem = new ArrayList<>();
    private List<Planet> indus = new ArrayList<>();
    private List<Planet> mirage = new ArrayList<>();

    //List of planets
    private List<List<Planet>> collectedPlanetList = new ArrayList<>();

    //Lists
    private List<Systems> systemList = new ArrayList<>();
    private List<Spaceship> spaceshipList = new ArrayList<>();
    private List<String> compass = new ArrayList<>();
    private List<Spaceship> spaceshipTypes = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public RandomGalaxy(List<Player> players) {

        this.players = players;
        randomSystems();
        randomSpaceships();

        Galaxy galaxy = new Galaxy(systemList);

        // If only one ship is in galaxy
        // TODO: check if at least two systems has spaceships in them
        if(galaxy.getSpaceship().size() < 2){

            randomSpaceships();
        }

        // Write to file (MADE FOR FUN)
        for(Player player : players){

            galaxy.addPlayer(player);
        }

        try {
            WriteControlledPlanet write = new WriteControlledPlanet(galaxy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void randomSystems(){

        // Mecatol Rex
        mecRex.add(new Planet("Mecatol Rex", 3));
        Systems centerSystem = new Systems("Center", mecRex);

        setSystemList();
        setCompass();

        systemList.add(centerSystem);

        //TODO: make iterator
        // Create random systems
        for(String direction : compass){

            int maxIntSize = collectedPlanetList.size() - 1;

            // If maxInt size is 0, maxIntSize in the next iteration is negative
            // TODO: make this iterable
            if(maxIntSize == 0){

                break;
            }

            Random rand = new Random();
            int randInt = rand.nextInt(maxIntSize + 1);

            // If system should contain a planet
            if(collectedPlanetList.get(randInt) != null){

                Systems system = new Systems(direction, collectedPlanetList.get(randInt));
                systemList.add(system);
                collectedPlanetList.remove(randInt);
            }
            // Empty system
            else{
                Systems system = new Systems(direction);
                systemList.add(system);
                collectedPlanetList.remove(randInt);
            }
        }
    }

    public void randomSpaceships(){

        setSpaceshipTypes();

        for(Systems system : systemList){

            boolean insertShip = true;

            while(insertShip){

                Random rand = new Random();
                int addShip = rand.nextInt((ADD_SPACESHIP - NO_SPACESHIP + 1) + NO_SPACESHIP);

                if(addShip == ADD_SPACESHIP){

                    int maxIntSize = spaceshipTypes.size() - 1;

                    // Get random spaceship index
                    int randShipIndx = rand.nextInt(maxIntSize + 1);
                    Spaceship spaceship = spaceshipTypes.get(randShipIndx);

                    // Add spaceship to current system
                    system.newSpaceship(spaceship);
                }
                // Stop while-loop if no more spaceships should be added to system
                else {

                    insertShip = false;
                }

            }

        }

    }

    public void setSystemList(){

        // Vaga planets
        vegaSystem.add(new Planet("Vega Minor", 3));
        vegaSystem.add(new Planet("Vega Major", 6));

        // Industrex
        indus.add(new Planet("Industrex", 6));

        // Rigel planets
        rigelSystem.add(new Planet("Rigel I", 1));
        rigelSystem.add(new Planet("Rigel II", 4));

        //Mirage
        mirage.add(new Planet("Mirage", 2));

        collectedPlanetList.add(vegaSystem);
        collectedPlanetList.add(rigelSystem);
        collectedPlanetList.add(indus);
        collectedPlanetList.add(mirage);
        collectedPlanetList.add(null);
        collectedPlanetList.add(null);
    }

    public void setSpaceshipTypes() {

        for(Player player : players){

            spaceshipTypes.add(new Carrier(player));
            spaceshipTypes.add(new Cruiser(player));
            spaceshipTypes.add(new Destroyer(player));
            spaceshipTypes.add(new Dreadnought(player));
        }
    }

    public void setCompass(){

        compass.add("North");
        compass.add("North-West");
        compass.add("South-West");
        compass.add("South");
        compass.add("South-East");
        compass.add("North-East");
    }
}
