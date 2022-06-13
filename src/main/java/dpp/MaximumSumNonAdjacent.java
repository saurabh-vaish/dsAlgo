package dpp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Link - https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261
 *
 * @Problem -- You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.
 *
 * @Constraints --  1 <= T <= 500
 *                  1 <= N <= 1000
 *                  0 <= ARR[i] <= 10^5
 *
 *
 *
 * @Author saurabh vaish
 * @Date 14-05-2022
 */
public class MaximumSumNonAdjacent {

    public static void main(String[] args) {
//        int n = 5;
//        int[] ar = new int[]{1, 2, 3, 5, 4};
        int n = 9;
        int[] ar = new int[]{1, 2, 3, 1, 3, 5, 8, 1, 9};

        System.out.println(maximumNonAdjacentSumMemoization(ar,n-1,new HashMap<>()));

        System.out.println("=================");

        System.out.println(maximumNonAdjacentSumTabulation(ar,n));

        System.out.println("=================");

        System.out.println(maximumNonAdjacentSumTabulationOptimized(ar,n));

    }

    // time - O(n)
    // space - O(n) + O(n) // stack + map
    public static int maximumNonAdjacentSumMemoization(int[] nums, int n, Map<Integer,Integer> map) {
        if(n==0)return nums[n]; // if index 0 return element
        if(n<0) return 0; // if -1 return 0 as assume 0 is max

        if(map.containsKey(n))return map.get(n);

        int take = nums[n] + maximumNonAdjacentSumMemoization(nums,n-2,map); // n-2 as we cant take adjacent index

        int nonTake = maximumNonAdjacentSumMemoization(nums,n-1,map); // not taking the element

        int max = Math.max(take,nonTake);

        map.put(n,max);
        return max;
    }


    // time - O(n)
    // space -  O(n) // ar
    public static int maximumNonAdjacentSumTabulation(int[] nums, int n) {
        int [] dp= new int[n+1];
        dp[0]=nums[0];

        for (int i = 1; i <n; i++) {
            int take = nums[i];
            if(i>1){
                take+= dp[i-2]; // n-2 as we cant take adjacent index
            }
            int nonTake = dp[i-1]; // not taking the element
            dp[i] = Math.max(take,nonTake);
        }
        return dp[n-1];
    }


    // time - O(n)
    // space -  O(1) // ar
    public static int maximumNonAdjacentSumTabulationOptimized(int[] nums, int n) {
        int prev=nums[0]; // ind  0
        int prev2 = 0;  // ind-2

        for (int i = 1; i <n; i++) {
            int take = nums[i];
            if(i>1){
                take+= prev2; // n-2 as we cant take adjacent index
            }
            int nonTake = prev; // not taking the element
            prev2=prev;
            prev = Math.max(take,nonTake);
        }
        return prev;
    }
}
