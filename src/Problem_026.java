
import java.util.ArrayList;

/**
 * Problem_026.
 * 
 * Program finds the value of d < 1000 for which 1/d contains the longest
 * recurring cycle in its decimal fraction part.
 *
 * "I made this code longer than usual because I lack time to make it short"
 * 
 * @author Yevhen
 * @version
 *
 */
public class Problem_026 {

    /**
     * Drives the program.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        // initialize the variables
        ArrayList<Integer> remainders = new ArrayList<Integer>();
        int number, divider, remainder, remLength, largestD;
        boolean checker;
        number = 1;
        divider = 1;
        remainder = 1;
        remLength = 0;
        largestD = 0;
        for (int i = 2; i < 1000; i++) {
            divider = i;
            checker = true;
            number = 1;
            remainders.clear();
            while (checker) {
                
                while (number <= divider) {
                    number *= 10;
                    //System.out.println(i);
                }
                remainder = number % divider;
                number /= divider;
                
                if (remainder == 0)
                {
                    checker = false;
                }
                if (!remainders.contains(remainder)) {
                    remainders.add(remainder);
                    number = remainder;
                } else {
                    checker = false;
                    if (remLength < remainders.size()){
                        remLength = remainders.size();
                        largestD = divider;
                    }
                }
            }
            System.out.println(remainders);
        }
        System.out.println(largestD);
        //System.out.println(remLength);
    }
}
