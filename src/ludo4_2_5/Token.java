package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Token {
    
    int field;
    boolean start;
    public boolean inPlay;
    boolean finish;
    
    void move (int dice) {
        System.out.print("The token is moved from field " + this.field);
        this.field += dice;
        System.out.print(" to " + this.field + "\n");
    }
    
}