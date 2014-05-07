package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Die {

    /**
     * Method Roll Creates a random number between 1 and 6
     */
    static int roll() {
        return (int) (Math.random() * 6 + 1);
    }

}
