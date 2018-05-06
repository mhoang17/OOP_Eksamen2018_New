// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.galaxy;

import elements.*;
import elements.planet.Planet;
import elements.systems.Systems;

import java.util.*;

public class VerifyGalaxy {

    // Constants
    private final static int MAX_CENTER_SIZE = 1;
    private final static int MAX_SYSTEM_SIZE = 3;
    private final static int LEGAL_OCCURRENCE = 1;

    // Field
    private Galaxy galaxy;

    public VerifyGalaxy(Galaxy galaxy) {

        this.galaxy = galaxy;

        // If center system doesn't contain the right planet or contains more planets
        legalCenterPlanet();

        // If planet occurs in more than one system
        legalPlanet();

        // If system has more than 3 planets
        legalSystemSize();
    }

    private void legalCenterPlanet(){

        // Make Mecatol Rex planet
        Planet mecRex = new Planet("Mecatol Rex", 3);

        for(Systems system : galaxy.getSystems()){

            // Check if system is center
            if(system.getPosition().equals("Center")){

                // If center system has more than one planet or if the planet is not Mecatol Rex
                if(system.getPlanets().size() != MAX_CENTER_SIZE || !system.getPlanets().get(0).equals(mecRex)){

                    throw new IllegalCenterSystem();
                }
            }
        }
    }

    private void legalPlanet(){

        for (Planet planet : galaxy.getPlanets()){

            int freq = Collections.frequency(galaxy.getPlanets(), planet);

            // If freq is over 1, then a planet occurs more than once in galaxy
            if(freq > LEGAL_OCCURRENCE){

                throw new IllegalPlanetOccurrence(planet.getName() + " occurs more than once.");
            }
        }
    }

    private void legalSystemSize(){

        for (Systems system : galaxy.getSystems()){

            // Check if size is more than 3
            if(system.getPlanets().size() > MAX_SYSTEM_SIZE){

                throw new IllegalSystemSize(system.toString() + " has more than three planets.");
            }
        }
    }

    public Boolean verifyPosition(Systems systemOne, Systems systemTwo){

        Boolean verified = false;

        if(systemOne.getX() + systemTwo.getX() != 0 || systemOne.getY() + systemTwo.getY() != 0){

            throw new IllegalPosition();
        }
        else{
            verified = true;
        }

        return verified;
    }
}
