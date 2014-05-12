package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Player {

    String name;
    Token[] token = new Token[4];
    static int counter;

    /**
     * Player Constructor
     */
    Player() {

        counter++;

        for (int i = 0; i < 4; i++) {
            token[i] = new Token();
        }
    }

    /**
     * Checks if player won - all tokens are at the end field
     */
    boolean won() {
        for (int i = 0; i < 4; i++) {
            if (token[i].finish == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks how many tokens the player currently has in play
     */
    int numberOfTokensInPlay() {
        int numberOfTokensOut = 0;
        for (int i = 0; i < 4; i++) {
            if (token[i].inPlay) {
                numberOfTokensOut++;
            }
        }
        return numberOfTokensOut;
    }
    
    void quote() {
        System.out.print("\n" + name + " says \"");
        
        switch ((int)(Math.random()*6)) {
            case 0:
                System.out.print("You don't even deserve to be in this game buddy!");break;
            case 1:
                System.out.print("And you call yourself a ludo player..?");break;
            case 2:
                System.out.print("So we meet again!");break;
            case 3:
                System.out.print("Let the battle begin!");break;
            case 4:
                System.out.print("Let the gods have mercy on your soul!");break;
            case 5:
                System.out.print("Thunder and lightning baby!");break;
            default:
                System.out.print("Obey me!");break;
        }
        System.out.print("\"\n");
    }
}