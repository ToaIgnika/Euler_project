import java.util.Scanner;

/**
 * Sum of all amucable numbers below (user input).
 * @author Yevhen
 * @version 2.26.17
 * "I made this code longer than usual 
 * because I lack time to make it short"
 *
 */
public class Problem_021 {
    
    /**
     * Check if the input number is amicable. 
     * @param double testValue
     * @return true if the value is Amicable.
     */
    private static boolean Amicable(double testValue) {
        double divSum = 0;
        int secondDivSum = 0;
        int divider = 1;
        while (divider <= testValue/2) {
            if (testValue % divider == 0) {
                divSum += divider;
            }
            divider ++;
        }
        if (divSum != testValue) {
            divider = 1;
            while (divider <= divSum/2) {
                if (divSum % divider == 0) {
                    secondDivSum += divider;
                }
                divider ++;
            }
        }
        
        if (testValue == secondDivSum) {
            System.out.println(testValue + "-" + secondDivSum);
            return true;
        }
        else {
        return false;
        }
    }
    
    private static Scanner scan;
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        double userInt = scan.nextDouble();
        double sum = 0;
        for (int i = 1; i < userInt; i++) {
            if(Amicable(i)) {
                sum +=i;
            }
        }
        System.out.println(sum);
    }
}
