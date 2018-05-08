// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.galaxy;

import elements.galaxy.exceptions.IllegalCenterSystem;
import elements.galaxy.exceptions.IllegalPlanetOccurrence;
import elements.galaxy.exceptions.IllegalPosition;
import elements.galaxy.exceptions.IllegalSystemSize;
import elements.planet.Planet;
import elements.systems.Systems;

import java.util.*;

public class VerifyGalaxy {

    /** Constants **/
    private final static int MAX_CENTER_SIZE = 1;
    private final static int MAX_SYSTEM_SIZE = 3;
    private final static int LEGAL_OCCURRENCE = 1;

    /** Field **/
    private Galaxy galaxy;

    public VerifyGalaxy(Galaxy galaxy) {

        this.galaxy = galaxy;
    }

    /** If center system doesn't contain the right planet or contains more planets **/
    public void legalCenterPlanet(){

        /* Make Mecatol Rex planet */
        Planet mecRex = new Planet("Mecatol Rex", 0);

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

    /** If planet occurs in more than one system **/
    public void legalPlanet(){

        int freq;

        for (Planet planet : galaxy.getPlanets()){

            freq = Collections.frequency(galaxy.getPlanets(), planet);

            /* If freq is over 1, then a planet occurs more than once in galaxy */
            if(freq > LEGAL_OCCURRENCE){

                throw new IllegalPlanetOccurrence(planet.getName() + " occurs more than once.");
            }
        }
    }

    /** If system has more than 3 planets **/
    public void legalSystemSize(){

        for (Systems system : galaxy.getSystems()){

            /* Check if size is more than 3 */
            if(system.getPlanets().size() > MAX_SYSTEM_SIZE){

                throw new IllegalSystemSize(system.toString() + " has more than three planets.");
            }
        }
    }

    public Boolean verifyPosition(Systems systemOne, Systems systemTwo){

        Boolean verified = false;

        /* If the system positions isn't north and south of each other */
        if(systemOne.getX() + systemTwo.getX() != 0 || systemOne.getY() + systemTwo.getY() != 0){

            throw new IllegalPosition();
        }
        else{
            verified = true;
        }

        return verified;
    }
}
