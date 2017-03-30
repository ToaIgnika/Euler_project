package problems001$050;

import java.util.ArrayList;

/**
 * Problem_027.
 * 
 * Program finds the product of the coefficients, a and b, for the quadratic
 * expression that produces the maximum number of primes for consecutive values
 * of n, starting with n=0.
 *
 * "I made this code longer than usual because I lack time to make it short"
 * 
 * @author Yevhen
 * @version
 *
 */
public class Problem_027 {

    /**
     * Method checks if the given number is prime.
     * 
     * @param i
     *            double.
     * @return true if prime; else, return false.
     */
    private static boolean isPrime(double i) {
        int div = 1;
        while (div <= Math.sqrt(i)) {
            if (i % div == 0 && div != 1)
                return false;
            div++;
        }
        return true;
    }

    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        // initialize variables
        int n, a, b, prime, streak, bigStreak, nMax;
        bigStreak = 0;
        a = 0;
        b = 0;
        nMax = 0;
        // create and fill an arraylist of prime numbers
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 1; i < 35000; i++) {
            if (isPrime(i))
                primes.add(i);
        }
        // nested loop to check all possible quadratic equations
        // and find the longest chain that satisfies the solution
        for (int aPlace = -999; aPlace < 1000; aPlace++) {
            for (int bPlace = -1000; bPlace <= 1000; bPlace++) {
                n = 0;
                streak = 0;
                prime = (int) Math.pow(n, 2) + n * aPlace + bPlace;
                while (primes.contains(prime)) {
                    n++;
                    streak++;
                    prime = (int) Math.pow(n, 2) + n * aPlace + bPlace;
                }
                if (streak > bigStreak) {
                    bigStreak = streak;
                    a = aPlace;
                    b = bPlace;
                    nMax = n;
                }
            }
        }
        // print the solution equation with the longest chain
        System.out.println("n^2 + " + a + "*n + " + b + " |n = " + nMax);

    }

}
