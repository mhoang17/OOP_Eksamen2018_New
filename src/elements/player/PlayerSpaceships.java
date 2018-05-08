// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.player;

import elements.spaceship.Spaceship;

import java.util.*;

public class PlayerSpaceships{

    private List<Spaceship> ownedSpaceships = new ArrayList<>();

    public PlayerSpaceships(List<Spaceship> spaceships, Player player){

        /* List of ship owners */
        for(Spaceship spaceship : spaceships){

            if(spaceship.getOwner().equals(player)){

                ownedSpaceships.add(spaceship);
            }
        }

        /* Sort after combat value */
        ownedSpaceships.sort(Comparator.comparing(Spaceship::getCombatValue));

        /* Sort after resource cost */
        ownedSpaceships.sort((shipOne, shipTwo) -> shipTwo.cmpResourceCost(shipOne));
    }

    public List<Spaceship> getOwnedSpaceships() {

        return ownedSpaceships;
    }
}
