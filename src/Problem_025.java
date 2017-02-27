import java.math.BigInteger;

public class Problem_025 {
    
    public static void main(String[] args) {
        BigInteger fibbonaciPrev = BigInteger.valueOf(1);
        BigInteger fibbonaciThis = BigInteger.valueOf(1);
        BigInteger fibbonaciNext = BigInteger.valueOf(1);
        String sizeCheck = "";
        int id = 2;
        while (sizeCheck.length() < 1000) {
            fibbonaciNext = fibbonaciPrev.add(fibbonaciThis);
            sizeCheck = "" + fibbonaciNext;
            fibbonaciPrev = fibbonaciThis;
            fibbonaciThis = fibbonaciNext;
            id++;
            //System.out.println(id + " " + fibbonaciNext + " " + sizeCheck.length());
        }
        System.out.println(id);
    }
}
