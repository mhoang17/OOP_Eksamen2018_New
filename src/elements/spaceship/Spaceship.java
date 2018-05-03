package elements.spaceship;

import elements.Player;

public class Spaceship implements Unit{

    private String type;
    private Player player;
    int resourceCost;
    int combatValue;
    int movementSpeed;
    int capacity;

    public Spaceship(String type, Player player, int resourceCost, int combatValue, int movementSpeed, int capacity) {
        this.type = type;
        this.player = player;
        this.resourceCost = resourceCost;
        this.combatValue = combatValue;
        this.movementSpeed = movementSpeed;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return this.player.getColour() + ": " + this.type;
    }

    @Override
    public int getResourceCost() {
        return this.resourceCost;
    }

    @Override
    public int getCombatValue() {
        return this.combatValue;
    }

    @Override
    public int getMovementSpeed() {
        return this.movementSpeed;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String getOwner() {
        return player.toString();
    }
}
