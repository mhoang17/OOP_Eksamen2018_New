package elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    // Fields
    private String name;
    private String race;
    private String colour;
    private List<Planet> planetsControl = new ArrayList();

    // Constructor
    public Player(String name, String race, String colour) {
        this.name = name;
        this.race = race;
        this.colour = colour;
    }

    //Planets under control
    public void planetsUnderControl(Planet planet){

        planetsControl.add(planet);
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

    // Hashcode for colour
    public int hashCode() {
        return Objects.hashCode(colour);
    }

    // String
    @Override
    public String toString() {
        return "Player: " + this.name + ", " + this.race + ", " + this.colour;
    }
}
