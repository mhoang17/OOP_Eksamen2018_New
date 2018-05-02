package elements;

import java.util.Objects;

public class Player {

    private String name;
    private String race;
    private String colour;

    public Player(String name, String race, String colour) {
        this.name = name;
        this.race = race;
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    // Check if player is existing
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Player)) {
            return false;
        }

        Player player = (Player) o;

        return getColour().equals(player.getColour());
    }

    public int hashCode() {
        return Objects.hashCode(colour);
    }

    @Override
    public String toString() {
        return "Player: " + this.name + ", " + this.race + ", " + this.colour;
    }
}
