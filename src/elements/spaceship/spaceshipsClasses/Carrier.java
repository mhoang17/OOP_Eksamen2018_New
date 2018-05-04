// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.spaceship.spaceshipsClasses;

import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.Unit;

public class Carrier extends Spaceship{

    public Carrier(Player player) {
        super("Carrier", player, 3, 9, 1, 6);
    }
}
