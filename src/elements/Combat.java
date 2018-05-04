package elements;

import elements.spaceship.Spaceship;

import java.util.*;

public class Combat {

    private final static int MIN_DICE_VAL = 0;
    private final static int MAX_DICE_VAL = 9;

    List<Spaceship> spaceships = new ArrayList<>();

    public Combat(Galaxy galaxy) {

        Random rand = new Random();

        for(Systems system : galaxy.getSystems()){

            boolean createCombat = detectCombat(system);

            if(createCombat){

            }
        }
    }

    public boolean detectCombat(Systems system){

        boolean combat = false;

        ListIterator shipIter = system.getSpaceships().listIterator();

        // Check if all spaceships belongs to one owner only
        while(shipIter.hasNext()){

            // First index doesn't have previous
            if(shipIter.nextIndex() != 0){

                Spaceship prevSpaceship = (Spaceship) shipIter.previous();

                shipIter.next();
                Spaceship nextSpaceship = (Spaceship) shipIter.next();

                // If a ship doesn't belong to the same owner
                // create combat
                if(!nextSpaceship.getOwner().equals(prevSpaceship.getOwner())){

                    System.out.println("Combat!");
                    combat = true;
                    break;
                }

                shipIter.previous();
            }

            shipIter.next();
        }

        return combat;
    }
}
