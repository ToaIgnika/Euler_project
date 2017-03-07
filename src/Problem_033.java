

public class Problem_033 {
    
    public static void main(String[] args){
        int num = 0, denum = 0;
        for (int numerator = 10; numerator < 100; numerator ++) {
            for (int denumerator = numerator+1; denumerator < 100; denumerator++) {
                for (int commonDiv = 2; commonDiv < numerator; commonDiv++) {
                    if (numerator%commonDiv == 0 && denumerator%commonDiv == 0){
                        num = numerator/commonDiv;
                        denum = denumerator/commonDiv;
                        if (num < 10 && denum <10){
                            System.out.println(numerator+"/"+denumerator+"  "+num+"/"+denum);
                        }
                    }
                }
            }
        }
        
    }
}
