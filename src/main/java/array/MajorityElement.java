package array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Problem = Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
 *
 * @Author saurabh vaish
 * @Date 05-09-2022
 */
public class MajorityElement {

    public static void main(String[] args) {
//        int [] ar = {2,2,1,1,2,1,2};
        int [] ar = {6,6,6,7,7};

        System.out.println(majorityUsingHashing(ar));

        System.out.println(majorityOptimalUsingMooresCount(ar));
    }

    // O(N) , O(1)
    // Moores algo --
    // since we know array has one majority elements means it will come at least N/2 time;
    // so all other element count also be N/2
    // so if x is the no of times it occurs then
    // majority count == n/2 + x;
    // minority count == n/2 - x;
    //
    //
    static int majorityOptimalUsingMooresCount(int [] ar){
        int count=0;
        int num=0;
        for (int elem:ar){
            if(count==0){  // means majority and minority have cancelled each other
                num=elem;
            }
            if (elem==num) { // if same elem increase count
                count++;
            }else count--;
        }
        return num;
    }
    
    // O(N) both
    static int majorityUsingHashing(int [] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int num = 0;
        for (int j : ar) {
            if (map.containsKey(j)) {
                int total = map.get(j) + 1;
                map.put(j, total);
                if (total > count) {
                    num = j;
                    count=total;
                }

            } else {
                map.put(j, 1);
            }
        }

        return num;
    }
}
