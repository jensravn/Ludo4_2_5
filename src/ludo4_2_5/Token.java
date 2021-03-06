package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Token {

    int field;
    public boolean start = true;
    public boolean inPlay;
    boolean finish;
    int state;

    /**
     * Moves a token according to the value of the dice Unless token is at
     * start. Then it moves 1 field.
     *
     * @param turn
     * @param dice
     * @param board
     */
    void move(int turn, int dice, Board board) {

        System.out.print("The token is moved from field " + this.field);
        if (this.start) {
            board.setField(turn, this.field, this.field + 1);
            this.field += 1;
        } else {
            board.setField(turn, this.field, this.field + dice);
            if (this.field + dice >= board.getNumberOfFields()) {
                this.field = board.getNumberOfFields() - 1;
            } else {
                this.field += dice;
            }
        }
        System.out.print(" to " + this.field + "\n");

        if (this.field == 0) {
            this.setState(0);
        } else if (this.field >= board.getNumberOfFields() - 1) {
            this.setState(2);
            System.out.println("!!!!!! PLAYER " + (turn + 1) + " GOT A POINT !!!!!!");
        } else {
            this.setState(1);
        }
    }

    /**
     * Capture - sets the token back to start
     */
    void capture() {
        this.field = 0;
        setState(0);
    }

    /**
     * Return state of the token 0 = start 1 = inPlay 2 = finish
     *
     * @return
     */
    int getState() {
        return this.state;
    }

    /**
     * Set state of the token 0 = start 1 = inPlay 2 = finish
     *
     * @param state
     */
    void setState(int state) {
        this.state = state;

        switch (this.state) {
            case 0:
                this.start = true;
                this.inPlay = false;
                this.finish = false;
                break;
            case 1:
                this.start = false;
                this.inPlay = true;
                this.finish = false;
                break;
            case 2:
                this.start = false;
                this.inPlay = false;
                this.finish = true;
                break;
        }
    }
}
