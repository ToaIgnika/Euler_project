import java.util.Scanner;

/** 
 * Problem_002.
 * Programs counts the sum of all even numbers
 * of Fibbonachi sequence up until users entered value.
 * @author Yevhen
 *
 */
public class Problem_002 {
    /**
     * Drives the program.
     * @param arg command line arguments.
     */
    public static void main(String arg[]){
        // declaration of variables and user input
        Scanner scan = new Scanner (System.in);
        final int limitNum = scan.nextInt();
        int fibThis = 1;
        int fibNext = 2;
        int tempInt = 0;
        int sum = 0;
        
        // loop for calculating the sum
        while (fibNext < limitNum)
        {
            if ((fibNext % 2) == 0)
                sum = sum + fibNext;
            tempInt = fibThis;
            fibThis = fibNext;
            fibNext = fibThis + tempInt;
        }
        System.out.println(sum);
    }
}
