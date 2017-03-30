package problems001$050;

import java.util.ArrayList;

/**
 * Problem_030.
 * 
 * Program finds the sum of numbers which can be
 * rewritten as a sum of its digits in a pow(5).
 * 
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version
 *
 */
public class Problem_030 {
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args){
        // declare variables and creat the arraylist
        ArrayList<Integer> list = new ArrayList<Integer>();
        int power = 5;
        int num = 0;
        int sum = 0;
        String victim = "";
        
        // check all sums from 10 to 1000000
        for (int i = 10; i < 1000000; i++) {
            victim = "" + i;
            for (int z = 0; z < victim.length(); z++) {
                sum += Math.pow(Character.getNumericValue(victim.charAt(z)), power);
            }
            if (sum == i){
                list.add(i);
            }
            sum = 0;
        }
        
        // find the sum of all numbers from the list
        for (int f = 0; f < list.size(); f++) {
            num += list.get(f);
        }
        System.out.println(list);
        System.out.println(num);
    }
}
