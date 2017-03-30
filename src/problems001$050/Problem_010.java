package problems001$050;

import java.util.Scanner;

/**
 * Problem_010. Calculate the sum of primes from 2 to (user input)
 * This problem was hell.
 * @author Eugene
 * @version 2.0
 */
public class Problem_010 {
    
    /**
     * Method checks if the given number is
     * prime
     * @param x
     * @return 1 for true, 0 for false
     */
    public static double isPrime(double x) {
        double dividerBig = Math.sqrt(x);
        if (x == 2 || x == 3)
            return 1;
        long divider = 2;
        while (divider <= dividerBig) {
            if (x % divider == 0)
                return 0;
            divider++;
        }
        return 1;
    }
    
    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param arg command line arguments.
     */
    public static void main(String arg[]) {
        //declare variables
        long sum = 0;
        int incrementor = 1;
        scan = new Scanner(System.in);
        double userNum = scan.nextDouble();
        double worker = 2;
        while (worker < userNum) {
            if (worker == 9)
                incrementor = 2; // cheating part: no evens are prime
            if (isPrime(worker) == 1)
                    sum = sum + (int) worker;
            worker = worker + incrementor;
        }
        System.out.println(sum);
    }
}
