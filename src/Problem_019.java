/**
 * Problem_019.
 * 
 * Program counts how many Sundays were the first days of the month.
 * @author Yevhen
 * @version 2.26.17
 * "I made this code longer than usual 
 * because I lack time to make it short"
 *
 */
public class Problem_019 {
    // declare variable for sunday count.
    private static int sundayFirst = 0;

    /**
     * Checks if the given month and start day has sunday as a 1st.
     * @param daysThisMonth .
     * @param currentDayOfWeek.
     * @return current day of the week as int.
     */
    private static int MondayCounter(int daysThisMonth, 
            int currentDayOfWeek) {
        for (int dayOfMonth = 1; dayOfMonth <= daysThisMonth; dayOfMonth++) {
            if (currentDayOfWeek == 7 && dayOfMonth == 1) {
                sundayFirst ++;
            }
            if (currentDayOfWeek != 7) currentDayOfWeek ++;
            else currentDayOfWeek = 1;
        }
        return currentDayOfWeek;
    }
    
    /**
     * Understanding the problem
     * Jan 31
     * Feb 28/29
     * Mar 31
     * Apr 30
     * May 31
     * June 30
     * July 31
     * Aug 31
     * Sep 30
     * Oct 31
     * Nov 30
     * Dec 31
     *
     * Drives the program.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        int startYear = 1900;
        int endYear = 2000;
        int dayOfWeek = 1;
        int daysThisFeb;
        for (int year = startYear; year <= endYear; year ++) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 100 ==0 && year % 400 == 0))
                daysThisFeb = 29;
            else 
                daysThisFeb = 28;
            dayOfWeek = MondayCounter(31, dayOfWeek);
            dayOfWeek = MondayCounter(daysThisFeb, dayOfWeek);
            dayOfWeek = MondayCounter(31, dayOfWeek);
            dayOfWeek = MondayCounter(30, dayOfWeek);
            dayOfWeek = MondayCounter(31, dayOfWeek);
            dayOfWeek = MondayCounter(30, dayOfWeek);
            dayOfWeek = MondayCounter(31, dayOfWeek);
            dayOfWeek = MondayCounter(31, dayOfWeek);
            dayOfWeek = MondayCounter(30, dayOfWeek);
            dayOfWeek = MondayCounter(31, dayOfWeek);
            dayOfWeek = MondayCounter(30, dayOfWeek);
            dayOfWeek = MondayCounter(31, dayOfWeek);
            //System.out.println(year + ": " + sundayFirst);
        }
        System.out.println(sundayFirst);
    }
}
