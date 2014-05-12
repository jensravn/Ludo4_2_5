 package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Board {

    private int[] field;
    private int[] p = field;
    private boolean[] grave;

    /**
     * Board Constructor Creates the fields and sets by default all of them to 0
     */
    Board() {
        p = new int[62];
        
        for (int i = 0; i < 62; i++) {
            p[i] = 0;
        }
        
        grave = new boolean[p.length];
    }

    /**
     * method to get the number of fields
     */
    int getNumberOfFields() {
        return p.length;
    }

    /**
     * method to show where players currently are on the board
     */
    void setField(int turn, int oldField, int newField) {
        oldField += ((turn+1) * 14)-14 % (p.length-1);
        this.p[oldField] = 0;
        newField += ((turn+1) * 14)-14 % (p.length-1);
        if (newField > p.length-1) {
            newField = p.length-1;
        }
        this.p[newField] = turn + 1;
    }

    /** Check if the field in the array of grave is true */
    boolean isGrave(int field) {
        return grave[field];
    }
    
    /** Sets the field in the array of grave to true */
    void setGrave(int field) {
        grave[field] = true;
    }
    
    /** Show if token is at its home field */
    String pH(Player player[], int playerNumber, int tokenNumber) {
        if (player.length <= playerNumber) {
            return " ";
        } else if (player[playerNumber].token[tokenNumber].start) {
            return (playerNumber+1)+"";
        } else {
            return "0";
        }
    }
    
    /** Show if token is at its end fields */
    String pF(Player player[], int playerNumber, int field) {
        if (player.length <= playerNumber) {
            return " ";
        } else if (player[playerNumber].token[0].field == field) {
            return (playerNumber+1)+"";
        } else {
            return "O";
        }
    }
    
    /** Shows the number of tokens finished for each player */
    String f(Player player[], int playerNumber) {
        String score = "";
        if (player.length > playerNumber) {
            
            for (int i = 0; i < 4; i++) {
                if(player[playerNumber].token[i].finish){
                    score += "*";
                }
            }
            for (int i = 0; i < 4; i++) {
                if(!player[playerNumber].token[i].finish){
                    score += " ";
                }
            }
        } else {
            score = "    ";
        }
        if (playerNumber == 1 || playerNumber == 2) {
            return new StringBuilder(score).reverse().toString();
        } else {
            return score;
        }
    }
    
    /**
     * Print the board to the console
     */
    void printBoard(Player pl[]) {
        System.out.println();
        System.out.println(f(pl, 0)+"        " + p[12] + " " + p[13] + " " + p[14] + "        "+f(pl, 1));
        System.out.println("  " + pH(pl,0,0) + "   " + pH(pl,0,1) + "     " + p[11] + " "+pF(pl,1,56)+" " + p[15] + "     " + pH(pl,1,0) + "   " + pH(pl,1,1) + "  ");
        System.out.println("            " + p[10] + " "+pF(pl,1,57)+" " + p[16] + "            ");
        System.out.println("  " + pH(pl,0,2) + "   " + pH(pl,0,3) + "     " + p[9] + " "+pF(pl,1,58)+" " + p[17] + "     " + pH(pl,1,2) + "   " + pH(pl,1,3) + "  ");
        System.out.println("            " + p[8] + " "+pF(pl,1,59)+" " + p[18] + "            ");
        System.out.println("            " + p[7] + " "+pF(pl,1,60)+" " + p[19] + "            ");
        System.out.println(p[56] + " " + p[1] + " " + p[2] + " " + p[3] + " " + p[4] + " " + p[5] + " " + p[6] + " "+pF(pl,1,61)+" " + p[20] + " " + p[21] + " " + p[22] + " " + p[23] + " " + p[24] + " " + p[25] + " " + p[26]);
        System.out.println(p[55] +" "+pF(pl,0,56)+" "+pF(pl,0,57)+" "+pF(pl,0,58)+" "+pF(pl,0,59)+" "+pF(pl,0,60)+" "+pF(pl,0,61)+"   "+pF(pl,2,61)+" "+pF(pl,2,60)+" "+pF(pl,2,59)+" "+pF(pl,2,58)+" "+pF(pl,2,57)+" "+pF(pl,2,56)+" "+ p[27]);
        System.out.println(p[54] + " " + p[53] + " " + p[52] + " " + p[51] + " " + p[50] + " " + p[49] + " " + p[48] + " "+pF(pl,3,61)+" " + p[34] + " " + p[33] + " " + p[32] + " " + p[31] + " " + p[30] + " " + p[29] + " " + p[28]);
        System.out.println("            " + p[47] + " "+pF(pl,3,60)+" " + p[35] + "            ");
        System.out.println("            " + p[46] + " "+pF(pl,3,59)+" " + p[36] + "            ");
        System.out.println("  " + pH(pl,3,0) + "   " + pH(pl,3,1) + "     " + p[45] + " "+pF(pl,3,58)+" " + p[37] + "     " + pH(pl,2,0) + "   " + pH(pl,2,1) + "  ");
        System.out.println("            " + p[44] + " "+pF(pl,3,57)+" " + p[38] + "            ");
        System.out.println("  " + pH(pl,3,2) + "   " + pH(pl,3,3) + "     " + p[43] + " " + pF(pl,3,56) + " " + p[39] + "     " + pH(pl,2,2) + "   " + pH(pl,2,3) + "  ");
        System.out.println(f(pl, 3)+"        " + p[42] + " " + p[41] + " " + p[40] + "        "+f(pl, 2));
        System.out.println();
    }
}