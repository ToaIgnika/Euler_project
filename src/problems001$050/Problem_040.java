package problems001$050;

/**
 * Problem_040.
 * 
 * Please see Euler for problem description.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 9, 2017
 *
 */

public class Problem_040 {
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // variable declaration
        int product = 1;
        String fraction = "";
        int i = 1;
        
        // create a decimal String
        while (fraction.length() < 1000000){
            fraction += i;
            i++;
        }
        
        // find the solution.
        for (int index = 1; index <= 1000000; index *= 10){
            product *= Integer.valueOf(fraction.substring(index-1, index));
        }
        
        // print the solution
        System.out.println(product);
    }
}
