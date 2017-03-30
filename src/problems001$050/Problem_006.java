package problems001$050;

import java.util.Scanner;

/**
 * Problem_006.
 * Find the difference between sum of the squares and square of the sum
 * from 1 to (user input)
 * @author Yevhen
 *
 */
public class Problem_006 {
    
    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param arg command line arguments.
     */
    public static void main(String arg[])
    {
        //declare variables
        long sumOfSquares = 0;
        long squareOfSum = 0;
        long finalDiff;
        scan = new Scanner(System.in);
        int userInt = scan.nextInt();
        
        // calculate the sum of squares
        for (int i = 1; i <= userInt; i++)
        {
            sumOfSquares = sumOfSquares + i * i;
        }
        
        // a*(a+1)/2 
        squareOfSum = userInt * (userInt + 1) * userInt * (userInt + 1) / 4;
        
        finalDiff = squareOfSum - sumOfSquares;
        System.out.println(finalDiff);
    }
}
