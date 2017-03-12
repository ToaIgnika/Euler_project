
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Find the sum of all special subpandigital 10-digit numbers.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 11, 2017
 *
 */
public class Problem_043 {

    static ArrayList<String> holder = new ArrayList<String>();
    public static void perm1(String s) {
        perm1("", s);
    }

    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            holder.add(prefix);
        } else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
        }
    }

    private static boolean pandigitTest(String victim) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17 };
        String subVictim = "";
        for (int index = 1; index < 8; index++) {
            subVictim = victim.substring(index, index + 3);
            if (Integer.valueOf(subVictim) % primes[index - 1] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // generate a list of all pandigital permutations
        int n = 10;
        BigInteger pandigitSum = new BigInteger("0");
        String alphabet = "0123456789";
        String elements = alphabet.substring(0, n);
        perm1(elements);
        
        // test each element at the list for uniqueness and add the unique ones
        for (int listIndex = 0; listIndex < holder.size(); listIndex++) {
            if (pandigitTest(holder.get(listIndex))){
                pandigitSum = pandigitSum.add(new BigInteger(holder.get(listIndex)));
            }
        }
        
        // print the result
       System.out.println(pandigitSum);
    }
}
