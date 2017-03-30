package problems001$050;

/**
 * Problem_033.
 * 
 * Program finds the special cancel fractions,
 * then returns the denominator of their product 
 * in the lowest common term.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version
 *
 */

public class Problem_033 {

    /**
     * Method to check if the fraction is special.
     * @param numX numenator of type int.
     * @param denumX denumenator of type int.
     * @return true if the fraction is special; else return false.
     */
    private static boolean specialCheck(int numX, int denumX) {
        // declare variables to perform the check
        int numIndex1 = numX / 10;
        int numIndex2 = numX % 10;
        int denumIndex1 = denumX / 10;
        int denumIndex2 = denumX % 10;
        double fraction1 = (double) numX / denumX;
        double fraction2 = 0;
        
        // exclude all trivial fractions
        if (numIndex1 == 0 || denumIndex1 == 0 || numIndex2 == 0 || denumIndex2 == 0)
            return false;
        
        // check all index combinations
        if (numIndex1 == denumIndex1) {
            fraction2 = (double) numIndex2 / denumIndex2;
            if (fraction2 == fraction1)
                return true;
        }
        if (numIndex1 == denumIndex2) {
            fraction2 = (double) numIndex2 / denumIndex1;
            if (fraction2 == fraction1)
                return true;
        }
        if (numIndex2 == denumIndex1) {
            fraction2 = (double) numIndex1 / denumIndex2;
            if (fraction2 == fraction1)
                return true;
        }
        if (numIndex2 == denumIndex2) {
            fraction2 = (double) numIndex1 / denumIndex1;
            if (fraction2 == fraction1)
                return true;
        }
        return false;
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        //initiate variables to store the product.
        int num = 1, denum = 1;
        // two nested loops go throw all fractions from 10/11 to 98/99.
        for (int numerator = 10; numerator < 100; numerator++) {
            for (int denumerator = numerator + 1; denumerator < 100; denumerator++) {
                if (specialCheck(numerator, denumerator)) {
                    num *= numerator;
                    denum *= denumerator;
                    System.out.println(numerator + "/" + denumerator);
                }
            }
        }
        
        // find the gcd of the product to obtain the solution
        int gcd = 0; 
        for (int tempGcd = 1; tempGcd <= num; tempGcd++) {
            if (num%tempGcd == 0 && denum%tempGcd==0)
                gcd = tempGcd;
        }
        System.out.println(denum/gcd);
    }
}
