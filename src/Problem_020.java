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
        scan = new Scanner(System.in);
        int userInt = scan.nextInt();
        String stringAnswer = "";
        int digitSum = 0;
        BigInteger answer = BigInteger.valueOf(1);
        for (int i = 1; i <= userInt; i++) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        stringAnswer = "" + answer;
        for (int stringCounter = stringAnswer.length()-1; 
                stringCounter >=0; stringCounter--) {
            digitSum += Character.getNumericValue(stringAnswer.charAt(stringCounter));
        }
        System.out.println(digitSum);
    }
}
