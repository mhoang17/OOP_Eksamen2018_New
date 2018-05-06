// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.spaceship.spaceshipsClasses;

import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.Unit;

public class Cruiser extends Spaceship {

    public Cruiser(Player player) {
        super("Cruiser", player, 2, 7, 2, 0);
    }

    public int getResourceCost(){

        return super.getResourceCost();
    }

    public int getCombatValue(){

        return super.getCombatValue();
    }

    public int getMovementSpeed(){

        return  super.getMovementSpeed();
    }

    public int getCapacity(){

        return super.getCapacity();
    }

    public Player getOwner(){

        return super.getOwner();
    }
}
