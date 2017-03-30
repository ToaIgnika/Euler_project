package problems051$100;
import java.util.ArrayList;

/**
 * Problem_058.
 * 
 * Starting with 1 and spiralling anticlockwise in the following way, a square
 * spiral with side length 7 is formed. If one complete new layer is wrapped
 * around the spiral above, a square spiral with side length 9 will be formed.
 * If this process is continued, what is the side length of the square spiral
 * for which the ratio of primes along both diagonals first falls below 10%?
 * 
 *
 * "I made this code longer than usual because I lack time to make it short"
 * 
 * @author Yevhen
 * @version Mar 17, 2017
 *
 */
public class Problem_058 {

    /**
     * Method to check if the number is prime.
     * 
     * @param victim
     *            number to check.
     * @return true if the number is prime; esle return false.
     */
    private static boolean isPrime(int victim) {
        if (victim <= 1) {
            return false;
        }
        for (int div = 2; div <= Math.sqrt((double) victim); div++) {
            if (victim % div == 0) {
                return false;
            }
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
        ArrayList<Integer> listD = new ArrayList<Integer>();
        ArrayList<Integer> listP = new ArrayList<Integer>();
        int num = 0;
        int temp = 0;
        double frac = 0.50;
        for (int i = 3; frac > 0.1; i += 2) {
            num = (int) Math.pow(i, 2);
            for (int z = 0; z <= 3; z++) {
                temp = num - (i - 1) * z;
                listD.add(temp);
                if (isPrime(temp))
                    listP.add(temp);
            }
            frac = (double) listP.size() / (double) listD.size();
            System.out.println(frac + ": " + i);
        }

    }
}
