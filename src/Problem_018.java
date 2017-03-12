

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Problem_018 {
    
    private static Scanner scan;
    /**
     * Drives the program.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // read the pyramid from the file into 2D array.
        String location = "problemFiles/Problem_018.txt";
        File fileLoc = new File(location);
        scan = new Scanner(fileLoc);
        int[][] bigList = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int z = 0; z <= i; z++) {
                bigList[i][z] = Integer.valueOf(scan.next()); // i = row, z = id
            }
        }
        
        // perform computation for largest sum chain.
        for (int i = 14; i > 0; i--) {

            for (int z = 0; z < i; z++) {
                if (bigList[i][z] < bigList[i][z + 1]) {
                    bigList[i - 1][z] += bigList[i][z + 1];
                } else {
                    bigList[i - 1][z] += bigList[i][z];
                }
            }
        }
        // print the answer
        System.out.println(bigList[0][0]);
    }
}
