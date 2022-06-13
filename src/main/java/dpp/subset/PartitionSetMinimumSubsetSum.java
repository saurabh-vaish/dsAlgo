package dpp.subset;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
 *
 * @Problem  = Partition a set into two subsets such that the difference of subset sums is minimum , You just need to find the minimum absolute difference considering any valid division of the array elements.
 *      Note:
 *          1. Each element of the array should belong to exactly one of the subset.
 *          2. Subsets need not be contiguous always. For example, for the array : {1,2,3}, some of the possible divisions are a) {1,2} and {3}  b) {1,3} and {2}.
 *          3. Subset-sum is the sum of all the elements in that subset.
 *
 * @Complexity =
 *
 *
 * @Author saurabh vaish
 * @Date 10-06-2022
 */
public class PartitionSetMinimumSubsetSum { // ans not getting matched

    public static void main(String[] args) {

//        int [] ar = new int[]{1,2, 3, 4}; // 0
//        int [] ar = new int[]{8 ,6,5}; //3
//        int [] ar = new int[]{12,9,2,13}; // 6
        int [] ar = new int[]{0,0,0,0}; // 6
        int n = ar.length;

        System.out.println(partitionSubsetMinimumSumMemoization(ar,n));
        System.out.println(partitionSubsetMinimumSumTabulation(ar,n));
        System.out.println(partitionSubsetMinimumSumOptimized(ar,n));

    }

    // Time Complexity: O(N*totSum) +O(N) +O(N)
    // Space Complexity: O(N*totSum) + O(N)
    private static int partitionSubsetMinimumSumMemoization(int[] ar,int n){
        int totalSum = 0;
        for (int i:ar)totalSum+=i;

        boolean[][] dp = new boolean[n][totalSum+1];

        for (int i = 0; i <= totalSum; i++) {
            checkForSubsetSumTarget(ar,n-1,i,dp);
        }

        int min=Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum; i++) {
            if(dp[n-1][i]){
                min = Math.min(min,Math.abs(i-(totalSum-i)));
            }
        }

        return min;

    }


    private static boolean checkForSubsetSumTarget(int [] ar,int i,int target,boolean [][]dp){

        // base condition
        if(target==0){
            dp[i][target]=true;
            return true;
        }
        if(i==0)return target == ar[0];

        if(dp[i][target])return dp[i][target];

        boolean nontake = checkForSubsetSumTarget(ar,i-1,target,dp);
        boolean take = false;
        if(ar[i]<=target){
            take = checkForSubsetSumTarget(ar,i-1,target-ar[i],dp);
        }

        return dp[i][target]=take || nontake;
    }



    // Time Complexity:  O(N*totSum) + O(N) + O(N)
    // Space Complexity:  O(N*totSum)
    private static int partitionSubsetMinimumSumTabulation(int [] ar ,int n) {

        int totalSum = 0;
        for (int i:ar)totalSum+=i;

        boolean[][] dp = new boolean[n][totalSum + 1];

        // if target 0 return true
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (ar[0] <= totalSum) dp[0][ar[0]] = true;

        // storing into matrix
        for (int i = 1; i < n; i++) {
            for (int tar = 1; tar <= totalSum; tar++) {
                boolean nontake = dp[i - 1][tar];
                boolean take = false;
                if (tar > ar[i]) {
                    take = dp[i - 1][tar - ar[i]];
                }
                dp[i][tar] = take || nontake;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum ; i++) {
            if (dp[n - 1][i]) {
                min = Math.min(min, Math.abs(i - (totalSum - i))); // if s1 is given then s2 = total-s1 , then diff s1 - (total-s1)
            }
        }

        return min;

    }


    // Time Complexity:  O(N*totSum) + O(N) + O(N)
    // Space Complexity:  O(totSum)
    private static int partitionSubsetMinimumSumOptimized(int [] ar ,int n) {

        int totalSum = 0;
        for (int i:ar)totalSum+=i;

        boolean[] prev = new boolean[totalSum + 1];

        // if target 0 return true
        prev[0] = true;

//        if (ar[0] <= totalSum) prev[ar[0]] = true; // if  prev[4] == ar[0] , assuming ar[0] will return 4 , means data in ar at 0 is same as data index in prev

        // storing into matrix
        for (int i = 1; i < n; i++) {
            boolean [] cur = new boolean[totalSum+1];
            cur[0]=true;
            for (int tar = 1; tar <= totalSum; tar++) {
                boolean nontake = prev[tar];
                boolean take = false;
                if (tar >= ar[i]) {
                    take = prev[tar - ar[i]];
                }
                cur[tar] = take || nontake;
            }
            prev = cur;
        }

        int min = Integer.MAX_VALUE-100000;
        for (int i = 0; i <= totalSum ; i++) {
            if (prev[i]) {
                min = Math.min(min, Math.abs(i - (totalSum - i))); // if s1 is given then s2 = total-s1 , then diff s1 - (total-s1)
            }
        }

        return min;

    }

}
