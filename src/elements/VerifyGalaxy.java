package elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VerifyGalaxy {

    private Galaxy galaxy;

    public VerifyGalaxy(Galaxy galaxy) {

        this.galaxy = galaxy;

        Planet mecRex = new Planet("Mecatol Rex", 3);

        for(int i = 0; i < galaxy.getSystems().size(); i++){

            if(galaxy.getSystems().get(i).getPosition().equals("Center")){

                Planet centerPlanet = galaxy.getSystems().get(i).getPlanets().get(0);

                if (!centerPlanet.equals(mecRex)){

                    System.out.println(centerPlanet);
                    System.out.println(mecRex);
                    throw new IllegalCenterSystem();
                }
            }
        }


    }

}
