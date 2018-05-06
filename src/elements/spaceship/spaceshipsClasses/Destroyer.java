// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.spaceship.spaceshipsClasses;

import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.Unit;

public class Destroyer extends Spaceship{

    public Destroyer(Player player) {
        super("Destroyer", player,1,9,2,0);
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
