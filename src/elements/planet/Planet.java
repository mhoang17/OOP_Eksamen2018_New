// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.planet;

import elements.IllegalResourceProductionValue;

public class Planet {

    // Fields
    private String name;
    private int resourceProduction;

    // Constructor
    public Planet(String name, int resourceProduction) {
        this.name = name;
        this.resourceProduction = resourceProduction;

        // If resource value isn't valid
        if(resourceProduction < 0 || resourceProduction > 6){
            throw new IllegalResourceProductionValue();
        }
    }

    public String getName() {
        return name;
    }

    public int getResourceProduction() {
        return resourceProduction;
    }

    // Compares the names, but not the resource points
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Planet)) {
            return false;
        }

        Planet planet = (Planet) o;

        return getName().equals(planet.getName()) && getResourceProduction() == planet.getResourceProduction();
    }

    // When made to string, it only returns the name
    @Override
    public String toString() {
        return this.name;
    }
}
