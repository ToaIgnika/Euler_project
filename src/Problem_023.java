import java.util.ArrayList;

/**
 * Program finds the sum of all the positive integers which cannot be 
 * written as the sum of two abundant numbers
 * 
 * @author Yevhen
 * @version
 * "I made this code longer than usual 
 * because I lack time to make it short"
 *
 */
public class Problem_023 {

    /**
     * Checks if the number is Abundand.
     * 
     * @param testNumber
     * @return
     */
    private static boolean Abundand(double testNumber) {
        int divider = 1;
        int dividerSum = 0;
        while (divider <= testNumber / 2) {
            if (testNumber % divider == 0) {
                dividerSum += divider;
            }
            divider++;
        }
        if (dividerSum > testNumber) {
            return true;
        } else {
            return false;
        }
    }

    
    /**
     * Drives the program.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // create two lists: one for abundand numbers and for all possible sums.
        int sumOfIntegers = 0;
        ArrayList<Integer> abundandList = new ArrayList<Integer>();
        ArrayList<Integer> abundandSums = new ArrayList<Integer>();
        
        // create the list of all abundand numbers.
        for (int i = 0; i < 28123; i++) {
            if (Abundand(i))
                abundandList.add(i);
        }
        int temp1, temp2, tempSum;
        
        // create the list of all possile sums.
        for (int z = 0; z < abundandList.size(); z++) {
            for (int y = 0; y < abundandList.size(); y++) {
                temp1 = abundandList.get(z);
                temp2 = abundandList.get(y);
                tempSum = temp1 + temp2;
                if ((tempSum <= 28123) && !abundandSums.contains(tempSum))
                    abundandSums.add(tempSum);
            }
        }
        
        // find the sum of all integers that are not in the list of sums.
        System.out.println(abundandList);
        for (int i = 1; i < 28123; i++) {
            if (!abundandSums.contains(i)) {
                sumOfIntegers += i;
            }
        }
        // print the answer.
        System.out.println(sumOfIntegers);
    }
}
