package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Board {

    private int[] field;
    private int[] p = field;

    /**
     * Board Constructor Creates the fields and sets by default all of them to 0
     */
    Board() {
        p = new int[100];

        for (int i = 0; i < 100; i++) {
            p[i] = 0;
        }
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
        this.p[oldField] = 0;
        this.p[newField] = turn + 1;
    }

    /**
     * Print the board to the console
     */
    void printBoard() {
        System.out.println();
        System.out.println("            " + p[12] + " " + p[13] + " " + p[14] + "            ");
        System.out.println("  " + p[0] + "   " + p[0] + "     " + p[11] + " O " + p[15] + "     " + p[0] + "   " + p[0] + "  ");
        System.out.println("            " + p[10] + " O " + p[16] + "            ");
        System.out.println("  " + p[0] + "   " + p[0] + "     " + p[9] + " O " + p[17] + "     " + p[0] + "   " + p[0] + "  ");
        System.out.println("            " + p[8] + " O " + p[18] + "            ");
        System.out.println("            " + p[7] + " O " + p[19] + "            ");
        System.out.println(p[0] + " " + p[1] + " " + p[2] + " " + p[3] + " " + p[4] + " " + p[5] + " " + p[6] + " " + "O" + " " + p[20] + " " + p[21] + " " + p[22] + " " + p[23] + " " + p[24] + " " + p[25] + " " + p[26]);
        System.out.println(p[55] + " O O O O O O O O O O O O O " + p[27]);
        System.out.println(p[54] + " " + p[53] + " " + p[52] + " " + p[51] + " " + p[50] + " " + p[49] + " " + p[48] + " " + "O" + " " + p[34] + " " + p[33] + " " + p[32] + " " + p[31] + " " + p[30] + " " + p[29] + " " + p[28]);
        System.out.println("            " + p[47] + " O " + p[35] + "            ");
        System.out.println("            " + p[46] + " O " + p[36] + "            ");
        System.out.println("  " + p[0] + "   " + p[0] + "     " + p[45] + " O " + p[37] + "     " + p[0] + "   " + p[0] + "  ");
        System.out.println("            " + p[44] + " O " + p[38] + "            ");
        System.out.println("  " + p[0] + "   " + p[0] + "     " + p[43] + " O " + p[39] + "     " + p[0] + "   " + p[0] + "  ");
        System.out.println("            " + p[42] + " " + p[41] + " " + p[40] + "            ");
        System.out.println();
    }
}