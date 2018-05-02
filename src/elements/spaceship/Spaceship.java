package elements.spaceship;

import elements.Player;

public class Spaceship{

    private String type;
    private Player player;

    public Spaceship(String type, Player player) {
        this.type = type;
        this.player = player;
    }

    @Override
    public String toString() {
        return "Player " + this.player.getColour() + ": " + this.type;
    }

}
