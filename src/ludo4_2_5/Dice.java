package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Dice {

    /**
     * Method Roll Creates a random number between 1 and 6.
     * if DEBUGMODE is true the user will be asked to set the value.
     * 
     * @param DEBUGMODE
     * @return 
     */
    static int roll(boolean DEBUGMODE) {
        if (DEBUGMODE) {
            System.out.print("Choose dice: ");
            return Scan.integer();
        } else {
            return (int) (Math.random() * 6 + 1);
        }
    }
}
