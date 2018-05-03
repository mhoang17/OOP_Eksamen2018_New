package elements;

import elements.spaceship.Spaceship;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteControlledPlanet {

    private List<Player> players;

    public WriteControlledPlanet(Galaxy galaxy) throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter("PlanetaryControl.txt"));

        for(Player player : galaxy.getPlayers()){

            writer.write(player.toString() + "\n");

            for(Systems system : galaxy.getSystems()){

                int count = 0;

                for(Spaceship spaceship : system.getSpaceships()){

                    if(spaceship.getOwner().toString().equals(player.toString())){

                        count++;
                    }

                    // If counter is equal to size, then all ships in the system belongs to the player
                    if(count == system.getSpaceships().size()){

                        writer.write(system.getPlanets().toString() + "\n");
                    }
                }
            }

            // New line separates the players
            writer.write("\n");
        }

        writer.close();
    }
}
