package ludo4_2_5;

/**
 *
 * @author jensravn
 */
import java.util.Scanner;

public class Scan {
    
    /** Input from user - any string */
    static String str() {
        
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    
    /** Input from user - between 1 and 4 */
    static int oneToFour() {
        
        String regex = "[1-4]";
        String input = "F";
        
        while (!input.matches(regex)){
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        if(!input.matches(regex)){
            System.out.println("Invalid input. Choose a number from 1 to 4");
        }
        }
        return Integer.parseInt(input);
    }
}