package problems001$050;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem_042.
 * 
 * Given a .txt file with list of words, find all triangle words.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 11, 2017
 *
 */
public class Problem_042 {

    /**
     * variable for Scanner.
     */
    private static Scanner scan;
    
    /**
     * Method to calculate the integer value of the given word.
     * @param victim as a String.
     * @return wordNum as int.
     */
    private static int wordValue(String victim) {
        int wordNum = 0;
        for (int index = 0; index < victim.length(); index++) {
            wordNum += Integer.valueOf(victim.charAt(index)) - 64;
        }
        return wordNum;
    }
    
    /**
     * Drives the program.
     * @param args command line arguments.
     * @throws FileNotFoundException if the file is not opened.
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException {
        
        // open a file in a scanner and read it into ArrayList
        scan = new Scanner(new File("problemFiles/Problem_042.txt")).useDelimiter(",");
        ArrayList<String> nameList = new ArrayList<String>();
        String temp = "";
        while (scan.hasNext()) {
            temp = scan.next().replace("\"","");
            nameList.add(temp);
        }
        
        // create small arraylist of triangle numbers
        ArrayList<Integer> triangleList = new ArrayList<Integer>();
        int triTemp = 26*10;
        for (int i = 1; (i*(i-1)/2) < triTemp ; i++) {
            triangleList.add(i*(i-1)/2);
        }
        
        // count all triangle words in a nameList
        int wordCount = 0;
        for (int listIndex = 0; listIndex < nameList.size(); listIndex++) {
            if (triangleList.contains(wordValue(nameList.get(listIndex))))
                wordCount ++;
        }
        
        // print the result.
        System.out.println(wordCount);
    }
}
