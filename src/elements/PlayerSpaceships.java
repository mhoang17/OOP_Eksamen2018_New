package elements;

import elements.spaceship.Spaceship;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;
import elements.spaceship.spaceshipsClasses.Destroyer;
import elements.spaceship.spaceshipsClasses.Dreadnought;

import java.util.*;

public class PlayerSpaceships{

    private List<Spaceship> ownedSpaceships = new ArrayList();
    private List spaceshipValues = new ArrayList();

    public void playerSpaceships(Galaxy galaxy, Player player){

        Carrier carrier = new Carrier(player);
        Cruiser cruiser = new Cruiser(player);
        Destroyer destroyer = new Destroyer(player);
        Dreadnought dreadnought = new Dreadnought(player);

        for(Spaceship spaceship : galaxy.getSpaceship()){

            if(spaceship.getOwner().contains(player.toString())){

                ownedSpaceships.add(spaceship);
            }
        }

        ownedSpaceships.sort(Comparator.comparing(Spaceship::getCombatValue));

        // TODO: sort if equal
    }
}
