package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Game {

    boolean DEBUGMODE = false;

    Player[] player;
    Board board;
    boolean winnerFound;
    int dice;
    int attempts;

    /**
     * Game Constructor creates the instance of the board and calls
     * createPlayers()
     */
    Game() {
        board = new Board();
        createPlayers();
    }
    
    /**
     * Game Constructor to use in testing (Skips the name input)
     * 
     * @param numberOfPlayers 
     */
    Game(int numberOfPlayers) {
        board = new Board();
        createPlayers(4);
    }

    /**
     * Method CreatePlayers create an array with the number of players needed
     * and names for each player
     */
    void createPlayers() {
        System.out.print("How many players are you going to be? ");
        int numberOfPlayers = Scan.oneToFour();
        player = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player();
            System.out.print("\nWhat's the name of player no. " + (i + 1) + ": ");
            player[i].name = Scan.nextLine();
        }
    }
    
    /**
     * Method CreatePlayers to use in testing (Skips the name input)
     * 
     * @param numberOfPlayers 
     */
    void createPlayers(int numberOfPlayers) {
        player = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player();
        }
    }
    
    /**
     * Play method tells that the game is started and calls round()
     */
    void play() {
        System.out.println("Let the game begin!");
        round();
    }

    /**
     * Round method counts the number of rounds Displays the current round
     * number and calls turn() loops as long as no winner is found
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
     * Turn method keeps track of which player has turn if DEBUGMODE is true the
     * user will be asked to select a player
     */
    void turn() {

        while (!winnerFound) {
            for (int turn = 0; turn < Player.counter; turn++) {
                if (DEBUGMODE) {
                    System.out.print("Choose player: ");
                    turn = Scan.oneToFour() - 1;
                }
                if (player[turn].numberOfTokensInPlay() == 0) {
                    attempts = 3;
                } else {
                    attempts = 1;
                }

                System.out.println("\nPlayer no. " + (turn + 1) + " " + player[turn].name + " - " + " has turn");
                while (attempts > 0) {

                    dice = Dice.roll(DEBUGMODE);
                    Scan.nextLine();
                    System.out.println("You rolled " + dice);

                    if (dice == 6) {
                        attempts = 0;
                    }

                    if (hasOptions(turn)) {
                        int chosenToken = chooseToken(turn);
                        player[turn].token[chosenToken].move(turn, dice, board);
                        capture(turn, chosenToken);
                        board.printBoard(player);
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

    /**
     * Method Has Options Checks if the user can move a token. Is false when no
     * tokens are in play and the dice is not 6.
     *
     * @param turn
     * @return
     */
    boolean hasOptions(int turn) {
        return player[turn].numberOfTokensInPlay() != 0 || dice == 6;
    }

    /**
     * Method Choose Token lets the user pick a specific token if multiple
     * tokens are available
     *
     * @param turn
     * @return
     */
    int chooseToken(int turn) {
        int chosenToken = 4;
        if (player[turn].numberOfTokensInPlay() == 1 && dice != 6) {
            for (int i = 0; i < 4; i++) {
                if (player[turn].token[i].inPlay) {
                    chosenToken = i;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (player[turn].token[i].inPlay) {
                    System.out.println("\tMove token no. " + (i + 1));
                }
            }
            for (int i = 0; i < 4; i++) {
                if (dice == 6) {

                    if (player[turn].token[i].start) {
                        System.out.println("\tGet token no. " + (i + 1) + " into play");
                    }
                }
            }

            chosenToken = Scan.oneToFour() - 1;

            if (!player[turn].token[chosenToken].inPlay && !(player[turn].token[chosenToken].start && dice == 6)) {
                System.out.print("You can't move that token! Try again - ");
                chosenToken = chooseToken(turn);
            }
        }
        return chosenToken;
    }

    /**
     * Checks if there already is a token on the new field when a token is moved
     * - if that is the case the token standing on the field will be moved back
     * to 0 - in the case where two tokens is already on the field the token
     * moving will be moved back to 0 - in both cases the field will become a
     * grave (marked by an X)
     * 
     * @param turn
     * @param chosenToken 
     */    
    void capture(int turn, int chosenToken) {

        int tokensOnField = 0;
        int standingPlayer = 4;
        int standingToken = 4;

        if (player[turn].token[chosenToken].inPlay && player[turn].token[chosenToken].field < (board.getNumberOfFields() - 6)) {
            for (int i = 0; i < player.length; i++) {
                if (i != turn) {
                    for (int k = 0; k < 4; k++) {
                        if (player[i].token[k].inPlay && player[i].token[k].field < (board.getNumberOfFields() - 6)) {
                            if ((player[i].token[k].field + ((i + 1) * 14) - 14) % (board.getNumberOfFields() - 6) == (player[turn].token[chosenToken].field + ((turn + 1) * 14) - 14) % (board.getNumberOfFields() - 6)) {
                                tokensOnField++;
                                standingPlayer = i;
                                standingToken = k;

                                board.setGrave((player[i].token[k].field + ((i + 1) * 14) - 14) % (board.getNumberOfFields() - 1));
                            }
                        }
                    }
                }
            }
        }

        if (tokensOnField == 1) {
            player[standingPlayer].token[standingToken].capture();
            System.out.println("Player " + (standingPlayer + 1) + "'s token no. " + (standingToken + 1) + " has been captured");
            player[turn].quote();
        } else if (tokensOnField > 1) {
            player[turn].token[chosenToken].capture();
            System.out.println("Player " + (turn + 1) + "s token no. " + (chosenToken + 1) + " has been captured");
            player[standingPlayer].quote();
        }
    }
}
