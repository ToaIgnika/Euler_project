
/**
 * Problem_045.
 * 
 * Program finds the second triangle number 
 * that is also pentagonal and hexagonal.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 12, 2017
 *
 */
public class Problem_045 {

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // declare variables 
        long triangle = 0;
        long pentagon = 0;
        long hexagon = 0;
        long pentID = 1;
        long hexID = 1;
        
        // loop for triangle nums
        for (long tri = 1; tri < 1000000000; tri+=1) {
            triangle = tri * (tri + 1) / 2;
            // loop for pentagon
            while (pentagon < triangle) {
                pentagon = pentID*(3*pentID-1)/2;
                pentID++;
            }
            // loop for hexagon
            while (hexagon < triangle) {
                hexagon = hexID*(2*hexID-1);
                hexID++;
            }
            // print the correct results
            if (hexagon == triangle && hexagon == pentagon)
                System.out.println(hexagon);
        }
    }
}
