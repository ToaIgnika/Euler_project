/**
 * Problem_037.
 * 
 * Program finds the sum of all left-right truncable primes.
 * 
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 8, 2017
 *
 */
public class Problem_037 {

    /**
     * Method checks if the input is a prime number.
     * @param victim of type double.
     * @return true if the number is prime; else return false.
     */
    private static boolean isPrime(double victim) {
        if (victim == 1)
            return false;
        if (victim == 2)
            return true;
        for (int divider = 2; divider <= Math.sqrt(victim); divider++) {
            if (victim % divider == 0)
                return false;
        }
        return true;
    }
    
    /**
     * method to check the right truncable primes
     * @param num of type integer.
     * @return true if truncable; else return false.
     */
    private static boolean isInterestingRight(int num) {
        String numS = "" + num;
        for (int index = numS.length(); index > 0; index--) {
            if (!isPrime(Integer.valueOf(numS.substring(0, index)))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * method to check the left truncable primes
     * @param num of type integer.
     * @return true if truncable; else return false.
     */
    private static boolean isInterestingLeft(int num) {
        String numS = "" + num;
        for (int index = 0; index < numS.length(); index++) {
            if (!isPrime(Integer.valueOf(numS.substring(index)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // declare sum variable.
        int sum = 0;
        
        // main loop to go through the integer list
        for (int num = 10; num < 1000000; num++) {
            if (isPrime(num) && isInterestingRight(num) && isInterestingLeft(num)) {
                sum += num;
            }
        }
        
        // print the answer
        System.out.println(sum);
    }
}
