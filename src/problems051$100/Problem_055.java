package problems051$100;
import java.math.BigInteger;

/**
 * Problem_055.
 * 
 * Find out how many Lychrel numbers below 10000.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 16, 2017
 *
 */
public class Problem_055 {

    /**
     * Checks if the string is palidromic
     * @param victim test number.
     * @return true if palidromic; else return false.
     */
    private static boolean isPal(String victim) {
        String temp = reverse(victim);
        if (victim.equals(temp))
            return true;
        return false;
    }
    
    /**
     * Reverse the string.
     * @param victim string to reverse.
     * @return reversed string.
     */
    private static String reverse(String victim) {
        String victimR = "";
        for (int i = victim.length()-1; i >= 0; i--) {
            victimR = victimR + victim.substring(i, i+1);
        }
        return victimR;
    }
    
    /**
     * Check if the number is a Lychrel number.
     * @param victim biginteger number.
     * @return true if the number is a Lychrel number; else return false.
     */
    private static boolean isLychrel (BigInteger victim) {
        BigInteger victimR = new BigInteger("0");
        for (int i = 0; i < 50; i++) {
            victimR = new BigInteger(reverse(victim.toString()));
            victim = victim.add(victimR);
            if (isPal(victim.toString())){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int count = 0;
        BigInteger val = new BigInteger("0");
        for (int i = 10; i < 10000; i++) {
            val = new BigInteger("" + i);
            if (isLychrel(val)) {
                count++;
            }
        }
        System.out.println("There are: " + count + " Lychrel numbers below 10000.");
    }
}
