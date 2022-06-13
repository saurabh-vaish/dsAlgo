package dpp.subset;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954
 *
 * @Problem = You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
 * Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
 *
 *
 * @Author saurabh vaish
 * @Date 31-05-2022
 */
public class SubSetSumTarget {

    public static void main(String[] args) {

        int [] ar = new int[]{4,3,2,1};
//        int [] ar = new int[]{2,5,1,6,7};
        int target = 5;
        int [][] dp = new int[ar.length+1][target+1];
        for (int i = dp.length - 1; i >= 0; i--) {
            Arrays.fill(dp[i],-1);
        }

        System.out.println(subSetSumMemoization(0,ar,target,dp));
        System.out.println(subSetSumTabulation(ar,target));
        System.out.println(subSetSumTabulationOptimized(ar,target));

    }

    // Time Complexity: O(N*K) --  There are N*K states therefore at max ‘N*K’ new problems will be solved.
    //
    //Space Complexity: O(N*K) + O(N) ==  We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
    private static boolean subSetSumMemoization(int i, int[] ar, int target,int [][]dp) {
        // base condition
        if(target==0)return true;
        if(i==ar.length-1)return target==ar[i];

        if(dp[i][target]!=-1)return dp[i][target]==1;
        // not take
        boolean notTake = subSetSumMemoization(i+1,ar,target,dp);
        // take
        boolean take = false;
        if(target>=ar[i]) {
            take = subSetSumMemoization(i + 1, ar, target - ar[i],dp);
        }
        boolean isTake = take || notTake;
        dp[i][target] = isTake?1:0;
        return isTake;
    }


    // Time Complexity: O(N*K) == There are two nested loops
    //
    //Space Complexity: O(N*K) == We are using an external array of size ‘N*K’. Stack Space is eliminated.
    private static boolean subSetSumTabulation(int[] ar, int target) {
        int n = ar.length;
        // base condition
        boolean [][] dp = new boolean[n][target+1];
        for (int i = 0; i <n; i++) {
            dp[i][0]=true; // when target is zero return true
        }

        if(ar[0]<=target)
            dp[0][ar[0]]=true;  // if(i==0)return target==ar[i]; ,it will be true iff index is 0 and target == element at 0

        for(int ind = 1; ind<n; ind++){
            for(int tar= 1; tar<=target; tar++){

                boolean notTaken = dp[ind-1][tar];

                boolean taken = false;
                if(ar[ind]<=tar)
                    taken = dp[ind-1][tar-ar[ind]];

                dp[ind][tar]= notTaken||taken;

            }
        }

        return dp[n-1][target];

    }


    //Time Complexity: O(N*K) =  There are three nested loops
    //Space Complexity: O(K) = We are using an external array of size ‘K+1’ to store only one row.
    private static boolean subSetSumTabulationOptimized(int[] ar, int target) {
        int n = ar.length;
        // base condition
        boolean [] prev = new boolean[target+1];

        prev[0] = true; // if target is 0 then true

        if(ar[0]<=target)
            prev[ar[0]]=true;  // if(i==0)return target==ar[i]; ,it will be true iff index is 0 and target == element at 0

        for(int ind = 1; ind<n; ind++){

            boolean [] cur=new boolean[target+1];
            cur[0] = true;
            for(int tar= 1; tar<=target; tar++){

                boolean notTaken = prev[tar];

                boolean taken = false;
                if(ar[ind]<=tar)
                    taken = prev[tar-ar[ind]];

                cur[tar]= notTaken||taken;

            }
            prev = cur;
        }

        return prev[target];

    }

}
