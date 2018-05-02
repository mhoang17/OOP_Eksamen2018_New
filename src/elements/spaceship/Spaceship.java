package elements.spaceship;

import elements.Player;
import elements.spaceship.spaceshipsClasses.Carrier;
import elements.spaceship.spaceshipsClasses.Cruiser;

public class Spaceship{

    private String type;
    private Player player;

    public Spaceship(String type, Player player) {
        this.type = type;
        this.player = player;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.player.getColour() + ": " + this.type;
    }

}
