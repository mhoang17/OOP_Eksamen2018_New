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

        // Create file
        String outputName = "PlanetaryControl.txt";
        File outputFile = new File(outputName);

        //This method, the file will always be overwritten
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputName));

        for(Player player : galaxy.getPlayers()){

            //Write player to file
            writer.write(player.toString() + "\n");

            for(Systems system : galaxy.getSystems()){

                int numOfShips = system.getSpaceships().size();

                if(numOfShips != 0){

                    List<Player> ownerList = new ArrayList<>();

                    for (Spaceship spaceship : system.getSpaceships()){

                        ownerList.add(spaceship.getOwner());
                    }

                    // Check if player owns a ship
                    int freq = Collections.frequency(ownerList, player);

                    // If all spaceships in system belongs to one player
                    // and there's ships in system
                    if(freq == numOfShips){

                        for(Planet planet : system.getPlanets()){

                            writer.write(planet.toString() + "\n");
                        }
                    }
                }
            }

            // New line separates the players
            writer.write("\n");
        }

        // Stop writing to file
        writer.close();
    }
}
