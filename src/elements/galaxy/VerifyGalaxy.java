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

    // TODO: make it to hashmap
    private void legalPlanet(){

        // List of planet names
        List<String> planetList = new ArrayList();

        // Insert planet names from galaxy into planetList
        for (Planet planet : galaxy.getPlanets()){

            planetList.add(planet.toString());
        }

        // Sort planetList in alphabetical order
        Collections.sort(planetList);

        // List iterator
        ListIterator planetIter = planetList.listIterator();

        // Check previous to current
        while(planetIter.hasNext()){

            // If index is 0, it has no previous element and gives and error
            if(planetIter.nextIndex() != 0){

                String prevPlanet = (String) planetIter.previous();

                // Have to go up twice in order to reach the next element
                planetIter.next();
                String nextPlanet = (String) planetIter.next();

                // If next planet is the previous one
                if(nextPlanet.equals(prevPlanet)){

                    throw new IllegalPlanetOccurrence();
                }

                // Has to go to the previous because outside it goes to the next element
                planetIter.previous();
            }

            // Next element
            planetIter.next();
        }
    }

    private void legalSystemSize(){

        for (Systems system : galaxy.getSystems()){

            // Check if size is more than 3
            if(system.getPlanets().size() > MAX_SYSTEM_SIZE){

                throw new IllegalPlanetSizeSystem();
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
        /*else {

            throw new IsCenterSystem();
        }*/

        // If index exceeds size of compass list
        if (southSystemIndx > compass.size()){

            southSystemIndx -= compass.size();
        }

        // Finds the south position
        String southSystem = compass.get(southSystemIndx);

        return southSystem;
    }
}
