import java.util.Scanner;

/**
 * Problem_005.
 * Find smallest positive number that is evenly divisible
 * by all of the numbers from 1 to (user input)
 * @author Yevhen
 *
 */
public class Problem_005 {
    
    /**
     * method checks if the given number can be divided by the
     * range from 1 to range
     * @param num number to check
     * @param range of dividers
     * @return 1 for true, 0 for false
     */
    public static int isSmallest(int num, int range)
    {
        for (int startNum = 1; startNum <= range; startNum++)
        {
            if (num % startNum != 0)
                return 0;
        }
        return 1;
    }
    
    public static void main(String arg[])
    {
        // initialize variables
        Scanner scan = new Scanner(System.in);
        int userNum = scan.nextInt();
        int answer = 0;
        int counter = 1;
        boolean check = true;
        
        // while loop with bool exit
        while (check)
        {
            if (isSmallest(counter, userNum) == 1)
            {
                answer = counter;
                check = false;
            }
            counter++;
        }
        System.out.println(answer);
    }

}
