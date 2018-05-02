package elements.spaceship.spaceshipsClasses;

import elements.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.Unit;

public class Carrier extends Spaceship implements Unit {

    private Player player;

    public Carrier(Player player) {
        super("Carrier", player);
        this.player = player;
    }

    @Override
    public int getResourceCost() {
        return 3;
    }

    @Override
    public int getCombatValue() {
        return 9;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
    }

    @Override
    public int getCapacity() {
        return 6;
    }

    @Override
    public String getOwner() {
        return player.toString();
    }
}
