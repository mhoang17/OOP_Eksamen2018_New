package elements;

import elements.spaceship.Spaceship;

import java.util.*;

public class Combat {

    private final static int MIN_DICE_VAL = 0;
    private final static int MAX_DICE_VAL = 9;

    public Combat(Galaxy galaxy) {

        // TODO: Optimize
        Player playerBlue = galaxy.getPlayers().get(0);
        Player playerRed = galaxy.getPlayers().get(1);

        for(Systems system : galaxy.getSystems()) {

            // Store owned ships in system for each player
            List<Spaceship> playerBlueShips = new ArrayList();
            List<Spaceship> playerRedShips = new ArrayList();

            for (Spaceship spaceship : system.getSpaceships()) {

                if(spaceship.getOwner().equals(playerBlue.toString())){

                    playerBlueShips.add(spaceship);
                }
                else {
                    playerRedShips.add(spaceship);
                }
            }

            // Sort list so the ship with lowest resource cost is first
            playerBlueShips.sort(Comparator.comparing(Spaceship::getResourceCost));
            playerRedShips.sort(Comparator.comparing(Spaceship::getResourceCost));

            boolean createCombat = detectCombat(system);

            if(createCombat) {

                while(createCombat){

                    int playerBlueHit = doCombat(playerBlueShips);
                    int playerRedHit = doCombat(playerRedShips);

                    // Remove the number of ships after hit
                    // Optimize
                    if(playerBlueHit < playerRedShips.size()){

                        for(int i = 0; i < playerBlueHit; i++){

                            playerRedShips.remove(i);
                        }
                    }
                    else{

                        playerBlueHit = playerRedShips.size();

                        for(int i = 0; i < playerBlueHit; i++){

                            playerRedShips.remove(i);
                        }
                    }

                    if(playerRedHit < playerBlueShips.size()){

                        for (int i = 0; i < playerRedHit; i++){

                            playerBlueShips.remove(i);
                        }
                    }
                    else {

                        playerRedHit = playerBlueShips.size();

                        for (int i = 0; i < playerRedHit; i++){

                            playerBlueShips.remove(i);
                        }
                    }

                    if(playerBlueShips.size() == 0 && playerRedShips.size() == 0){

                        System.out.println("IT'S A TIE!");
                        createCombat = false;
                    }
                    else if(playerBlueShips.size() == 0){

                        System.out.println(playerRed.getName().toUpperCase() + " WINS!");
                        createCombat = false;
                    }
                    else if(playerRedShips.size() == 0){

                        System.out.println(playerBlue.getName().toUpperCase() + " WINS!");
                        createCombat = false;
                    }
                }
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

                    combat = true;
                    break;
                }

                shipIter.previous();
            }

            shipIter.next();
        }

        return combat;
    }

    public int doCombat(List<Spaceship> spaceshipsOne){

        Random rand = new Random();
        int hit = 0;

        for(Spaceship spaceship : spaceshipsOne){

            int dice = rand.nextInt((MAX_DICE_VAL - MIN_DICE_VAL + 1) + MIN_DICE_VAL);

            if(dice >= spaceship.getCombatValue()){

                hit++;
            }
        }

        return hit;
    }
}