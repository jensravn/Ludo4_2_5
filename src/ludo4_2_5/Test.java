package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Test {

    Game game;

    /**
     * test method calls all tests
     */
    void test(Game game) {
        this.game = game;
        
        testCapture();
        randomGameState();
        
    }

    /** set all tokens at different random positions */
    void randomGameState() {
        int[] arrayValue = new int[game.board.getNumberOfFields()];
        
        for(int i = 0; i < game.board.getNumberOfFields(); i++) {
            arrayValue[i] = i;
        }
        
        for(int i = 0; i < game.board.getNumberOfFields(); i++){
            int temp;
            int randomField = ((int)(Math.random()*(game.board.getNumberOfFields()-1)));
            temp = arrayValue[i];
            arrayValue[i] = arrayValue[randomField];
            arrayValue[randomField] = temp;
        }
        
        for(int k = 0; k < 4; k++){
            for (int m = 0; m < 4; m++){
                System.out.println((4*k)+m);
                game.player[k].token[m].move(k, 6, game.board);
                int field = arrayValue[(4*k)+m];
                
                game.player[k].token[m].move(k, field, game.board);
                game.board.printBoard(game.player);
            }
        }
    }

    /** Control that tokens will be captured */
    void testCapture() {
        game.player[1].token[1].move(1, 6, game.board);
        game.player[2].token[2].move(2, 6, game.board);
        
        int randomField = ((int)(Math.random()*(game.board.getNumberOfFields()-6)));
        if (randomField < 15) {
            randomField = 15;
        }
        game.player[1].token[1].move(1, randomField, game.board);
        game.board.printBoard(game.player);
        game.player[2].token[2].move(2, randomField-14, game.board);
              game.board.printBoard(game.player);  
        game.capture(1, 1);
    }
}