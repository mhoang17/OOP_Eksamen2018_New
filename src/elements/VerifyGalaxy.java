package elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VerifyGalaxy {

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

        for(int i = 0; i < galaxy.getSystems().size(); i++){

            if(galaxy.getSystems().get(i).getPosition().equals("Center")){

                Planet centerPlanet = galaxy.getSystems().get(i).getPlanets().get(0);

                if (!centerPlanet.equals(mecRex) || galaxy.getSystems().get(i).getPlanets().size() != 1){

                    throw new IllegalCenterSystem();
                }
            }
        }
    }

    private void legalPlanet(){

        for(int i = 0; i < galaxy.getSystems().size(); i++){

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
        }
    }

    private void legalSystemSize(){

        for (int i = 0; i < galaxy.getSystems().size(); i++){

            // Check if size is more than 3
            if(galaxy.getSystems().get(i).getPlanets().size() > 3){

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

                // Check if a planet occurs more than once
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
