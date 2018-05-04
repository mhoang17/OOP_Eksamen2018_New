// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.player;

import elements.galaxy.Galaxy;
import elements.spaceship.Spaceship;

import java.util.*;

public class PlayerSpaceships{

    private List<Spaceship> ownedSpaceships = new ArrayList();

    public PlayerSpaceships(Galaxy galaxy, Player player){

        for(Spaceship spaceship : galaxy.getSpaceship()){

            if(spaceship.getOwner().contains(player.toString())){

                ownedSpaceships.add(spaceship);
            }
        }

        // Sort after combat value
        ownedSpaceships.sort(Comparator.comparing(Spaceship::getCombatValue));

        // TODO: sort if equal
    }
}
