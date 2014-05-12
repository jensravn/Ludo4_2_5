package ludo4_2_5;

/**
 *
 * @author jensravn
 */
import java.util.Scanner;

public class Scan {

    /**
     * Input from user - any string
     */
    static String string() {

        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    /**
     * Input from user - between 1 and 4
     */
    static int oneToFour() {

        String regex = "[1-4]";
        String input = "F";

        while (!input.matches(regex)) {
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Invalid input. Choose a number from 1 to 4");
            }
        }
        return Integer.parseInt(input);
    }
    
    /**
     * Input from user - number
     */
    static int integer() {

        String regex = "[0-9]+";
        String input = "F";

        while (!input.matches(regex)) {
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Invalid input. Choose a whole number");
            }
        }
        return Integer.parseInt(input);
    }
    
    /** Input from user - Yes or No */
    static boolean yesOrNo() {

        String input = "F";
                
        while (!input.equals("Y") || !input.equals("N")) {
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine().toUpperCase();
            if(input.equals("Y")){
                return true;
            } else if (input.equals("N")) {
                return false;
            }
            else {
                System.out.println("Invalid input. Choose (Y)es or (N)o");
            }
        }
        return false;
    }
}
