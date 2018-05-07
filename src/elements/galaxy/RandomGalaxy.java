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

public class RandomGalaxy {

    // Constants
    private final static int ADD_SPACESHIP = 1;
    private final static int NO_SPACESHIP = 0;
    private final static int MAX_PLANETS = 3;
    private final static int MAX_RESOURCE = 6;


    private Random rand = new Random();

    private Galaxy galaxy;

    private List<Player> players;
    private List<String> planetNames = new ArrayList<>();
    private List<Spaceship> playerShipsList = new ArrayList<>();


    public RandomGalaxy(List<Player> players) {

        this.players = players;
        galaxy = new Galaxy();

        // Create random galaxy
        randomSystems();
        addSpaceships();

        VerifyGalaxy verifyGalaxy = new VerifyGalaxy(galaxy);

        /*for (Player player : players){

            galaxy.addPlayer(player);
        }

        for(Systems system : galaxy.getSystems()){

            System.out.println(system.getPosition());
            System.out.println(system.getSpaceships());

            Combat doCombat = new Combat(system, galaxy.getPlayers().get(0), galaxy.getPlayers().get(1));

            if(doCombat.findWinner() != null){

                System.out.println("Winner: " + doCombat.findWinner().getName());
            }
            System.out.println("\n");
        }*/
    }

    private void setSystemList(){

        galaxy.addSystems(new Systems("North"));
        galaxy.addSystems(new Systems("North-West"));
        galaxy.addSystems(new Systems("South-West"));
        galaxy.addSystems(new Systems("South"));
        galaxy.addSystems(new Systems("South-East"));
        galaxy.addSystems(new Systems("North-East"));

    }

    private void setPlanetList(){

        planetNames.add("Vega Minor");
        planetNames.add("Vega Major");
        planetNames.add("Industrex");
        planetNames.add("Rigel I");
        planetNames.add("Rigel II");
        planetNames.add("Mirage");
        planetNames.add("Velnor");
        planetNames.add("Perimeter");
        planetNames.add("Hope's end");
        planetNames.add(null);
    }

    private void setPlayerShips() {

        for(Player player : players){

            playerShipsList.add(new Carrier(player));
            playerShipsList.add(new Cruiser(player));
            playerShipsList.add(new Destroyer(player));
            playerShipsList.add(new Dreadnought(player));
        }
    }

    private void randomSystems(){

        //Set lists
        setPlanetList();
        setSystemList();

        //Random ints
        int numPlanets;
        int resourceProduction;
        int planetName;

        for (Systems system : galaxy.getSystems()){

            numPlanets = rand.nextInt(MAX_PLANETS + 1);

            for(int i = 0; i < numPlanets; i++){

                planetName = rand.nextInt(planetNames.size());
                resourceProduction = rand.nextInt(MAX_RESOURCE + 1);

                if(planetNames.get(planetName) != null){

                    system.addPlanet(new Planet(planetNames.get(planetName), resourceProduction));

                    //Remove planet name, so it doesn't risk getting it again
                    planetNames.remove(planetName);
                }
            }
        }

        // Create Center system with Mecatol Rex
        Systems centerSystem = new Systems("Center");
        centerSystem.addPlanet(new Planet("Mecatol Rex", 0));
        galaxy.addSystems(centerSystem);

    }

    private void randomSpaceships(){

        setPlayerShips();

        boolean stopShipInsert;

        int addShip;
        int bound  = playerShipsList.size();

        int shipIndx;

        for(Systems system : galaxy.getSystems()){

            stopShipInsert = false;

            while(!stopShipInsert){

                addShip = rand.nextInt((ADD_SPACESHIP - NO_SPACESHIP + 1) + NO_SPACESHIP);

                // If random chooses addSpaceship
                if(addShip == ADD_SPACESHIP){

                    // Get random spaceship index
                    shipIndx = rand.nextInt(bound);

                    // Add spaceship to current system
                    system.newSpaceship(playerShipsList.get(shipIndx));
                }
                // Stop while-loop if no more spaceships should be added to system
                else {

                    stopShipInsert = true;
                }

            }

        }

    }

    private void addSpaceships(){

        int differentShipOwner = 0;

        while (differentShipOwner < 2){

            for (Systems system : galaxy.getSystems()){

                int count = 0;

                List<Player> owners = new ArrayList<>();

                for(Spaceship spaceship : system.getSpaceships()){

                    owners.add(spaceship.getOwner());
                }

                for (Player player : players){

                    int freq = Collections.frequency(owners, player);

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
}
