package problems051$100;
import java.math.BigInteger;
/**
 * Problem_057.
 * 
 * sqrt(2) can be uniquely expanded in form of: 
 * 1+1/2
 * 1+1/(2+1/2)
 * 1+1/2(2+1/2(2+1/2))
 *
 * For all irratations below 1000, find how many times
 * numerator has more digits than denumerator.
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 17, 2017
 *
 */
public class Problem_057 {
    
    /**
     * Method to generate n-th iteration. 
     * @param times number of iteration.
     * @return numerator and denumerator as BigInteger[].
     */
    private static BigInteger[] iter(long times) {
        BigInteger numerator = new BigInteger("1");
        BigInteger denumerator = new BigInteger("2");
        
        BigInteger temp = new BigInteger("0");
        for (long i = 0; i < times-1; i++) {
            numerator = numerator.add(denumerator.multiply(new BigInteger("2")));
            temp = denumerator;
            denumerator = numerator;
            numerator = temp;
        }
        numerator = numerator.add(denumerator);
        BigInteger[] frac = {numerator, denumerator};
        return frac;
    }
    
    /**
     * Drives the program.    
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        BigInteger[] num;
        int count = 0;
        for (long i = 1; i <= 1000; i++) {
            num = iter(i);
            if(num[0].toString().length() > num[1].toString().length())
                count++;
        }
        System.out.println(count);
    }
}
