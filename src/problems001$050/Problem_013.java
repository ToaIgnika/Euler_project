package problems001$050;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Work out the first ten digits of the sum 
 * of the following one-hundred 50-digit numbers.
 * Program actually calculates the full sum of those
 * numbers.
 * @author Yevhen
 * @version 3.0
 */
public class Problem_013 {
    
    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param arg command line arguments.
     * @throws IOException
     */
    public static void main(String arg[]) throws IOException {
        // copy file into String array
        String location = "problemFiles/Problem_013.txt";
        scan = new Scanner(new File(location));
        String[] list = new String[100];
        for (int i = 0; i < 100; i++) {
            list[i] = scan.next();
        }
        
        // variable declaration
        int sum = 0;
        int temp = 0;
        int rem = 0;
        int carry = 0;
        String result = "";
        
        // nested for loop to calculate the sum 
        for (int s = 49; s >= 0; s--) 
        {
            sum = 0;
            for (int i = 0; i < 100; i++) {
                temp = Character.getNumericValue(list[i].charAt(s));
                sum += temp;
            }
            sum = sum + carry;
            rem = sum % 10;
            if (s == 0)
                result = sum + result;
            else 
                result = rem + result;
            carry = sum / 10;
        }
        
        // print the result
        System.out.println(result);
     }
}
