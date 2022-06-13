package dpp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Link - https://www.codingninjas.com/codestudio/problems/house-robber_839733
 *
 * @Problem -- Mr. X is a professional robber planning to rob houses along a street. Each house has a certain amount of money hidden. All houses along this street are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *              You are given an array/list of non-negative integers 'ARR' representing the amount of money of each house. Your task is to return the maximum amount of money Mr. X can rob tonight without alerting the police
 *
 * @Constraints --  1 <= T <= 10
 *                  1 <= N <= 5 x 10 ^ 3
 *                  1 <= ARR[i] <= 10 ^ 9
 *
 *
 *
 * @Author saurabh vaish
 * @Date 14-05-2022
 */
public class HouseRobber {

    // the logic is same as only diff here homes are in circle so we can't take first and last element then we are calculating max while skipping first and then last element
    public static void main(String[] args) {
        int n = 1;
        int[] ar = new int[]{100};

        // if only one element return  that except 0
        if(ar.length==1) {
            System.out.println(ar[0]);
            return;
        }
//        int n = 9;
//        int[] ar = new int[]{1, 2, 3, 1, 3, 5, 8, 1, 9};

        int[] arrWithFirstElement = new int[n];
        int[] arrWithLastElement = new int[n];
        for (int i = 0; i < n; i++) {
            if(i!=0)
            arrWithFirstElement[i]=ar[i];
            if(i!=n-1)
            arrWithLastElement[i]=ar[i];
        }

        int mem1 = houseRobberMaximumNonAdjacentSumMemoization(arrWithFirstElement,n-1,new HashMap<>());
        int mem2 = houseRobberMaximumNonAdjacentSumMemoization(arrWithLastElement,n-1,new HashMap<>());
        System.out.println(Math.max(mem1,mem2));

        System.out.println("=================");

        int tab1 = houseRobberMaximumNonAdjacentSumTabulation(arrWithFirstElement,n);
        int tab2 = houseRobberMaximumNonAdjacentSumTabulation(arrWithLastElement,n);
        System.out.println(Math.max(tab1,tab2));

        System.out.println("=================");

        int tabOp1 = houseRobberMaximumNonAdjacentSumTabulationOptimized(arrWithFirstElement,n);
        int tabOp2 = houseRobberMaximumNonAdjacentSumTabulationOptimized(arrWithLastElement,n);
        System.out.println(Math.max(tabOp1,tabOp2));

    }

    // time - O(n)
    // space - O(n) + O(n) // stack + map
    public static int houseRobberMaximumNonAdjacentSumMemoization(int[] nums, int n, Map<Integer,Integer> map) {
        if(n==0)return nums[n]; // if index 0 return element
        if(n<0) return 0; // if -1 return 0 as assume 0 is max

        if(map.containsKey(n))return map.get(n);

        int take = nums[n] + houseRobberMaximumNonAdjacentSumMemoization(nums,n-2,map); // n-2 as we cant take adjacent index

        int nonTake = houseRobberMaximumNonAdjacentSumMemoization(nums,n-1,map); // not taking the element

        int max = Math.max(take,nonTake);

        map.put(n,max);
        return max;
    }


    // time - O(n)
    // space -  O(n) // ar
    public static int houseRobberMaximumNonAdjacentSumTabulation(int[] nums, int n) {
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
    public static int houseRobberMaximumNonAdjacentSumTabulationOptimized(int[] nums, int n) {
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
