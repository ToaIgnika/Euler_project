
import java.util.ArrayList;

/**
 * Problem_046.
 * 
 * Program finds the smallest odd composite that cannot
 * be written as the sum of a prime and twice a square of n.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 12, 2017
 *
 */
public class Problem_046 {

    /**
     * Method to check if the number is prime.
     * @param victim of type double.
     * @return true if the number is prime; else return false;
     */
    private static boolean isPrime(double victim) {
        if (victim == 1)
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
        // create an array of prime integers
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        for (int primeI = 1; primeI < 10000; primeI += 2) {
            if (isPrime(primeI))
                primeList.add(primeI);
        }
 
        // main loop to find the solution
        int tempComp = 0;
        for (int compose = 1; compose < 10000; compose+=2) {
            if (!isPrime(compose)) {
                tempComp = 0;
                for (int listInd = 0; primeList.get(listInd) < compose && tempComp != compose; listInd++) {
                    tempComp = 0;
                    for (int powS = 1; tempComp < compose; powS++) {
                        tempComp = (int) (primeList.get(listInd) + 2 * Math.pow(powS, 2));                      
                    }
                }
            }
            if (tempComp != compose && !isPrime(compose))
                System.out.println(compose);
        }
    }
}
