package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Game {

    Player[] player;
    Board board;
    boolean winnerFound;
    int dice;
    int attempts;
    boolean play;

    /**
     * Game Constructor
     */
    Game() {
        board = new Board();
        createPlayers();
    }

    /**
     * Method Create Players
     */
    void createPlayers() {
        System.out.print("How many players are you going to be? ");
        int numberOfPlayers = Scan.oneToFour();
        player = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player();
            System.out.print("\nWhat's the name of player no. " + (i + 1) + ": ");
            player[i].name = Scan.str();
        }
    }

    /**
     * Play method
     */
    void play() {
        System.out.println("Let the game begin!");
        round();
    }

    /**
     * Round method
     */
    void round() {
        int counter = 0;
        while (!winnerFound) {
            counter++;
            System.out.println("Round no. " + counter);
            turn();
        }
    }

    /**
     * Turn method
     */
    void turn() {

        while (!winnerFound) {
            for (int turn = 0; turn < player.length; turn++) {

                if (player[turn].numberOfTokensInPlay() == 0) {
                        attempts = 3;
                } else {
                    attempts = 1;
                }

                while (attempts > 0) {

                    dice = Die.roll();
                    System.out.println("\nPlayer no. " + (turn + 1) + " " + player[turn].name + " - " + " has turn");
                    System.out.println("You rolled " + dice);

                    if (!hasOptions(turn)) {
                        int chosenToken = chooseToken(turn);
                        player[turn].token[chosenToken].move(turn, dice, board);
                        board.printBoard();
                    }

                    attempts--;
                }
                if (player[turn].won()) {
                    System.out.println("*** PLAYER NO. " + (turn + 1) + " "
                            + player[turn].name.toUpperCase() + " - " + " WON! ***");
                    winnerFound = true;
                }
            }
        }
    }

    /** Method Has Options
     * Checks if the user can move a token.
     * Is false when no tokens are in play and the dice is not 6.
     * @param turn
     * @return 
     */
    boolean hasOptions(int turn) {
        if (player[turn].numberOfTokensInPlay() == 0 && dice != 6) {
            return true;
        }
        return false;
    }

    /** Method Choose Token
     * lets the user pick a specific token if multiple tokens are available
     * @param turn
     * @return 
     */
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
                if (player[turn].token[i].inPlay) {
                    System.out.println("\tToken no. " + (i + 1));
                }
            }
            System.out.println("Or you can get these into play: ");
            for (int i = 0; i < 4; i++) {
                if (dice == 6) {
                    
                    if (player[turn].token[i].start) {
                        System.out.println("\tToken no. " + (i + 1));
                    }
                }
            }
            
            chosenToken = Scan.oneToFour()-1;
            
            if (!player[turn].token[chosenToken].inPlay && !(player[turn].token[chosenToken].start && dice == 6)) {
                System.out.print("You can't move that token! Try again - ");
                chosenToken = chooseToken(turn);
            }
        }
        return chosenToken;
    }
}