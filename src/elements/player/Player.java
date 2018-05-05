// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.player;

import java.util.Objects;

public class Player {

    // Fields
    private String name;
    private String race;
    private String colour;

    // Constructor
    public Player(String name, String race, String colour) {
        this.name = name;
        this.race = race;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
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

        return  getName().equals(player.getName()) &&
                getRace().equals(player.getRace()) &&
                getColour().equals(player.getColour());
    }

    // Hashcode for colour
    public int hashCode() {
        return Objects.hash(name, race, colour);
    }

    // String
    @Override
    public String toString() {
        return "Player: " + this.name + ", " + this.race + ", " + this.colour;
    }
}
