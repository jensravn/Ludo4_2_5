package ludo4_2_5;

/**
 *
 * @author jensravn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean play = true;

        while (play) {
            Game game = new Game(); // When testing use 4 as parameter
            
//            Test test = new Test();
//            test.test(game);

            game.play();

            System.out.print("\nGAME OVER \nDo you want to play another game?");
            play = Scan.yesOrNo();
        }
        System.out.println("Bye!");
    }
}
