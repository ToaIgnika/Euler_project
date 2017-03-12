
import java.util.Scanner;

/**
 * Problem_031.
 * 
 * Program finds the number of ways to make 200+cents out of
 * 1,2,5,10,20,50,100 and 200 coin sets.
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version
 *
 */
public class Problem_031 {
    
    /**
     * variable for scanner.
     */
    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // prompt for user input.
        System.out.println("Enter the num >= 200: ");
        scan = new Scanner(System.in);
        
        // variable declaration.
        int userInt = scan.nextInt();
        int perms = 0;
        int sum = 0;
        
        // 8 nested for loops check all possible combinations
        // and count all that match the user input.
        for (int i200 = 0; i200 <= userInt/200; i200 ++) {
            for (int i100 = 0; i100 <=userInt/100; i100++) {
                for (int i50 = 0; i50 <=userInt/50; i50++) {
                    for (int i20 = 0; i20 <=userInt/20; i20++) {
                        for (int i10 = 0; i10 <=userInt/10; i10++) {
                            for (int i5 = 0; i5<=userInt/5; i5++) {
                                for (int i2 = 0; i2<= userInt/2; i2++) {
                                    for (int i1 = 0; i1<=userInt; i1++) {
                                        sum = i1 + i2*2 + i5*5 + i10*10 + i20*20 + i50*50 + i100*100 + i200*200;
                                        if (sum == userInt)
                                            perms++;
                                    }}}}}}}}
        // print the solution.
        System.out.println(perms);
    }
}
