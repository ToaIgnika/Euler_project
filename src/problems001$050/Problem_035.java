package problems001$050;

/**
 * Problem_035.
 * 
 * Find the number of all circular primes from 1 to 1m.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 8, 2017
 *
 */
public class Problem_035 {

    /**
     * Mathod to check if the number is Prime.
     * @param victim of type double.
     * @return false if the number is not prime; else return true.
     */
    private static boolean isPrime(double victim) {
        if (victim == 1 || victim == 2)
            return true;

        for (int i = 2; i <= Math.sqrt(victim); i++) {
            if (victim % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Method to check if the number is circular prime.
     * @param number of type integer.
     * @return true if the number is Circular prime; else return false.
     */
    private static boolean isCircular(int number) {
        String circleNum = "" + number;
        int lastDigit = circleNum.length();
        for (int rotater = 0; rotater < lastDigit; rotater++) {
            circleNum = circleNum.substring(lastDigit - 1) + circleNum.substring(0, lastDigit - 1);
            if (!isPrime(Integer.valueOf(circleNum))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Drives the progam.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // initialize the counter
        int circularPrimeCount = 0;

        // count all circular prime numbers.
        for (int num = 2; num <= 1000000; num++) {
            if (isPrime(num) && isCircular(num)) {
                circularPrimeCount++;
            }
        }
        
        // print the result
        System.out.println(circularPrimeCount);
    }
}
