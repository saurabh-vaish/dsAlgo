package dpp.subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Link  = https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980
 *
 * @Problem = You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.
 * For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.
 *
 * @Constraints =   1 <= 'T' <= 10
 *                  1 <= 'N' <= 100
 *                  1 <= 'ARR'[i] <= 100
 *
 * @Complexity  =
 *
 * Time Limit: 1 sec
 *
 * @Author saurabh vaish
 * @Date 08-06-2022
 */
public class PartialSumSubset {

    public static void main(String[] args) {
//        int [] ar = new int[]{2, 3, 3, 3, 4, 5};
//        int [] ar = new int[]{5, 6, 5, 11, 6};
//        int [] ar = new int[]{3, 1, 1, 2,2,1};
        int [] ar = new int[]{1, 6, 11, 6};
        int n = ar.length;

        System.out.println(checkForPartialSum(ar,n));
    }

//     complexity ==O(n) + com of solu .
    static boolean checkForPartialSum(int [] ar, int n){
        int totalSum=0;
        for (int j : ar) {
            totalSum += j;
        }
        if(totalSum%2!=0)return false;
        int target = totalSum/2;

//        System.out.println(findSubarray(ar,target));

        return checkForPartialSumMemoization(ar,n-1,target,new HashMap<>());
//        return checkForPartialSumTabulation(ar,target);
//        return checkForPartialSumTabulationOptimized(ar,target);
    }

    // Time Complexity: O(N*K) --  There are N*K states therefore at max ‘N*K’ new problems will be solved.
    //Space Complexity: O(N*K) + O(N) ==  We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
    private static boolean checkForPartialSumMemoization(int[] ar, int i, int target, Map<String,Boolean> dp) {
        if(target==0)return true;
        if(i==0)return ar[0]==target;

        String key = i+","+target;

        if(dp.containsKey(key))return dp.get(key);

        boolean notTake = checkForPartialSumMemoization(ar,i-1,target,dp);
        boolean take = false;
        if(target>ar[i]){
            take = checkForPartialSumMemoization(ar,  i-1, target-ar[i],dp);
        }

        boolean res = take || notTake;
        dp.put(key,res);

        return res;

    }


    // Time Complexity: O(N*K) == There are two nested loops
    //Space Complexity: O(N*K) == We are using an external array of size ‘N*K’. Stack Space is eliminated.
    private static boolean checkForPartialSumTabulation(int[] ar, int target) {
        int n =ar.length;
        boolean [][] dp = new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0]=true;
        }

        if(ar[0]<=target){
            dp[0][ar[0]]=true;
        }

        for (int i = 1; i <n ; i++) {
            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = dp[i-1][tar];
                boolean take = false;
                if(tar>ar[i]){
                    take = dp[ i-1][tar-ar[i]];
                }

                dp[i][tar] = take || notTake;

            }
        }

        return dp[n-1][target];

    }


    //Time Complexity: O(N*K) =  There are three nested loops
    //Space Complexity: O(K) = We are using an external array of size ‘K+1’ to store only one row.
    private static boolean checkForPartialSumTabulationOptimized(int[] ar, int target) {
        int n =ar.length;
        boolean [] prev = new boolean[target+1];

        if(ar[0]<=target){
            prev[ar[0]]=true;
        }

        for (int i = 1; i <n ; i++) {
            boolean [] curr = new boolean[target+1];
            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = prev[tar];
                boolean take = false;
                if(tar>ar[i]){
                    take = prev[tar-ar[i]];
                }

                curr[tar] = take || notTake;

            }
            prev = curr;
        }

        return prev[target];

    }

    // O(n)
//    public static boolean findSubarray(int[] nums, int target)
//    {
//        Map<Integer, Integer> map = new HashMap<>();
//
//        // insert (0, -1) pair into the set to handle the case when a subarray with the given sum starts from index 0
//        map.put(0, -1);
//
//        // keep track of the sum of elements so far
//        int sum_so_far = 0;
//
//        // traverse the given array
//        for (int i = 0; i < nums.length; i++)
//        {
//            // update `sum_so_far`
//            sum_so_far += nums[i];
//
//            // if `sum_so_far - target` is seen before, we have found
//            // the subarray with sum equal to `target`
//            if (map.containsKey(sum_so_far - target))
//            {
//                System.out.println("Subarray found [" +
//                        (map.get(sum_so_far - target) + 1) +
//                        "–" + i + "]");
//                return true;
//            }
//
//            // insert (current sum, current index) pair into the map
//            map.put(sum_so_far, i);
//        }
//        return false;
//    }


}
