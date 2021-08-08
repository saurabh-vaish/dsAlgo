package dpp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem == Program to find given target sum exist by adding elements of given array .
 *              Elements are non negative and can be used any number of times.
 *
 * @Solution == We will subtract each element from target sum and repeat this process until we are having final sum.
 *              check it final sum is 0 then sum exists
 *              if final sum is negative then no sum exists
 *
 * @Complexity == non optimized -  time - O(n^m) , space = O(m)
 *                optimixed   -   time - O(n * m) , space = O(m)
 *
 * @author Saurabh Vaish
 * @Date 01-08-2021
 */
public class CanFindTargetSum {

    public static void main(String[] args) {
//        int[] ar = {2,3};
        int[] ar = {7,14};
        int targetSum = 300;

//        System.out.println("sum exist = "+canSum(ar,targetSum));
        System.out.println("sum exist optimized = "+canSumOptimized(ar,targetSum,new HashMap<>()));
    }

    // complexity -- if n = array length and m = target sum
    // it will run n times untill m so time - O(n^m) , space = O(m)
    public static boolean canSum(int[] ar, int targetSum) {
        if(targetSum==0)return true;  // sum exists
        if(targetSum<0)return false; // sum does not exists

        for (var a:ar){
            var rem = targetSum-a;  // subtracting element
            if (canSum(ar, rem)) { // early check if any one returning true sum exists
                return true;
            }
        }
        return false;  // no sum exists
    }

    //  time - O(m*n) , space = O(m)
    public static boolean canSumOptimized(int[] ar, int targetSum,HashMap<Integer,Boolean> map) {
        if(targetSum==0)return true;  // sum exists
        if(targetSum<0)return false; // sum does not exists

        for (var a:ar){
            var rem = targetSum-a;  // subtracting element
            if(map.containsKey(targetSum))return map.get(targetSum);
            else {
                if (canSumOptimized(ar, rem,map)) { // early check if any one returning true sum exists
                    map.put(targetSum, true);
                    return true;
                }
            }
        }
        map.put(targetSum, false);
        return false;  // no sum exists
    }

}
