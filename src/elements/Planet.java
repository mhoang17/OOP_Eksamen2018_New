package elements;

public class Planet {

    private String name;
    private int resourceProduction;

    public Planet(String name, int resourceProduction) {
        this.name = name;
        this.resourceProduction = resourceProduction;

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

        return getName().equals(planet.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
