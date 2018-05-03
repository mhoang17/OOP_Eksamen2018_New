import elements.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Players
        Player playerBlue = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player playerRed = new Player("Pompey", "Federation of Sol", "Red");

        List<Player> playerList = new ArrayList<>();
        playerList.add(playerBlue);
        playerList.add(playerRed);

        RandomGalaxy test = new RandomGalaxy(playerList);

        /*//Players
        Player playerBlue = new Player("Crassus", "The Emirates of Hacan", "Blue");
        Player playerRed = new Player("Pompey", "Federation of Sol", "Red");

        List<Planet> mecRex = new ArrayList();
        List<Planet> vegaSystem = new ArrayList<>();
        List<Planet> rigelSystem = new ArrayList<>();

        List<Spaceship> spaceships = new ArrayList<>();

        mecRex.add(new Planet("Mecatol Rex", 3));

        Planet vegaMin = new Planet("Vega Minor", 3);
        Planet vegMajor = new Planet("Vega Major", 6);

        vegaSystem.add(vegaMin);
        vegaSystem.add(vegMajor);

        rigelSystem.add(new Planet("Rigel I", 1));
        rigelSystem.add(new Planet("Rigel II", 4));
        //rigelSystem.add(vegaMin);

        Systems systemOne = new Systems("Center", mecRex);
        Systems systemTwo = new Systems("North", vegaSystem);
        Systems systemThree = new Systems("North-East", rigelSystem);

        systemOne.newSpaceship(new Cruiser(playerRed));
        systemOne.newSpaceship(new Carrier(playerRed));
        systemTwo.newSpaceship(new Dreadnought(playerRed));

        Galaxy galaxy = new Galaxy();

        galaxy.addSystems(systemOne);
        galaxy.addSystems(systemTwo);
        galaxy.addSystems(systemThree);

        galaxy.addPlayer(playerBlue);
        galaxy.addPlayer(playerRed);

        VerifyGalaxy verify = new VerifyGalaxy(galaxy);

        PlayerSpaceships redSpaceships = new PlayerSpaceships(galaxy, playerRed);

        try {
            WriteControlledPlanet redPlayerControl = new WriteControlledPlanet(galaxy);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
