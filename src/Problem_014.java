
import java.util.Scanner;

/**
 * Find the longest chain of Collatz Problem
 * for an integer below (user input) number
 * @author Yevhen
 * @version 1.0
 */

public class Problem_014 {

    /**
     * Collatz Algorithm
     * @param x
     * @return a chain of input, x
     */
    private static int Collatz(int x)
    {
        long tempX = x;
        int counter = 0;
        
        while (tempX != 1)
        {
            if (tempX % 2 == 0)
                tempX = tempX/2;
            else 
                tempX = (tempX * 3) + 1;
            counter ++;
        }
        return counter;
    }
    
    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String args[])
    {
        // variable declaration and users input
        scan = new Scanner(System.in);
        int userInt = scan.nextInt();
        int biggestChain = 0;
        int biggestNum = 0;
        int collInt = 0;
        
        // loop for searching the answer
        for (int i = 1; i < userInt; i++)
        {
            collInt = Collatz(i);
            if (collInt > biggestChain)
            {
                biggestChain = Collatz(i);
                biggestNum = i;
            }
        }
        
        // print the answer: longest chain and correlated number
        System.out.println(biggestChain + " " + biggestNum);
    }
}
