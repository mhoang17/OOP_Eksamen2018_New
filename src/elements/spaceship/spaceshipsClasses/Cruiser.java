package elements.spaceship.spaceshipsClasses;

import elements.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.Unit;

public class Cruiser extends Spaceship implements Unit {

    private Player player;

    public Cruiser(Player player) {
        super("Cruiser", player);
        this.player = player;
    }

    @Override
    public int getResourceCost() {
        return 2;
    }

    @Override
    public int getCombatValue() {
        return 7;
    }

    @Override
    public int getMovementSpeed() {
        return 2;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public String getOwner() {
        return player.toString();
    }
}
