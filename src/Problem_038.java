
/**
 * Problem_038.
 * 
 * Program finds the largest 1 to 9 pandigital 9-digit number 
 * that can be formed as the concatenated product of an integer 
 * with (1,2, ... , n) where n > 1.
 * 
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 9, 2017
 *
 */
public class Problem_038 {

    /**
     * Method to find the 9-digit concat number.
     * @param victim of type int.
     * @return 0 if number is not 9-digit long; else, return concatedNum.
     */
    private static int concat(int victim) {
        String concatedNum = "";
        int mult = 1;
        int temp = 0;
        while (concatedNum.length() < 9) {
            temp = victim * mult;
            concatedNum += temp;
            mult++;
        }
        if (concatedNum.length() != 9) {
            return 0;
        }
        return Integer.valueOf(concatedNum);
    }

    /**
     * Method to check if the number is Pandigital of 1-9.
     * @param victim of type int.
     * @return true if pandigital; else, return false.
     */
    private static boolean isPandigital(int victim) {
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String victimStr = "" + victim;
        int value = 0;
        for (int index = 0; index < victimStr.length(); index++){
            value = Integer.valueOf(victimStr.substring(index, index+1));
            for (int listC = 0; listC < list.length; listC++){
                if (list[listC] == value)
                    list[listC] = -1;
            }
        }
        for (int listI = 0; listI < list.length; listI++) {
            if (list[listI] != (-1))
                return false;
        }
        return true;
    }

    /**
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int biggestPan = 0;
        int tempPan = 0;
        for (int i = 1; i < 1000000; i++){
            tempPan = concat(i);
            if (isPandigital(tempPan) && tempPan > biggestPan)
                biggestPan = tempPan;
        }
        System.out.println(biggestPan);
    }
}
