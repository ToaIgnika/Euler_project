import java.util.Scanner;

/**
 * Finds number of roots for SQUARED path grid 
 * of size (user input)
 * @author Yevhen
 * @version 2.0
 */
public class Problem_015 {
    
    /**
     * Drives the program.
     * @param args command line arguments
     * 
     */
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int userInput = scan.nextInt();
        //int userY = scan.nextInt(); // for any grid size modification
        double result = 1;
        double upNum = userInput + userInput; // (a+b)!
        for (double i = 1; i <= userInput; i ++)
        {
            result = result * (i + userInput) / i; 
        }
        System.out.println((long) result);
        
    }
}
