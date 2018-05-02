package elements.spaceship.spaceshipsClasses;

import elements.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.Unit;

public class Dreadnought extends Spaceship implements Unit {

    Player player;

    public Dreadnought(Player player) {
        super("Dreadnought", player);
        this.player = player;
    }

    @Override
    public int getResourceCost() {
        return 5;
    }

    @Override
    public int getCombatValue() {
        return 5;
    }

    @Override
    public int getMovementSpeed() {
        return 1;
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
