
/**
 * Problem_034.
 * 
 * Program finds all magic numbers, whos sum of factorials of
 * every digit equals to the number.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version
 *
 */

public class Problem_034 {
    
    /**
     * Method to calculate the factorial.
     * @param number of type int.
     * @return factorial of user input of type long.
     */
    private static long factorial (int number) {
        long numberFactorial = 1; 
        for (int mult = 1; mult <= number; mult++) {
            numberFactorial*= mult;
        }
        return numberFactorial;
    }
    
    /**
     * Method checks if the number is magic.
     * @param magicNum of type int.
     * @return true if number is magic; else, return false.
     */
    private static boolean isMagic (int magicNum) {
        long magic = 0;
        String magicS = "" + magicNum;
        for (int stringIndex = 0; stringIndex < magicS.length(); stringIndex++) {
            magic += factorial(Character.getNumericValue(magicS.charAt(stringIndex)));
        }
        if (magic == magicNum)
            return true;
        return false;
    }
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i < 1000000; i++) {
            if (isMagic(i)){
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
