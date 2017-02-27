import java.util.ArrayList;

public class Problem_023 {

    private static boolean Abundand(double testNumber) {
        int divider = 1;
        int dividerSum = 0;
        while (divider <= testNumber / 2) {
            if (testNumber % divider == 0) {
                dividerSum += divider;
            }
            divider++;
        }
        if (dividerSum > testNumber) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int sumOfIntegers = 0;
        ArrayList<Integer> abundandList = new ArrayList<Integer>();
        ArrayList<Integer> abundandSums = new ArrayList<Integer>();
        for (int i = 0; i < 28123; i++) {
            if (Abundand(i))
                abundandList.add(i);
        }
        int temp1, temp2, tempSum;
        for (int z = 0; z < abundandList.size(); z++) {
            for (int y = 0; y < abundandList.size(); y++) {
                temp1 = abundandList.get(z);
                temp2 = abundandList.get(y);
                tempSum = temp1 + temp2;
                if ((tempSum <= 28123) && !abundandSums.contains(tempSum))
                    abundandSums.add(tempSum);
            }
        }
        System.out.println(abundandList);
        for (int i = 1; i < 28123; i++) {
            if (!abundandSums.contains(i)) {
                sumOfIntegers += i;
            }
        }
        System.out.println(sumOfIntegers);
    }
}
