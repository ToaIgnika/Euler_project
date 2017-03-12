
import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem_049.
 * 
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
 * increases by 3330, is unusual in two ways: (i) each of the three terms are
 * prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this
 * sequence?
 * 
 *
 * "I made this code longer than usual because I lack time to make it short"
 * 
 * @author Yevhen
 * @version Mar 12, 2017
 *
 */
public class Problem_049 {

    /**
     * Method to check if the number is prime.
     * @param victim of type double.
     * @return true if prime; else return false.
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
     * Method to check if the inputs are digit permutations of each other.
     * @param x as int.
     * @param y as int.
     * @param z as int.
     * @return true if they are digit permutations of each other.
     */
    private static boolean isPerm(int x, int y, int z) {
        // declare variables
        ArrayList<String> valsX = new ArrayList<String>();
        ArrayList<String> valsY = new ArrayList<String>();
        ArrayList<String> valsZ = new ArrayList<String>();
        String xStr = "" + x;
        String yStr = "" + y;
        String zStr = "" + z;
        
        // fill each list with digits
        for (int ind = 0; ind < xStr.length(); ind++) {
            valsX.add(xStr.substring(ind, ind + 1));
        }
        for (int ind = 0; ind < yStr.length(); ind++) {
            valsY.add(yStr.substring(ind, ind + 1));
        }
        for (int ind = 0; ind < yStr.length(); ind++) {
            valsZ.add(zStr.substring(ind, ind + 1));
        }
        
        // sort the list using collections
        Collections.sort(valsX);
        Collections.sort(valsY);
        Collections.sort(valsZ);
        
        // compare the lists
        for (int ind = 0; ind < 4; ind++) {
            if (!valsX.get(ind).equals(valsY.get(ind)) || !valsY.get(ind).equals(valsZ.get(ind)))
                return false;
        }
        return true;
    }

    private static ArrayList<Integer> primeList = new ArrayList<Integer>();

    public static void main(String[] args) {
        // create a list of prime numbers
        for (int i = 1001; i < 10000; i += 2) {
            if (isPrime(i))
                primeList.add(i);
        }

        // loop through each prime number
        for (int z = 0; z < primeList.size(); z++) {

            // for each prime, check all possible adders
            for (int adder = 1; primeList.get(z) + adder * 2 < 10000; adder++) {
                int temp = primeList.get(z) + adder;

                // when all three numbers are primes, check if they are
                // permutations of each other
                if (isPrime(temp) && isPrime(temp + adder)) {
                    if (isPerm(temp - adder, temp, temp + adder))
                        // print the result
                        System.out.println(temp - adder + "|" + temp + "|" + (temp + adder) + " |" + adder);
                }
            }
        }
    }
}
