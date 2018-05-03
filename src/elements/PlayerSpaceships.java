package elements;

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

        ownedSpaceships.sort(Comparator.comparing(Spaceship::getCombatValue));

        // TODO: sort if equal
    }
}
