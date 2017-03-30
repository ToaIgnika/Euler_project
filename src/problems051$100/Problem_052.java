package problems051$100;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem_052.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 *
 * "I made this code longer than usual because I lack time to make it short"
 * 
 * @author Yevhen
 * @version Mar 14, 2017
 *
 */
public class Problem_052 {
    
    /**
     * Method to check if two integers are permutation of each other.
     * @param num1 first number.
     * @param num2 second number.
     * @return true, if they are permittable; else, return false.
     */
    private static boolean isPerm(int num1, int num2) {
        ArrayList<Integer> num1List = new ArrayList<Integer>();
        ArrayList<Integer> num2List = new ArrayList<Integer>();
        String num1Str = "" + num1;
        String num2Str = "" + num2;
        if (num1Str.length() != num2Str.length())
            return false;
        for (int i = 0; i < num1Str.length(); i++) {
            num1List.add(Integer.valueOf(num1Str.substring(i, i + 1)));
            num2List.add(Integer.valueOf(num2Str.substring(i, i + 1)));
        }
        Collections.sort(num1List);
        Collections.sort(num2List);
        for (int i = 0; i < num1List.size(); i++) {
            if (num1List.get(i) != num2List.get(i))
                return false;
        }
        return true;

    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int q = 1;
        while (!(isPerm(q, q * 2) && isPerm(q, q * 3) && isPerm(q, q * 4) && isPerm(q, q * 5) && isPerm(q, q * 6))) {
            q++;
        }
        System.out.println(q);
    }
}
