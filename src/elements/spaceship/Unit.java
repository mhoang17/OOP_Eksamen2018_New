// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.spaceship;

import elements.player.Player;

public interface Unit {

    int getResourceCost();
    int getCombatValue();
    int getMovementSpeed();
    int getCapacity();
    Player getOwner();
}
