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
            Game game = new Game();
            game.play();

            System.out.print("\nGAME OVER \nDo you want to play another game?");
            play = Scan.yesOrNo();
        }
        System.out.println("Bye!");
    }
}