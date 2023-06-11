package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author saurabh vaish
 * @Date 06-09-2022
 */
public class IntegerToRoman {

    public static void main(String[] args) {
//        int num = 58; // LVIII
        int num = 1994; // MCMXCIV

        System.out.println(countRoman(num));

    }

    static String countRoman(int num){
        List<Integer> list = new ArrayList<>();
        int unit=1;

        String[] metaString = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] metaNumber = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < metaNumber.length; i++) {
            map.put(metaNumber[i],metaString[i]);
        }

        int[] ar = new int[Integer.toString(num).length()];

        String roman="";
        int k=0;
        while (num!=0){
            int rem = num%10;

            list.add(rem * unit);

            ar[k++]=rem;

            num/=10;
            unit*=10;
        }

        for (int i = 0; i < ar.length; i++) {
            int n = ar[i];
            int m= (int)Math.pow(10,i);
            if (map.containsKey(n*m)){
                roman=map.get(n*m)+roman;
            }else {
                if(n>5){
                    roman="V"+roman;
                    n=n-5;
                }
                while (n!=0){
                    roman+="I";
                    n--;
                }
            }
        }
        return roman;
    }
}
