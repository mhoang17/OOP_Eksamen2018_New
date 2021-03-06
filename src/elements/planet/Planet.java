// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.planet;

import java.util.Objects;

public class Planet {

    /** Constants **/
    private final static int MIN_RESOURCE = 0;
    private final static int MAX_RESOURCE = 6;

    /** Fields **/
    private String name;
    private int resourceProduction;

    /** Constructor **/
    public Planet(String name, int resourceProduction) {
        this.name = name;
        this.resourceProduction = resourceProduction;

        /* If resource value isn't valid */
        if(resourceProduction < MIN_RESOURCE || resourceProduction > MAX_RESOURCE){
            throw new IllegalResourceProduction();
        }
    }

    public String getName() {
        return name;
    }

    public int getResourceProduction() {
        return resourceProduction;
    }

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

    public int hashCode(){

        return Objects.hash(name, resourceProduction);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
