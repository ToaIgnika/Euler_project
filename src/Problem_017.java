
import java.util.Scanner;
/**
 * Program finds letter number of all given numbers
 * from 1 to (user input).
 * 
 * @author Yevhen
 * @version
 * "I made this code longer than usual 
 * because I lack time to make it short"
 *
 */

public class Problem_017 {

    private static Scanner scan;
    private static String[] tens = {
        "", //0
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten", //10
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen",
        "thousand", //20
        
        };
    private static String[] bigTens = {
            "",
            "",
            "twenty", 
            "thirty", 
            "forty", 
            "fifty", 
            "sixty", 
            "seventy", 
            "eighty", 
            "ninety", 
            "hundred",
            "and"
    };
    
    /**
     * Converts integer x into text string
     * @param int x
     * @return string of x
     */
    private static String converter(int x) {
        String answer = "";
                     
        // string number generator
        if (x % 1000 == 0) {
            answer = tens[x/1000] + tens[20];
        }
        else if (x % 100 == 0) {
            answer = tens[x/100] + bigTens[10]; 
        }
        else if (x < 20) {
            answer = tens[x];
        }
        else if (x < 100) 
        {
            answer = bigTens[x/10] + tens[x%10];
        }
        else if ((x < 1000) && ((x % 100) < 20))
        {
            answer = tens[x/100] + bigTens[10] + bigTens[11]  + tens[x%100];
        }
        else 
        {
            answer = tens[x/100] + bigTens[10] + bigTens[11] + bigTens[((x%100 - x%10)/10)] + tens[x%10];
        }
        return answer;
    }
    
    
    public static void main(String args[]) {
        scan = new Scanner(System.in);
        int userInt = scan.nextInt();
        String bigAnswer = "";
        for (int i = 1; i <= userInt; i++) {
            bigAnswer += converter(i);
        }
        System.out.println(bigAnswer.length());
    }
}
