
/**
 * Problem_009.
 * Find a Pythagorean triplet for which a + b + c = 1000,
 * where a-b-c are natural numbers.
 * @author Yevhen
 * @version 1.0.
 */
public class Problem_009 {
    
    /**
     * Drives the program.
     * @param arg command line arguments.
     */
    public static void main(String arg[])
    {
        // variable declaration
        int a = 0;
        int b = 0;
        double c = 0;
        double cCheck; //cCheck MUST be double to extract the root accurately
        
        /*program has two nested loops to run through two arrays from
        1 to 1000. It calculates the third term, takes the sqrt and 
        checks, if the conditions are met (sum=1000 and it is a triangle)*/
        for (int aCheck = 1; aCheck < 1000; aCheck++)
        {
            for (int bCheck = 1; bCheck < 1000; bCheck++)
            {
                cCheck = Math.sqrt(aCheck * aCheck + bCheck * bCheck);
                if (((aCheck + bCheck + cCheck) == 1000) && (aCheck < bCheck) && (bCheck < cCheck))
                {
                    a = aCheck;
                    b = bCheck;
                    c = cCheck;
                }
            }
        }
        System.out.println(a + " " + b + " " + c);
        System.out.println(a + b + c);
        System.out.println(a * b * c);
        System.out.println(a*a);
        System.out.println(b*b);
        System.out.println(c*c);
        System.out.println(a*a + b*b);
    }
}
