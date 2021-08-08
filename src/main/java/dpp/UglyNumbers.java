package dpp;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Problem  == Find the nth ugly number .
 *
 * @Solution == Ugly number are those numbers who are divided by 2,3 or 5 including 1 . e.g. - 1,2,3,4,5,6,8,9,10,12 etc
 *             dpp apprach ==
 *                      create a array to store ugly no
 *                      int first element 1 as 1 is ugly no
 *                      int three variable i2,i3,i5 to 0 for 2,3,5
 *                      will get multiple of 2 , 3 ,5 and store in array based on i2,i3,i5 index
 *                      loop till nth no
 *                      get min in multiple of 2,3,5 and store as ugly no
 *                      increase i2,i3,i5 based on multiple of 2,3,5
 *
 * @author Saurabh Vaish
 * @Date 06-07-2021
 */
public class UglyNumbers {

    public static void main(String[] args) {
        int n=150;

        int uglyNumber1 = getUglyNumberUsingDpp(n);
        System.out.println(uglyNumber1);
        long uglyNumber2 = getUglyNumberUsingTreeSet(n);
        System.out.println(uglyNumber2);
    }


    // dpp approch time,space - O(n)
    private static int getUglyNumberUsingDpp(int n) {
        int ar[]=new int[n];
        ar[0]=1;
        int i2=0,i3=0,i5=0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        for (int i = 1; i <n ; i++) {
            next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
            ar[i]=next_ugly_no;
            if(next_ugly_no==next_multiple_of_2){
                i2=i2+1;
                next_multiple_of_2 = ar[i2]*2;
            }
            if(next_ugly_no==next_multiple_of_3){
                i3=i3+1;
                next_multiple_of_3 = ar[i3]*3;
            }
            if(next_ugly_no==next_multiple_of_5){
                i5=i5+1;
                next_multiple_of_5 = ar[i5]*5;
            }

        }
        return next_ugly_no;
    }

    // using treeset  time - O(NlogN) , space - O(n)
    private static long getUglyNumberUsingTreeSet(int n) {
        TreeSet<Long> set = new TreeSet<>();
        int i=1;
        set.add(1L);
        while (i<n){
            long temp = set.pollFirst(); // will return the min in set
            set.add(temp*2);
            set.add(temp*3);
            set.add(temp*5);
            i++;
        }
        return set.pollFirst();
    }
}
