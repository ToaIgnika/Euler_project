import java.math.BigInteger;

/**
 * Problem_025.
 *
 * Program finds the digit length of the 1000th fibonacci number.
 * @author Eugene.
 * @version 2.0.
 */
public class Problem_025 {
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // create BigInteger numbers to store fib values.
        BigInteger fibbonaciPrev = BigInteger.valueOf(1);
        BigInteger fibbonaciThis = BigInteger.valueOf(1);
        BigInteger fibbonaciNext = BigInteger.valueOf(1);
        // create string to simplify the digit count.
        String sizeCheck = "";
        int id = 2;
        // main program loop.
        while (sizeCheck.length() < 1000) {
            fibbonaciNext = fibbonaciPrev.add(fibbonaciThis);
            sizeCheck = "" + fibbonaciNext;
            fibbonaciPrev = fibbonaciThis;
            fibbonaciThis = fibbonaciNext;
            id++;
            //System.out.println(id + " " + fibbonaciNext + " " + sizeCheck.length());
        }
        // print the solution.
        System.out.println(id);
    }
}
