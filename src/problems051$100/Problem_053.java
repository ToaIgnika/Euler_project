package problems051$100;
import java.math.BigInteger;

/**
 * Problem_053.
 * 
 * How many, not necessarily distinct, values of  
 * C(n,r), for 1 <= n <= 100, are greater than one-million?
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 14, 2017
 *
 */
public class Problem_053 {

    /**
     * Find factorial of BigInteger x.
     * @param x BigInteger x.
     * @return x! as BigInteger.
     */
    private static BigInteger fact(BigInteger x) {
        if (x == new BigInteger("0"))
            return new BigInteger("1");
        BigInteger ret = new BigInteger("1");
        for (int i = 1; i <= Integer.valueOf(x.toString()); i++) {
            ret = ret.multiply(new BigInteger(""+i));
        }
        return ret;
    }

    /**
     * Find C(n,r).
     * @param n number n.
     * @param r number r.
     * @return BigInteger C(n,r).
     */
    private static BigInteger nCombR(int n, int r) {
        BigInteger rBig = new BigInteger(""+r);
        BigInteger nBig = new BigInteger(""+n);
        BigInteger num = fact(nBig).divide((fact(rBig).multiply(fact(new BigInteger("" + (n - r))))));
        return num;
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        long count = 0;
        for (int n = 1; n < 101; n++) {
            for (int r = 1; r <= n; r++) {
                if (nCombR(n, r).toString().length() >= 7)
                    count ++;
            }
        }
        System.out.println(count);
    }

}
