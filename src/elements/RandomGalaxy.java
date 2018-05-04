package elements;

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
    private final static int ADD_SPACESHIP = 2;
    private final static int NO_SPACESHIP = 1;

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
    private List<String> compass = new ArrayList<>();
    private List<Spaceship> spaceshipTypes = new ArrayList<>();
    private List<Player> players;

    public RandomGalaxy(List<Player> players) {

        this.players = players;

        // Set lists
        setSystemList();
        setCompass();
        setSpaceshipTypes();

        // Create random galaxy
        randomSystems();
        randomSpaceships();

        // If only spaceships occurs in one system
        addMoreSpaceships();

        Galaxy galaxy = new Galaxy(systemList);

        VerifyGalaxy verifyGalaxy = new VerifyGalaxy(galaxy);

        Combat combat = new Combat(galaxy);








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

    public void addMoreSpaceships(){

        int count = 0;

        for(Systems system : systemList){

            // If system contains at least one spaceship
            if(system.getSpaceships().size() > 0){

                count++;
            }
        }

        // If count is less than one
        // then there's only spaceships in one system or none in galaxy
        if(count <= 1){

            randomSpaceships();
        }
    }

    public void randomSystems(){

        // Create Center system with Mecatol Rex
        mecRex.add(new Planet("Mecatol Rex", 3));
        Systems centerSystem = new Systems("Center", mecRex);
        systemList.add(centerSystem);

        for(String direction : compass){

            int maxIntSize = collectedPlanetList.size() - 1;

            Random rand = new Random();
            int randInt = rand.nextInt(maxIntSize + 1);

            // If system should contain a planet
            if(collectedPlanetList.get(randInt) != null){

                Systems system = new Systems(direction, collectedPlanetList.get(randInt));
                systemList.add(system);
                collectedPlanetList.remove(randInt);
            }
            // If system should be empty
            else{
                Systems system = new Systems(direction);
                systemList.add(system);
            }
        }
    }

    public void randomSpaceships(){

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
