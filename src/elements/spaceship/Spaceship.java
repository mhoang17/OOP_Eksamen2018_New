// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.spaceship;

import elements.player.Player;

public class Spaceship implements Unit{

    /** Fields **/
    private String type;
    private Player player;
    private int resourceCost;
    private int combatValue;
    private int movementSpeed;
    private int capacity;

    /** Constructor **/
    public Spaceship(String type, Player player, int resourceCost, int combatValue, int movementSpeed, int capacity) {
        this.type = type;
        this.player = player;
        this.resourceCost = resourceCost;
        this.combatValue = combatValue;
        this.movementSpeed = movementSpeed;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
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
    public Player getOwner() {
        return player;
    }

    @Override
    public String toString() {
        return this.player.getColour() + ": " + this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Spaceship)) {
            return false;
        }

        Spaceship spaceship = (Spaceship) o;

        return getOwner().equals(spaceship.getOwner()) && getType().equals(spaceship.getType());
    }

    /** If combat value is equal, sort after resource cost **/
    public int cmpResourceCost(Spaceship that) {

        if(that.getCombatValue() == getCombatValue()){

            return Integer.compare(that.getResourceCost(), getResourceCost());
        }

        return 0;
    }
}
