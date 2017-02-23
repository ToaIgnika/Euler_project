/**
 * Problem_067.
 * Harder version of problem_018. Solution is optimized.
 * Program reads a pyramid of numbers from the file
 * and computes the largest sum of adjacent sum.
 * File needs manual adjustments for the size of the pyramid.
 */

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Problem_067 {
    
    /**
     * Drives the program.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //read the table from the file into 2D array
        String location = "problemFiles/Problem_067.txt";
        File fileLoc = new File(location);
        Scanner scan = new Scanner(fileLoc);
        int[][] bigList = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int z = 0; z <= i; z++) {
                bigList[i][z] = Integer.valueOf(scan.next()); // i = row, z = id
            }
        }
        
        //perform computation fo the largest sum
        for (int i = 99; i > 0; i--) {

            for (int z = 0; z < i; z++) {
                if (bigList[i][z] < bigList[i][z + 1]) {
                    bigList[i - 1][z] += bigList[i][z + 1];
                } else {
                    bigList[i - 1][z] += bigList[i][z];
                }
            }
        }
        //output the answer
        System.out.println(bigList[0][0]);
    }
}
