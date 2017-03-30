package problems001$050;

import java.util.ArrayList;

/**
 * Problem_044.
 * 
 * Program finds the pair of pentagonal numbers, Pj and Pk, for which their 
 * sum and difference are pentagonal and D = |Pk - Pj| is 
 * minimised.
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 11, 2017
 *
 */
public class Problem_044 {
    
    /**
     * Drives the program.    
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // create a list of pentagonal numbers
        ArrayList<Integer> pentagonal = new ArrayList<Integer>();
        for (int num = 1; num < 10000; num++) {
            pentagonal.add(num * (num * 3 - 1) / 2);
        }
        
        // declare variables
        int sum = 0;
        int diff = 0;
        
        // go through the list of pentagonal numbers until we find the first pair
        for (int j = 0; j < pentagonal.size() - 1; j++) {
            for (int k = j + 1; k < pentagonal.size(); k++) {
                sum = pentagonal.get(k) + pentagonal.get(j);
                diff = pentagonal.get(k) - pentagonal.get(j);
                if (pentagonal.contains(sum) && pentagonal.contains(diff)){
                    // print the result
                    System.out.println(pentagonal.get(k) + " " + pentagonal.get(j));
                    System.out.println(pentagonal.get(k) - pentagonal.get(j));
                    k = pentagonal.size() + 1;
                    j = k;
                }
            }
        }
        // indicate that the program is done
        System.out.println("done");
    }
}
