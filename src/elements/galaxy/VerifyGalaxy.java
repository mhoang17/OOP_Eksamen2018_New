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

                    throw new IllegalSystem("Center system doesn't contain Mecatol Rex as the only planet.");
                }
            }
        }
    }

    private void legalPlanet(){

        for (Planet planet : galaxy.getPlanets()){

            int freq = Collections.frequency(galaxy.getPlanets(), planet);

            // If freq is over 1, then a planet occurs more than once in galaxy
            if(freq > LEGAL_OCCURRENCE){

                throw new IllegalSystem(planet.getName() + " occurs more than once.");
            }
        }
    }

    private void legalSystemSize(){

        for (Systems system : galaxy.getSystems()){

            // Check if size is more than 3
            if(system.getPlanets().size() > MAX_SYSTEM_SIZE){

                throw new IllegalSystem(system.toString() + " has more than three planets.");
            }
        }
    }

    // TODO: reexamine method later
    public String compass(Systems system){

        List<String> compass = new ArrayList();
        int southSystemIndx = 0;

        compass.add("North");
        compass.add("North-West");
        compass.add("South-West");
        compass.add("South");
        compass.add("South-East");
        compass.add("North-East");

        // Only systems other than center has a south
        if(!system.getPosition().equals("Center")){

            for(int i = 0; i < compass.size(); i++){

                //Uppercase in case a typo has happened
                if(system.getPosition().toUpperCase().equals(compass.get(i).toUpperCase())){

                    southSystemIndx = i + 3;
                }
            }
        }

        // If index exceeds size of compass list
        if (southSystemIndx > compass.size()){

            southSystemIndx -= compass.size();
        }

        // Finds the south position
        String southSystem = compass.get(southSystemIndx);

        return southSystem;
    }
}
