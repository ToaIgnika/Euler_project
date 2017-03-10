/**
 * Problem_039.
 * 
 * Program finds the maximum number of solutions for right
 * angle triangle with integral sides with with perimeter <=1000.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 9, 2017
 *
 */
public class Problem_039 {
    
    /**
     * Checks if the triangle is right-angled.
     * @param a of type int.
     * @param b of type int.
     * @param c of type int.
     * @return true if right angle; else, return false;
     */
    private static boolean isTriangle(int a, int b, int c) {
        if (a + b < c || a + c < b || c + b < a || c < a || c < b)
            return false;
        return true;
    }
    
    /**
     * Counts the number of solutions for the given perimeter of a triangle.
     * @param perim perimeter as int.
     * @return number of solutions as int.
     */
    private static int wayCounter(int perim) {
        int counter = 0;
        for (int a = 1; a < perim / 2; a++) {
            for (int b = 1; b < perim / 2; b++) {
                for (int c = 1; c < perim / 2; c++) {
                    if (isTriangle(a,b,c) && a+b+c == perim && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
                        counter++;
                }
            }
        }
        return counter/2;
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // variable declaration.
        int solTemp = 0;
        int solMax = 0;
        int perim = 0;
        
        // main loop to check all the perimeters.
        for (int i = 1; i < 1001; i++) {
            solTemp = wayCounter(i);
            if (solTemp > solMax){
                solMax = solTemp;
                perim = i;
            }
        }
        // print the result.
        System.out.println(perim);
    }
}
