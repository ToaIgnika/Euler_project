import java.util.Scanner;

/**
 * Problem_016.
 * @author Yevhen
 * @version 2.0
 */
public class Problem_016 {
    
    // declaration of public answer
    public static String bigAnswer = "1";
    public static Scanner scan;
    
    // multiply function for any number size
    public static String multiply(int x) {
        // variable declaration 
        int sum = 0; // total sum for each 10^i term
        int temp = 0; // numeric value of each string char
        int rem = 0; // remainder for recording the answer
        int carry = 0; // carryout value for next step
        String result = ""; // temporary string for new answer
        
        // loop for making the multiplication
        for (int i = bigAnswer.length() - 1; i >= 0; i--) {
            sum = 0;
            temp = Character.getNumericValue(bigAnswer.charAt(i));
            sum = temp * x;
            sum = sum + carry;
            rem = sum % 10;
            if (i == 0)
                result = sum + result;
            else
                result = rem + result;
            carry = sum / 10;
        }
        bigAnswer = result;
        return bigAnswer;
    }
    
    /**
     * Drives the program.
     * @param args command line arguments.
     */
    static public void main(String args[])
    {
        // initiate variables
        int answer = 0;
        scan = new Scanner(System.in);
        
        // prompt for user input
        int userInt = scan.nextInt();
        for (int i = 0; i < userInt; i++)
        {
            multiply(2);            
        }
        for (int i = 0; i < bigAnswer.length(); i++) {
            answer += Character.getNumericValue(bigAnswer.charAt(i));
        }
        // print the answer
        System.out.println(answer);
    }
}
