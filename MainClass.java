package csci1010.assign5;
/**
 * Instantiates the TennisMatch class. User
 * is able to input sets and player's strength
 * to see how many matches are needed and what
 * the results were.
 * @author $Charles Owens
 */
import java.util.Scanner;
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Welcome to Charles Owens' tennis match simulator!");
        String answer = "Y";
        
        while(answer.equals("Y"))
        {
            System.out.println("\nPlease enter the number of sets needed to win a match: ");
            Scanner keyboard = new Scanner(System.in);
            int sets = keyboard.nextInt();

            System.out.println("Please enter the probability of player 1 winning: ");
            double player1 = keyboard.nextDouble();

            System.out.println("Please enter the probability of player 2 winning: ");
            double player2 = keyboard.nextDouble();

            TennisMatch tennisMatch = new TennisMatch(sets, player1, player2);
            tennisMatch.playMatch();
            answer = "";
            System.out.println("Would you like to run another simulation? (Y/N): ");
            answer = keyboard.next();
        }
        System.out.println("\nThank you for using the tennis match simulator!");
    }

}
