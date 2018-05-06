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

    //public boolean detectCombat(Systems system)
    public boolean detectCombat(){

        boolean combat = false;

        List<Player> ownerList = new ArrayList<>();
        int numOfShips = system.getSpaceships().size();

        for (Spaceship spaceship : system.getSpaceships()){

            ownerList.add(spaceship.getOwner());
        }

        // Check if player owns a ship
        int freqBlue = Collections.frequency(ownerList, playerBlue);
        int freqRed = Collections.frequency(ownerList, playerRed);

        // If all spaceships in system doesn't belong to one player
        if(freqBlue != numOfShips && freqRed != numOfShips){

            combat = true;
        }

        return combat;
    }

    public Player findWinner() {

        // Combat system begins
        //boolean createCombat = detectCombat(system);
        boolean createCombat = detectCombat();

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

        return winner;
    }

    public int doCombat(List<Spaceship> attackingShips){

        Random rand = new Random();
        int hit = 0;

        for(Spaceship spaceship : attackingShips){

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

            // If player blue didn't hit or has used all their hits
            // Prevents that it tries to use remove an item from an empty list
            if(enemyHit == NO_HITS){

                break;
            }

            spaceships.remove(0);
            enemyHit--;
        }
    }
}