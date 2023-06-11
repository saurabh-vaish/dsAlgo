package general;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author saurabh vaish
 * @Date 06-09-2022
 */
public class CountUnitsInNumber {

    public static void main(String[] args) {

//        int num = 12345;
        int num = 1994;

        List<Integer> list = new ArrayList<>();
        int unit=1;

        while (num!=0){
            int rem = num%10;
            list.add(rem * unit);

            num/=10;
            unit*=10;
        }

        System.out.println(list);
    }
}
