// Maria-Theresa Oanh Hoang
// AAU mail: mhoang17@student.aau.dk

package elements.gameplay;

import elements.player.Player;
import elements.spaceship.Spaceship;
import elements.systems.Systems;

import java.util.*;

public class Combat {

    private final static int MIN_DICE_VAL = 0;
    private final static int MAX_DICE_VAL = 9;
    private final static int NO_HITS = 0;

    private Systems system;
    private Player playerBlue;
    private Player playerRed;
    private Player winner;
    private List<Spaceship> blueShips = new ArrayList();
    private List<Spaceship> redShips = new ArrayList();

    public Combat(Systems system, Player playerBlue, Player playerRed) {
        this.system = system;
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;

        storeShips();

        combatSystem();
    }

    public void storeShips(){

        // Store owned ships in system for each player
        for (Spaceship spaceship : system.getSpaceships()) {

            if(spaceship.getOwner().equals(playerBlue)){

                blueShips.add(spaceship);
            }
            else {
                redShips.add(spaceship);
            }
        }

        // Sort list so the ship with lowest resource cost is first
        blueShips.sort(Comparator.comparing(Spaceship::getResourceCost));
        redShips.sort(Comparator.comparing(Spaceship::getResourceCost));
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

                    System.out.println("COMBAT!");
                    combat = true;
                    break;
                }

                shipIter.previous();
            }

            shipIter.next();
        }

        return combat;
    }

    public Player combatSystem() {

        // Combat system begins
        boolean createCombat = detectCombat(system);

        if(createCombat) {

            while(createCombat){

                //Create spaceship war!
                int playerBlueHit = doCombat(blueShips);
                int playerRedHit = doCombat(redShips);

                destroyShip(redShips, playerBlueHit);
                destroyShip(blueShips, playerRedHit);

                if(blueShips.size() == 0 && redShips.size() == 0){

                    createCombat = false;
                }
                // If all blue ships are destroyed
                else if(blueShips.size() == 0){

                    winner = playerRed;
                    createCombat = false;
                }
                // If all red ships are destroyed
                else if(redShips.size() == 0){

                    winner = playerBlue;
                    createCombat = false;
                }
            }
        }

        return winner;
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

    public void destroyShip(List<Spaceship> spaceships, int enemyHit){

        Iterator shipIter = spaceships.iterator();

        while(shipIter.hasNext()){

            // If player blue didn't hit or has used all the hits
            if(enemyHit == NO_HITS){

                break;
            }

            spaceships.remove(0);
            enemyHit--;
        }
    }

    public Player getWinner() {
        return winner;
    }
}