package problems051$100;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_054 {

    private static boolean isFlush(ArrayList<String> list) {
        String c1S = list.get(0).substring(1);
        String c2S = list.get(1).substring(1);
        String c3S = list.get(2).substring(1);
        String c4S = list.get(3).substring(1);
        String c5S = list.get(4).substring(1);
        if (c1S.equals(c2S) && c3S.equals(c4S) && c4S.equals(c5S) && c5S.equals(c1S))
            return true;
        return false;
    }

    private static boolean isFullHouse(ArrayList<String> list) {
        int c1 = cardVal(list.get(0));
        int c2 = cardVal(list.get(1));
        int c3 = cardVal(list.get(2));
        int c4 = cardVal(list.get(3));
        int c5 = cardVal(list.get(4));
        if (c1 == c2 && c1 == c3 && c4 == c5)
            return true;
        if (c1 == c2 && c3 == c4 && c4 == c5)
            return true;
        return false;
    }

    private static boolean isFourOfKind(ArrayList<String> list) {
        int c1 = cardVal(list.get(0));
        int c2 = cardVal(list.get(1));
        int c3 = cardVal(list.get(2));
        int c4 = cardVal(list.get(3));
        int c5 = cardVal(list.get(4));
        if (c1 == c2 && c3 == c4 && c1 == c3)
            return true;
        if (c2 == c3 && c4 == c5 && c2 == c4)
            return true;
        return false;
    }

    private static boolean isStraight(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if ((cardVal(list.get(i + 1)) - cardVal(list.get(i))) != 1)
                return false;
        }
        return true;
    }

    private static boolean isThreeKind(ArrayList<String> list) {
        int c1 = cardVal(list.get(0));
        int c2 = cardVal(list.get(1));
        int c3 = cardVal(list.get(2));
        int c4 = cardVal(list.get(3));
        int c5 = cardVal(list.get(4));
        if (c1 == c2 && c2 == c3 && c3 != c4 && c3 != c5 && c4 != c5)
            return true;
        if (c2 == c3 && c3 == c4 && c3 != c1 && c3 != c5 && c1 != c5)
            return true;
        if (c3 == c4 && c4 == c5 && c3 != c1 && c3 != c2 && c1 != c2)
            return true;
        return false;
    }
    
    private static boolean isTwoPairs(ArrayList<String> list) {
        int c1 = cardVal(list.get(0));
        int c2 = cardVal(list.get(1));
        int c3 = cardVal(list.get(2));
        int c4 = cardVal(list.get(3));
        int c5 = cardVal(list.get(4));
        if (c1 == c2 && c3 == c4 && c1 != c3 && c1 != c5 && c3 != c5)
            return true;
        if (c1 == c2 && c4 == c5 && c1 != c3 && c1 != c5 && c3 != c5)
            return true;
        if (c2 == c3 && c4 == c5 && c1 != c3 && c1 != c5 && c3 != c5)
            return true;
        return false;
    }
    
    private static boolean isPair(ArrayList<String> list) {
        int c1 = cardVal(list.get(0));
        int c2 = cardVal(list.get(1));
        int c3 = cardVal(list.get(2));
        int c4 = cardVal(list.get(3));
        int c5 = cardVal(list.get(4));
        if (c1 == c2 && c2 != c3 && c2 != c4 && c2 != c5 && c3!= c4 && c3 != c5 && c4 != c5)
            return true;
        if (c2 == c3 && c3 != c4 && c3 != c5 && c3 != c1 && c4!= c5 && c4 != c1 && c5 != c1)
            return true;
        if (c3 == c4 && c4 != c5 && c4 != c1 && c4 != c2 && c5!= c1 && c5 != c2 && c1 != c2)
            return true;
        if (c4 == c5 && c5 != c1 && c5 != c2 && c5 != c3 && c1!= c2 && c1 != c3 && c2 != c3)
            return true;
        return false;
    }

    private static ArrayList<String> hand(String c1, String c2, String c3, String c4, String c5) {
        ArrayList<String> newHand = new ArrayList<String>();
        ArrayList<String> hand = new ArrayList<String>();
        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);
        // 2-3-4-5-6-7-8-9-T-J-Q-K-A
        int smallest = 0;
        for (int f = 0; hand.size() != 0; f++) {
            f = 0;
            smallest = 0;
            while (f < hand.size() - 1) {
                if (cardVal(hand.get(smallest)) > cardVal(hand.get(f + 1)))
                    smallest = f + 1;
                f++;
            }
            newHand.add(hand.get(smallest));
            hand.remove(smallest);
        }
        return newHand;
    }


    
    private static int cardVal(String c) {
        String[] val = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
        String temp = c.substring(0, 1);
        int i = 0;
        while (!temp.equals(val[i])) {
            i++;
        }
        return i;
    }

    
    public static void main(String[] args) {
        ArrayList<String> testList = new ArrayList<String>();
        testList = hand("9H", "8H", "AH", "9H", "2H");
        if (isPair(testList))
            System.out.println(testList);
        System.out.println(hand("KH", "3H", "AH", "5H", "JH"));
    }
}
