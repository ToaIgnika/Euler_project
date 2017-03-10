import java.util.ArrayList;

/**
 * Problem_041.
 * 
 * Program finds the largest pandigital prime.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 9, 2017
 *
 */
public class Problem_041 {

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

    
    private static boolean isPrime(long victim) {
        if (victim == 1)
            return false;
        for (long div = 2; div <= Math.sqrt((float) victim); div++) {
            if (victim % div == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        int n = 7;
        String alphabet = "1234567";
        String elements = alphabet.substring(0, n);
        perm1(elements);     
        for (int tryThis = 0; tryThis < holder.size(); tryThis++) {
            if (isPrime(Long.valueOf(holder.get(tryThis)))){
                System.out.println(tryThis + " " + holder.get(tryThis));
            }
        }
    }
}
