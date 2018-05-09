// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.player;

import elements.spaceship.Spaceship;

import java.util.*;

public class PlayerSpaceships{

    /** Fields **/
    private List<Spaceship> spaceships;
    private Player player;
    private List<Spaceship> ownedSpaceships = new ArrayList<>();

    /** Constructor **/
    public PlayerSpaceships(List<Spaceship> spaceships, Player player){
        this.spaceships = spaceships;
        this.player = player;
    }

    public List<Spaceship> getOwnedSpaceships() {

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

        return ownedSpaceships;
    }
}
