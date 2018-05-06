// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.galaxy;

import elements.gameplay.Combat;
import elements.planet.Planet;
import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;
import elements.systems.Systems;

import java.util.ArrayList;
import java.util.Collections;
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

        for (Player player : players){

            galaxy.addPlayer(player);
        }

        for(Systems system : galaxy.getSystems()){

            Combat doCombat = new Combat(system, galaxy.getPlayers().get(0), galaxy.getPlayers().get(1));

            if(doCombat.findWinner() != null){

                System.out.println("Winner: " + doCombat.findWinner().getName());
            }
        }
    }

    private void randomSystems(){

        // Create Center system with Mecatol Rex
        mecRex.add(new Planet("Mecatol Rex", 3));
        Systems centerSystem = new Systems("Center", mecRex);
        systemList.add(centerSystem);

        // Create one layer of systems
        for(String position : compass){

            int maxIntSize = collectedPlanetList.size() - 1;

            Random rand = new Random();
            int randIndx = rand.nextInt(maxIntSize + 1);

            // If system should contain a planet
            if(collectedPlanetList.get(randIndx) != null){

                //Insert planet index points at into system
                Systems system = new Systems(position, collectedPlanetList.get(randIndx));
                systemList.add(system);
                collectedPlanetList.remove(randIndx);
            }
            // If system should be empty
            else{
                Systems system = new Systems(position);
                systemList.add(system);
            }
        }
    }

    private void randomSpaceships(){

        for(Systems system : systemList){

            boolean stopShipInsert = false;

            while(!stopShipInsert){

                Random rand = new Random();
                int addShip = rand.nextInt((ADD_SPACESHIP - NO_SPACESHIP + 1) + NO_SPACESHIP);

                // If random chooses addSpaceship
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

                    stopShipInsert = true;
                }

            }

        }

    }

    private void addMoreSpaceships(){

        int differentShipOwner = 0;

        while (differentShipOwner < 2){

            for (Systems system : systemList){

                int count = 0;

                List<Player> ownerList = new ArrayList<>();

                for (Spaceship spaceship : system.getSpaceships()){

                    ownerList.add(spaceship.getOwner());
                }

                for (Player player : players){

                    int freq = Collections.frequency(ownerList, player);

                    // Current player owns at least one spaceship in system
                    if(freq > 0){

                        count++;
                    }
                }

                // If count is equal or higher than two
                // system contains spaceships from at least two different players
                if(count >= 2){

                    differentShipOwner++;
                }
            }

            // If differentShipOwner is less than two,
            // then less than two systems contains ships from two different players,
            // and should continue to add random ships
            if(differentShipOwner < 2){

                differentShipOwner = 0;
                randomSpaceships();
            }
        }
    }

    private void setSystemList(){

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

    private void setSpaceshipTypes() {

        for(Player player : players){

            spaceshipTypes.add(new Carrier(player));
            spaceshipTypes.add(new Cruiser(player));
            spaceshipTypes.add(new Destroyer(player));
            spaceshipTypes.add(new Dreadnought(player));
        }
    }

    private void setCompass(){

        compass.add("North");
        compass.add("North-West");
        compass.add("South-West");
        compass.add("South");
        compass.add("South-East");
        compass.add("North-East");
    }
}
