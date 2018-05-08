// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements;

import elements.galaxy.Galaxy;
import elements.planet.Planet;
import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.systems.Systems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteControlledPlanet {

    public WriteControlledPlanet(Galaxy galaxy) throws IOException{

        /* Create file */
        String outputName = "PlanetaryControl.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputName));

        for(Player player : galaxy.getPlayers()){

            /* Write player to file */
            writer.write(player.toString() + "\n");

            for(Systems system : galaxy.getSystems()){

                int numOfShips = system.getSpaceships().size();

                /* Check if there are ships in system */
                if(numOfShips > 0){

                    Boolean notOwner = false;

                    for (Spaceship spaceship : system.getSpaceships()){

                        if(!spaceship.getOwner().equals(player)){

                            notOwner = true;
                        }
                    }

                    /* If all spaceships in system belongs to one player */
                    if(!notOwner){

                        for(Planet planet : system.getPlanets()){

                            writer.write(planet.toString() + "\n");
                        }
                    }
                }
            }

            writer.write("\n");
        }

        /* Stop writing to file */
        writer.close();
    }
}
