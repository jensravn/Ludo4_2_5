package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Player {
    
    String name;
    Token[] token = new Token[4];
    static int counter;
    
    /** Player Constructor */
    Player () {
        
        counter++;
        
        for (int i = 0; i < 4; i++) {
            token[i] = new Token();
        }
    }
    
    /** Checks if player won - all tokens are at the end field*/
    boolean won () {
        for (int i = 0; i < 4; i++) {
            if (token[i].finish == false) {
                return false;
            } 
        }
        return true;
    }
    
    int numberOfTokensInPlay() {
        int numberOfTokensOut = 0;
        for (int i = 0; i < 4; i++) {
            if (token[i].inPlay) {
                numberOfTokensOut++;
            }
        }
        return numberOfTokensOut;
    }
}