import java.util.ArrayList;

public class Problem_032 {

    private static boolean pandigitalCheck(int x, int y) {
        int[] listX = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = x * y;
        int temp = 0;

        // System.out.println(listX);
        String sumStr = "" + sum + x + y;
        if (sumStr.length() != 9) {
            return false;
        }
        for (int i = 0; i < sumStr.length(); i++) {
            temp = Character.getNumericValue(sumStr.charAt(i));
            for (int z = 0; z < 9; z++) {
                if (listX[z] == temp)
                    listX[z] = -1;
            }
        }
        for (int f = 0; f < 9; f++) {
            if (listX[f] != (-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // create a list of integers to compare;
        ArrayList<Integer> prList = new ArrayList<Integer>();
        
        int answer = 0;
        for (int a = 0; a <= 10000; a++) {
            for (int b = 0; b <= 10000; b++) {
                if (pandigitalCheck(a, b)) {
                    int sum = a*b;
                    if(!prList.contains(sum))
                        prList.add(sum);
                }
            }
        }
        System.out.println(prList);
        for (int i = 0; i < prList.size(); i++) {
        answer += prList.get(0);
        }
        System.out.println(answer);
        // System.out.println(list);
    }
}
