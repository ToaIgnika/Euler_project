package problems001$050;

import java.util.ArrayList;

/**
 * Problem_024.
 *
 * Program finds the millionth lexicographic
 * permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9
 * @author Yevhen
 * @version
 * "I made this code longer than usual 
 * because I lack time to make it short"
 *
 */
public class Problem_024 {

    static ArrayList<String> holder = new ArrayList<String>();

    // print n! permutation of the characters of the string s (in order)
    public static void perm1(String s) {
        perm1("", s);
    }

    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            holder.add(prefix);
            //System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
        }

    }

    // swap the characters at indices i and j
    @SuppressWarnings("unused")
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
        int n = 10;
        String alphabet = "0123456789";
        String elements = alphabet.substring(0, n);
        perm1(elements);
        System.out.println(holder.get(999998));
        System.out.println(holder.get(999999));
        System.out.println(holder.get(1000000));
    }
}
