package problems001$050;

/**
 * Problem_036.
 * 
 * Program finds the sum of all numbers that are palindromic
 * in both base 10 and base 2.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 8, 2017
 *
 */
public class Problem_036 {
    
    /**
     * Method checks if the string is palindromic.
     * @param victim as a String object.
     * @return true if the string is palindromic. else return false.
     */
    private static boolean isPalindromic(String victim) {
        String reversedVictim = "";
        for (int index = victim.length()-1; index >= 0 ; index--) {
            reversedVictim += victim.charAt(index);
        }
        if (victim.equals(reversedVictim)) {
            return true;
        }
        return false;
    }
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // initialize the counter.
        int counter = 0;
        
        // loop through the numbers
        for (int num = 0; num < 1000000; num++) {
            if (isPalindromic(""+num) && isPalindromic(Integer.toBinaryString(num))){
                counter+= num;
            }
        }
        
        // print the result.
        System.out.println(counter);
    }
}
