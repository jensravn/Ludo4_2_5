package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Game {
    
    Player[] player;
    Board board;
    boolean winnerFound;
    int die;
    int attempts;
    
    /** Game Constructor */
    Game() {
        board = new Board();
        createPlayers();
    }
    
    /** Method to create oneToFour */
    void createPlayers() {
        System.out.print("How many players are you going to be? ");
        int numberOfPlayers = Scan.oneToFour();
        player = new Player[numberOfPlayers];
        
        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player();
            System.out.print("\nWhat's the name of player no. " + (i+1) + ": ");
            player[i].name = Scan.str();
        }
    }
    
    /** Play method */
    void play() {
        System.out.println("Let the game begin!");
        round();
    }
    
    /** Round method */
    void round() {
        int counter = 0;
        while (!winnerFound) {
            counter++;
            System.out.println("Round no. " + counter);
            turn();
        }
    }
    
    /** Turn method*/
    void turn() {
        
        for (int turn = 0; turn < player.length; turn++) {
            
            attempts = 1;
            
            while (attempts > 0) {
            
            if (player[turn].numberOfTokensInPlay() == 0) {
                attempts = 3;
            }
            
            die = Die.roll();
            System.out.println("Player no. " + (turn+1) + " " + player[turn].name + " - " + " has turn");
            System.out.println("You rolled " + die);
            
            if (noOptions(turn)) {
                int chosenToken = chooseToken(turn);
                player[turn].token[chosenToken].move(die);
            }
            
            attempts--;
            }
            if (player[turn].won()) {
                System.out.println("*** PLAYER NO. " + (turn+1) + " " +
                        player[turn].name.toUpperCase() + " - " + " WON! ***");
                System.exit(0);
            }
        }
    }
    
    boolean noOptions(int turn) {
        if(player[turn].numberOfTokensInPlay() == 0 && die != 6){
            return true;
        }
        return false;
    }
    
    int chooseToken(int turn) {
        int chosenToken = 4;
            if (player[turn].numberOfTokensInPlay() == 1) {
                for (int i = 0; i < 4; i++) {
                    if (player[turn].token[i].inPlay) {
                        chosenToken = i;
                    }
                }
            } else {
                System.out.println("You can move the following tokens: ");
                for (int i = 0; i < 4; i++) {
                    if(player[turn].token[i].inPlay) {
                        System.out.println("\n\tToken no. " + (i+1));
                    }
                }
                chosenToken = Scan.oneToFour();
                if (!player[turn].token[chosenToken].inPlay) {
                    System.out.print("You can't move that token! Try again - ");
                    chosenToken = chooseToken(turn);
                }
            }
        return chosenToken;
    }
}