
import java.util.ArrayList;

/**
 * Problem_032.
 * 
 * Program finds the sum of all products whose 
 * multiplicand/multiplier/product identity can be written 
 * as a 1 through 9 pandigital.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version
 *
 */
public class Problem_032 {

    
    /**
     * pandigitalCheck method validates if the given 
     * inputs produce a pandigital number.
     * @param x of type int;
     * @param y of type int;
     * @return return true if pandigital numberl else, return false;
     */
    private static boolean pandigitalCheck(int x, int y) {
        // create a list to check the numbers
        int[] listX = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = x * y;
        int temp = 0;

        // create a string of x,y and their product
        String sumStr = "" + sum + x + y;
        
        // check the length of the string
        if (sumStr.length() != 9) {
            return false;
        }
        // go through the list and replace elements with -1 if they exist.
        for (int i = 0; i < sumStr.length(); i++) {
            temp = Character.getNumericValue(sumStr.charAt(i));
            for (int z = 0; z < 9; z++) {
                if (listX[z] == temp)
                    listX[z] = -1;
            }
        }
        // if at least 1 of the resulting list elements != (-1) return false.
        for (int f = 0; f < 9; f++) {
            if (listX[f] != (-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // variable declaration.
        int sum = 0;
        int productSum = 0;
        
        // create a list of integers to compare;
        ArrayList<Integer> prList = new ArrayList<Integer>();
        
        // fill out the list with all eligible sums.
        for (int a = 0; a <= 2000; a++) {
            for (int b = 0; b <= a; b++) {
                if (pandigitalCheck(a, b)) {
                    sum = a*b;
                    if (!prList.contains(sum))
                        prList.add(sum);
                }
            }
        }
        
        // find the sum of all products
        for (int f = 0; f < prList.size(); f++) {
            productSum += prList.get(f);
        }
        
        // print the answer.
        System.out.println(productSum);
    }
}
