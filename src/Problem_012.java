
import java.util.Scanner;

/**
 * Find first triangle number with over
 * (user input) divisors
 * @author Yevhen
 * @version 4.0
 */
public class Problem_012 {

    /**
     * calculates the number of divisors for input
     * @param x
     * @return
     */
    public static long divNumber(long x) {
        long divCounter = 0;
        long divOne = 1;
        long divTwo = 0;
        long checker = 0;
        while (checker == 0) {
            if (x % divOne == 0) 
            {
                if (divOne * divOne == x)
                {
                    return divCounter * 2 + 1;
                }
                divCounter++;
                if ((divOne == divTwo) || (x == 1))
                    checker = 1;
                divTwo = x / divOne;
            }
            divOne++;
        }

        //System.out.println("1");
        return ((divCounter - 1) * 2);
    }
    
    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param arg command line arguments.
     */
    public static void main(String arg[]) {
        
        // variables declaration and users input
        scan = new Scanner(System.in);
        long userInput = scan.nextLong();
        long answer = 0;
        double victimInt = 0;
        long countInt = 1;
        answer = 0;
        
        // loop for searching the answer
        while (answer < userInput)
        {
            victimInt = (countInt+1)*countInt/2;
            answer = divNumber((long) victimInt);
            countInt++;
        }
        
        System.out.println(victimInt);
    }
}
