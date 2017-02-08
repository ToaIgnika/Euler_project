import java.util.Scanner;

/**
 * Problem_001.
 * Program finds sum of all the natural 
 * multiples of 3 or 5 below users input.
 * @author Eugene
 * version 2.0
 */
public class Problem_001 {
    
    /**
     * constant divider 3
     */
    public static final int THREE = 3;
    
    /**
     * constant divider 5
     */
    public static final int FIVE = 5;
    
    /**
     * Drives program.
     * 
     * @param arg command line arguments.
     */
    public static void main(String arg[]) {
        // declare variables and user input
        Scanner scan = new Scanner(System.in);
        final int max_multiply = scan.nextInt();
        int sum = 0;
        int tempInt = 0;
        
        // checks every number from 1 to x and adds to sum 
        while (tempInt < max_multiply)
        {
            if ((tempInt % THREE) == 0)
            {
                sum = sum + tempInt;
                tempInt++;
            }
            else if ((tempInt % FIVE) == 0)
            {
                sum = sum + tempInt;
                tempInt++;
            }
            else 
                tempInt++;
        }
        System.out.println(sum);
    }
}
