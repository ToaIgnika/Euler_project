package problems051$100;

import java.util.ArrayList;

/**
 * 
 * 
 *
 * "I made this code longer than usual 
 * because I lack time to make it short"
 * @author Yevhen
 * @version Mar 30, 2017
 *
 */
public class Problem_060 {

    /**
     * Checks if the number is prime.
     * 
     * @param victim
     *            int number.
     * @return true if prime; else, return false.
     */
    private static boolean isPrime(long victim) {
        if (victim < 2)
            return false;
        for (int div = 2; div <= Math.sqrt((double) victim); div++) {
            if (victim % div == 0)
                return false;
        }
        return true;
    }

    /**
     * Check if two numbers are interchangibly prime.
     * 
     * @param a
     * @param b
     * @return
     */
    private static boolean twinTest(int a, int b) {
        if (isPrime(Long.valueOf("" + a + b)) && isPrime(Long.valueOf("" + b + a)))
            return true;
        return false;
    }

    /**
     * Check if the list is valid
     * 
     * @param li
     * @return
     */
    private static boolean isMagicList(int[] li) {
        for (int i = 0; i < li.length - 1; i++) {
            for (int z = i + 1; z < li.length; z++) {
                if (!twinTest(li[i], li[z]))
                    return false;
            }
        }
        return true;
    }

    /**
     * Find the id of the prime number in the ArrayList.
     * 
     * @param prime
     *            int prime.
     * @return id of
     */
    private static int idFinder(int prime) {
        for (int i = 0; i < primeList.size(); i++) {
            if (primeList.get(i) == prime)
                return i;
        }
        return 0;
    }

    /**
     * Finds the next prime number
     * 
     * @param prime
     *            previous prime number
     * @return next prime number
     */
    private static int nextPrime(int prime) {
        int nextP = prime;
        do {
            nextP++;
        } while (!isPrime(nextP));
        return nextP;
    }

    private static void printList(int[] list) {
        String l = "[";
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            l += list[i] + " ";
            sum += list[i];
        }
        l += "] " +  sum;
        System.out.println(l);
    }

    private static int[] subList(int[] list, int leng) {
        int[] newList = new int[leng];
        for (int i = 0; i < leng; i++) {
            newList[i] = list[i];
        }
        return newList;
    }

    /**
     * arraylist of primes
     */
    private static ArrayList<Integer> primeList;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        // create list of primes
        primeList = new ArrayList<Integer>();
        for (int i = 1; i < 100000; i++) {
            if (isPrime(i))
                primeList.add(i);
        }
       
        int[] primeL = { 3, 5, 7, 11, 13 };
        while (primeL[0] < 25) {
            while (primeL[1] < 10000) {
                if (isMagicList(subList(primeL, 2))) {
                    while (primeL[2] < 10000) {
                        if (isMagicList(subList(primeL, 3))) {
                            while (primeL[3] < 20000) {
                                if (isMagicList(subList(primeL, 4))) {
                                    while (primeL[4] < 50000) {
                                        if (isMagicList(primeL)) {
                                            printList(primeL);
                                        }
                                        primeL[4] = nextPrime(primeL[4]);
                                    }
                                }
                                primeL[3] = nextPrime(primeL[3]);
                                primeL[4] = nextPrime(primeL[3]);
                            }
                        }
                        primeL[2] = nextPrime(primeL[2]);
                        primeL[3] = nextPrime(primeL[2]);
                    }
                }
                primeL[1] = nextPrime(primeL[1]);
                primeL[2] = nextPrime(primeL[1]);
            }
            primeL[0] = nextPrime(primeL[0]);
            primeL[1] = nextPrime(primeL[0]);
        }

        System.out.println("Done");
    }
}
