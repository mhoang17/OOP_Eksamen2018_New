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

public class WriteControlledPlanet {

    public WriteControlledPlanet(Galaxy galaxy) throws IOException{

        // Create file
        String outputName = "PlanetaryControl.txt";
        File outputFile = new File(outputName);

        //This method, the file will always be overwritten
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputName));

        // If file doesn't exist
        if(!outputFile.exists()){

            System.out.println("File doesn't exist.");
        }

        for(Player player : galaxy.getPlayers()){

            //Write player to file
            writer.write(player.toString() + "\n");

            for(Systems system : galaxy.getSystems()){

                int count = 0;

                for(Spaceship spaceship : system.getSpaceships()){

                    // Check if spaceship in system belongs to current player
                    if(spaceship.getOwner().equals(player)){

                        count++;
                    }

                    // If counter is equal to size, then all ships in the system belongs to the player
                    for(Planet planet : system.getPlanets()){

                        if(count == system.getSpaceships().size()){

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
