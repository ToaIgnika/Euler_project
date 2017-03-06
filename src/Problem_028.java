/**
 * Problem_028.
 * 
 * Program finds the sum of the numbers on the diagonals 
 * in a 1001 by 1001 spiral formed in the same way.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version
 *
 */
public class Problem_028 {
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // variable declaration
        double sum = 1;
        double tempI = 0;
        int tempN = 0;
        
        // algorithm to calculate all diagonal sum.
        for (int i = 3; i <= 1001; i+=2) {
            tempI = Math.pow(i,2);
            tempN = i-1;
            sum += tempI*4 - tempN*6;
        }
        System.out.println((int)sum);
    }
}
