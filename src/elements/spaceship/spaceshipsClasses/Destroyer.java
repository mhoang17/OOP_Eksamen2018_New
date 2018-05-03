package elements.spaceship.spaceshipsClasses;

import elements.Player;
import elements.spaceship.Spaceship;
import elements.spaceship.Unit;

public class Destroyer extends Spaceship implements Unit {

    private Player player;

    public Destroyer(Player player) {
        super("Destroyer", player,1,9,2,0);
        this.player = player;
    }

    @Override
    public int getResourceCost() {
        return 1;
    }

    @Override
    public int getCombatValue() {
        return 9;
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
