package elements;

import java.util.*;

public class VerifyGalaxy {

    // Constants
    final static int MAX_CENTER_SIZE = 1;
    final static int MAX_SYSTEM_SIZE = 3;

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

        // If two systems has the same position
        legalPosition();
    }

    private void legalCenterPlanet(){

        Planet mecRex = new Planet("Mecatol Rex", 3);

        for(Systems system : galaxy.getSystems()){

            if(system.getPosition().equals("Center")){

                if(system.getPlanets().size() != MAX_CENTER_SIZE || !system.getPlanets().get(0).equals(mecRex)){

                    throw new IllegalCenterSystem();
                }
            }
        }
    }

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

            planetIter.next();
        }

        /*for(int i = 0; i < galaxy.getSystems().size(); i++){

            for (int j = 0; j < i; j++){

                //SystemOne: The first checked system which SystemTwo is compared to
                List systemOne = galaxy.getSystems().get(i).getPlanets();
                List systemTwo = galaxy.getSystems().get(j).getPlanets();

                for(int k = 0; k < systemTwo.size(); k++){

                    // Check if a planet occurs more than once
                    if(systemOne.contains(systemTwo.get(k))){

                        throw new IllegalPlanetOccurrence();
                    }
                }
            }
        }*/
    }

    private void legalSystemSize(){

        for (Systems system : galaxy.getSystems()){

            // Check if size is more than 3
            if(system.getPlanets().size() > MAX_SYSTEM_SIZE){

                throw new IllegalPlanetSizeSystem();
            }
        }
    }

    private void legalPosition(){

        for(int i = 0; i < galaxy.getSystems().size(); i++){

            for (int j = 0; j < i; j++){

                //SystemOne: The first checked system which SystemTwo is compared to
                String systemOne = galaxy.getSystems().get(i).getPosition();
                String systemTwo = galaxy.getSystems().get(j).getPosition();

                // Check if a position has been taken
                if(systemOne.equals(systemTwo)){

                    throw new IllegalPosition();
                }

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

        for (int i = 0; i < galaxy.getSystems().size(); i++){

            if(!system.getPosition().equals("Center")){

                for(int j = 0; j < compass.size(); j++){

                    //Uppercase in case a typo has happened
                    if(system.getPosition().toUpperCase().equals(compass.get(j).toUpperCase())){

                        southSystemIndx = j + 3;
                    }
                }
            }
            else {

                throw new IsCenterSystem();
            }
        }

        if (southSystemIndx > compass.size()){

            southSystemIndx -= compass.size();
        }

        String southSystem = compass.get(southSystemIndx);

        return southSystem;
    }
}
