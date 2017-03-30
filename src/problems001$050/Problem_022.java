package problems001$050;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Using given text file, sort it alphabetical order and work out the
 * aplphabetical value of each name. Find total of all the name scores.
 * 
 * @author Yevhen
 * @version 
 * "I made this code longer than usual because I lack time to make it
 *          short"
 *
 */

public class Problem_022 {

    public static void main(String[] args) throws IOException {
        // create an array to write down all the names from the list
        ArrayList<String> holder = new ArrayList<String>();
        String location = "problemFiles/Problem_022.txt";
        File fileLoc = new File(location);
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(fileLoc).useDelimiter(",");
        String temp = "";
        int bigSum = 0;
        int wordSumValue;
        while (scan.hasNext()) {
            temp = scan.next().replace("\"", "");
            holder.add(temp);
        }
        
        // cheat and sort the name list by alphabet.
        Collections.sort(holder);
        
        // calculate the all name scores.
        for (int i = 0; i < holder.size(); i++) {
            String temp2 = holder.get(i);
            wordSumValue = 0;
            for (int z = 0; z < temp2.length(); z++) {
                wordSumValue += (Character.getNumericValue(temp2.charAt(z)) - 9);
            }
            bigSum += (wordSumValue * (i+1));
        }
        System.out.println(bigSum);
    }
}
