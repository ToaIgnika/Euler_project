
import java.util.Scanner;

/**9
 * Problem_007.
 * Find the user's input # prime number
 * @author Yevhen
 *
 */
public class Problem_007 {
    
    /**
     * Check if the input is prime
     * @param x
     * @return 1 = prime, 0 = not prime
     */
    public static int isPrime(long x)
    {
        long divider = 2;
        while (divider < x/2)
        {
            if (x % divider == 0)
                return 0;
            divider ++;
        }
        return 1;
    }

    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param arg command line arguments
     */
    public static void main(String arg[])
    {
        // variables and user input
        scan = new Scanner(System.in);
        System.out.println("Enter # (starting from 7): ");
        int primeId = scan.nextInt();
        int counter = 6;
        long victim = 13;
        while (counter < primeId)
        {
            victim ++;
            if (isPrime(victim) == 1)
                counter++;
            
        }
        System.out.println(victim);
    }

}
