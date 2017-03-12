
import java.util.ArrayList;

/**
 * Problem_050.
 * 
 * Program finds which prime, below one-million, 
 * can be written as the sum of the most consecutive primes.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 12, 2017
 *
 */
public class Problem_050 {

    /**
     * Method to check if the input is prime.
     * @param victim as double.
     * @return true if number is prime; else return false.
     */
    private static boolean isPrime(double victim) {
        if (victim <= 1)
            return false;
        for (int div = 2; div <= Math.sqrt(victim); div++) {
            if (victim % div == 0)
                return false;
        }
        return true;
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int sum = 0;
        int maxSum = 0;
        int thisLength = 0;
        int maxLength = 0;
        int primeStart = 0;
        int range = 1000000;
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        for (int i = 1; i < range * 2; i++) {
            if (isPrime(i))
                primeList.add(i);
        }
        for (int index = 0; primeList.get(index) < range; index++) {
            sum = primeList.get(index);
            thisLength = 1;
            for (int index2 = index + 1; sum < range; index2++) {
                sum += primeList.get(index2);
                thisLength++;
                if (thisLength > maxLength && isPrime(sum) && sum < range) {
                    maxLength = thisLength;
                    maxSum = sum;
                    primeStart = primeList.get(index);
                }
            }
        }
        System.out.println(maxLength + " " + maxSum + " " + primeStart);

    }
}
