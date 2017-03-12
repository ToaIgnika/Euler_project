
import java.math.BigInteger;

/**
 * Problem_048.
 * 
 * Program finds the last ten digits of the series, 
 * 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 12, 2017
 *
 */
public class Problem_048 {
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // declare variables 
        BigInteger sum = new BigInteger("0");
        String base = "";
        
        // loop to create the number
        for (int i = 1; i <= 1000; i++) {
            base = "" + i;
            sum = sum.add(new BigInteger(base).pow(i));
        }
        
        // print the result
        base = sum.toString();
        System.out.println(base.substring(base.length()-10));
    }
}
