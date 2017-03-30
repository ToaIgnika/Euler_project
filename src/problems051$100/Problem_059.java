package problems051$100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_059 {

    private static String gateXOR(String code, String key) {
        while (code.length() > key.length()) {
            key = "0" + key;
        }

        while (key.length() > code.length()) {
            code = "0" + code;
        }

        String output = "";
        for (int i = 0; i < code.length(); i++) {
            if (i == code.length() - 1) {
                if (!code.substring(i).equals(key.substring(i)))
                    output += "1";
                else 
                    output += "0";
            } else if (!code.substring(i, i + 1).equals(key.substring(i, i + 1)))
                output += "1";
            else
                output += "0";
        }
        return output;
    }

    private static String toByte(String victim) {
        String byteVal = Integer.toBinaryString(Integer.valueOf(victim));
        return byteVal;
    }

    private static int toInt(String bin) {
        int answer = 0;
        int power = bin.length() - 1;
        for (int i = 0; i < bin.length(); i++) {
            if (i == bin.length() - 1) {
                if (bin.substring(i).equals("1")) {
                    answer += (int) Math.pow(2, power);
                }
            }

            else if (bin.substring(i, i + 1).equals("1")) {
                answer += (int) Math.pow(2, power);
            }
            power--;
        }
        return answer;
    }

    private static boolean charCheck(int victim) {
        if (victim < 32 || victim > 127) {
            return false;
        }
        return true;
    }

    private static Scanner scan;

    public static void main(String[] args) {
        try {
            scan = new Scanner(new File("problemFiles/Problem_059.txt")).useDelimiter(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // --------Creating array from the file
        ArrayList<String> list = new ArrayList<String>();
        String temp;
        while (scan.hasNext()) {
            temp = scan.next().replace("\"", "");
            list.add(temp);
        }

        // ---------------------------------------
        String key = "";
        String answ = "";
        char letter;
        int loop = 0;
        int c;
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                for (char c3 = 'a'; c3 <= 'z'; c3++) {
                    c = toInt(gateXOR(toByte(list.get(0)), toByte("" + Integer.valueOf(c1))));
                    answ = "";
                    loop = 0;
                    if (c > 20 && c < 125) {
                        for (int i = 0; i < list.size() && charCheck(c); i++) {
                            key = list.get(i);
                            if (loop == 0) {
                                c = toInt(gateXOR(toByte(key), toByte("" + Integer.valueOf(c1))));
                                loop++;
                            } else if (loop == 1) {
                                c = toInt(gateXOR(toByte(key), toByte("" + Integer.valueOf(c2))));
                                loop++;
                            } else {
                                c = toInt(gateXOR(toByte(key), toByte("" + Integer.valueOf(c3))));
                                loop = 0;
                            }
                            answ += (char) c;
                           System.out.println(i + " " + c1 + " " + c2 + " " + c3);
                        }
                    }
                    //System.out.println(answ);
                    // System.out.println("!");
                }
            }
        }
        answ = "";
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (int i = 0; i < list.size(); i++) {
            key = list.get(0);
            //System.out.println((char) toInt(gateXOR(toByte("" + Integer.valueOf(c1)),  toByte(key))));
            }
        }
        System.out.println("done");
        System.out.println((char) toInt(gateXOR(toByte("79"),  toByte("103"))));
        // System.out.println(toInt((gateXOR(toByte("" + 65), toByte("" +
        // 42)))));

        // int upCase = 65;
        // int lowCase = 97;

    }
}
