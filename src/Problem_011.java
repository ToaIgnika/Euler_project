import java.io.*;
import java.util.Scanner;

/**
 * Given a 20x20 list of numbers, find the largest
 * product of 4 consecutive numbers in hor\vert\diag
 * @author Yevhen
 * @version 2.0
 */
public class Problem_011 {
    
    //==============================
    public static void main(String str[]) throws IOException {
       
        // copy the list from the file into 
        String location = "bin/Problem_011.txt";
        Scanner scan = new Scanner(new File(location));
        int[][] newList = new int[20][20];
        for (int s = 0; s < 20; s++)
        {
            for (int z = 0; z < 20; z++)
            {
            newList[s][z] = scan.nextInt();
            }
        }
        
        int resultFinal = 0;
        int resultTemp = 0;
        
        //horizontal max checker
        for (int s = 0; s < 20; s++)
        {
            for (int z = 0; z < 20 - 3; z++)
            {
                resultTemp = newList[z][s] * newList[z + 1][s] 
                        * newList[z + 2][s] * newList[z + 3][s];
                if (resultTemp > resultFinal)
                    resultFinal = resultTemp;
            }
        }
        
        // horizontal max checker
        for (int s = 0; s < 20; s++)
        {
            for (int z = 0; z < 20 - 3; z++)
            {
                resultTemp = newList[s][z] * newList[s][z + 1] 
                        * newList[s][z + 2] * newList[s][z + 3];
                if (resultTemp > resultFinal)
                    resultFinal = resultTemp;
            }
        }
        
        // diagonal 1 checker
        for (int s = 0; s < 20 - 3; s++)
        {
            for (int z = 0; z < 20 - 3; z++)
            {
                resultTemp = newList[s][z] * newList[s + 1][z + 1] 
                        * newList[s + 2][z + 2] * newList[s + 3][z + 3];
                if (resultTemp > resultFinal)
                    resultFinal = resultTemp;
            }
        }
        
        // diagonal 2 checker
        for (int s = 0; s < 20 - 3; s++)
        {
            for (int z = 0; z < 20 - 3; z++)
            {
                resultTemp = newList[s][z + 3] * newList[s + 1][z + 2] 
                        * newList[s + 2][z + 1] * newList[s + 3][z];
                if (resultTemp > resultFinal)
                    resultFinal = resultTemp;
            }
        }
        
        // printing results
        System.out.println(resultFinal);
    }
}