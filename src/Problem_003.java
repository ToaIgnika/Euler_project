
import java.util.Scanner;

/**
 * Problem_003.
 * Find the largest prime factor of users input.
 * @author Yevhen
 *
 */
public class Problem_003 {
    
    private static Scanner scan;
    
    /**
     * function checks if the number is prime.
     * 1 = yes, 0 = no.
     * @param x
     * @return
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
    
    /**
     * Drives the program.
     * @param arg command line arguments.
     */
    public static void main(String arg[]){
        scan = new Scanner(System.in);
        final long userNum = scan.nextLong();
        long divLeft = 1;
        long divRight = userNum;
        long answer = 0;
        while (divLeft <= divRight/2)
        {
            if ((userNum % divLeft) == 0)
            {
                if (isPrime(divLeft) == 1)
                {
                    answer = divLeft;
                    System.out.println(answer);
                }
            }
            System.out.println(divLeft);
            divLeft++;
        }
        System.out.println(answer);
    }

}
