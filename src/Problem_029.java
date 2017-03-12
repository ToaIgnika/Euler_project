
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Problem_029.
 *
 * Program finds the number of unique a^b such that 
 * 2<a<100, 2<b<100
 * 
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version
 *
 */
public class Problem_029 {

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<BigInteger> powers = new ArrayList<BigInteger>();
        BigInteger num = BigInteger.valueOf(0);
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                num = BigInteger.valueOf(a);
                num = num.pow(b);
                if (!powers.contains(num))
                    powers.add(num);
            }
        }
        System.out.println(powers);
        System.out.println(powers.size());
    }
}
