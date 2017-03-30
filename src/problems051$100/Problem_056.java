package problems051$100;
import java.math.BigInteger;

/**
 * Problem_056.
 * 
 * Find the largest sum of digits for natural numbers
 * a^b, a < 100 and b < 100.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 16, 2017
 *
 */
public class Problem_056 {

    /**
     * Count sum of digits of the victim String.
     * 
     * @param victim string of integers.
     * @return sum of digits.
     */
    private static int sumOfDigit(String victim) {
        int sum = 0;
        for (int i = 0; i < victim.length(); i++) {
            sum += Integer.valueOf(victim.substring(i, i + 1));
        }
        return sum;
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        BigInteger num = new BigInteger("0");
        int maxSum = 0;
        for (int a = 0; a < 100; a++) {
            for (int b = 0; b < 100; b++) {
                num = new BigInteger("" + a);

                num = num.pow(b);
                if (sumOfDigit(num.toString()) > maxSum)
                    maxSum = sumOfDigit(num.toString());
            }
        }
        System.out.println(maxSum);

    }
}
