
import java.util.ArrayList;

/**
 * Problem_047.
 * 
 * Problem finds the first four consecutive integers 
 * to have four distinct prime factors each.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 12, 2017
 *
 */
public class Problem_047 {

    /**
     * Method to check if the number is prime.
     * @param victim of type double.
     * @return true if prime; else return false.
     */
    private static boolean isPrime (double victim) {
        if (victim == 1) 
            return false;
        for (int div = 2; div <= Math.sqrt(victim); div++) {
            if (victim % div == 0)
                return false;
        }        
        return true;
    }
    
    /**
     * Method finds the number of prime divisors of a num.
     * @param victim of type int.
     * @return number of prime divisors as int.
     */
    private static int primeDivs(int victim) {
        //int primeCount = 0;
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        for (int div = 2; div <= victim; div++) {
            if (victim % div == 0 && isPrime(div) && !primeList.contains(div)){
                primeList.add(div);
                victim /= div;
            }
            if (victim % div == 0 && !isPrime(div)){
                return -1;
            }
        }
        return primeList.size();
    }
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // declare variables
        boolean check = true;
        int f1,f2,f3,f4;
        
        // main loop to find the solution
        for (int i = 10; check; i++) {
            f1 = primeDivs(i);
            f2 = primeDivs(i+1);
            f3 = primeDivs(i+2);
            f4 = primeDivs(i+3);
            if (f1 == 4 && f1 == f2 && f2 == f3 && f3 == f4){
                check = false;
                // print the solution
                System.out.println(i + " " + (i+1) + " " + (i+2));
            }
        }
    }
}
