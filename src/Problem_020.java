import java.math.BigInteger;
import java.util.Scanner;

/**
 * Factorial digit sum of user int.
 * @author Yevhen
 * @version
 * "I made this code longer than usual 
 * because I lack time to make it short"
 *
 */
public class Problem_020 {

    private static Scanner scan;
    public static void main(String[] args) {
        // prompt for user input.
        scan = new Scanner(System.in);
        int userInt = scan.nextInt();

        // declare variables and big integer.
        String stringAnswer = "";
        int digitSum = 0;
        BigInteger answer = BigInteger.valueOf(1);

        // find the factorial of user input.
        for (int i = 1; i <= userInt; i++) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }

        // convert the result in string and count the sum of the digits.
        stringAnswer = "" + answer;
        for (int stringCounter = stringAnswer.length()-1; 
                stringCounter >=0; stringCounter--) {
            digitSum += Character.getNumericValue(stringAnswer.charAt(stringCounter));
        }

        // print the answer.
        System.out.println(digitSum);
    }
}
