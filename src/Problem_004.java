/**
 * Problem_005.
 * Find largest palindrome number made from
 * the product of 3-digit numbers.
 * @author Yevhen
 *
 */

public class Problem_004 {
    
    /**
     * method checks if the number is palidrome or not.
     * 1 = yes, 0 = no
     * @param x
     * @return
     */
    public static int check(int x)
    {
        String Checker = "" + x;
        String Inverse = "";
        for (int i = Checker.length() - 1; i >= 0 ; i--)
        {
            Inverse = Inverse + Checker.charAt(i);
        }
        if (Checker.equals(Inverse))
            return 1;
        else
            return 0;
    }
    
    /**
     * Drives the program.
     * @param arg command line arguments.
     */
    public static void main(String arg[])
    {
        // declare variables
        int answerTemp = 0;
        int answerFinal = 0;
        
        // nested for loops
        for (int s = 100; s < 1000; s++)
        {
            for (int z = 100; z < 1000; z++)
            {
                answerTemp = s * z;
                
                // check if the product is a palidrome
                if (check(answerTemp) == 1)
                {
                    if (answerTemp > answerFinal)
                        answerFinal = answerTemp;
                }
                    
            }
            
        }
        System.out.println(answerFinal); 
    }
}
