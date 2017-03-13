import java.util.ArrayList;

/**
 * Problem_051.
 * 
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of
 * the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 * 
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this
 * 5-digit number is the first example having seven primes among the ten
 * generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663,
 * 56773, and 56993. Consequently 56003, being the first member of this family,
 * is the smallest prime with this property.
 * 
 * Find the smallest prime which, by replacing part of the number (not
 * necessarily adjacent digits) with the same digit, is part of an eight prime
 * value family.
 * 
 *
 * "I made this code longer than usual because I lack time to make it short"
 * 
 * @author Yevhen
 * @version Mar 13, 2017
 *
 */
public class Problem_051 {

    /**
     * Method to check if the number is prime.
     * @param victim of type int.
     * @return true if number is prime; else return false.
     */
    private static boolean isPrime(int victim) {
        if (victim <= 1)
            return false;
        for (int div = 2; div <= Math.sqrt((double) victim); div++) {
            if (victim % div == 0)
                return false;
        }
        return true;
    }

    /**
     * Method to create list of binary permutations.
     * @param subSize of type int.
     * @return list of all binary permutations of size subSize.
     */
    private static ArrayList<String> permList(int subSize) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i < Math.pow(2, subSize); i++) {
            String value = Integer.toBinaryString(i);
            if (value.length() < subSize) {
                while (value.length() < subSize)
                    value = "0" + value;
            }
            list.add(value);
        }
        return list;
    }

    /**
     * Method takes in the binary sequence and replaces the number with the replacer
     * for every 1 in the sequence.
     * 
     * @param seq as String.
     * @param num as int.
     * @param replacer as int.
     * @return new number as int.
     */
    private static int compNum(String seq, int num, int replacer) {
        String numStr = "" + num;
        String numNew = "";
        int numOut = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.substring(0, 1).equals("1") && replacer == 0) {
                return 0;
            } else if (seq.substring(i, i + 1).equals("1")) {
                numNew = numNew + replacer;
            } else {
                numNew = numNew + numStr.substring(i, i + 1);
            }
        }
        numNew = numNew + numStr.substring(numStr.length() - 1);
        numOut = Integer.valueOf(numNew);
        return numOut;
    }

    /**
     * Method counts the largest family size for given number. 
     * 1) create the binary array
     * 2) for each array number, try 0-9 values
     * 3) check which binarysequence & 0-9 combo produce the most primes
     * 4) return the number
     * @param victim of type int.
     * @return largest family size as int.
     */
    private static int famCount(int victim) {
        String victimStr = "" + victim;
        String listItem = "";
        String seqB = "";
        int val = 0;
        int countThis = 0;
        int countMax = 0;
        ArrayList<String> list = permList(victimStr.length() - 1);
        for (int listI = 0; listI < list.size(); listI++) {
            listItem = list.get(listI);
            countThis = 0;
            for (int i = 0; i < 10; i++) {
                val = compNum(listItem, victim, i);
                if (isPrime(val))
                    countThis++;
            }
            if (countThis > countMax){
                countMax = countThis;
                seqB = listItem;
            }
        }
        System.out.println(seqB);
        return countMax;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        for (int num = 9; num < 1000000; num += 2) {
            if (isPrime(num))
                primeList.add(num);
        }
        int num = 0;
        for (int i = 11; num != 8; i+=2){
            if (isPrime(i)){
                num = famCount(i);
                System.out.println(i);
            }
        }
        
    }
}
