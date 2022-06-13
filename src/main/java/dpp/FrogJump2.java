package dpp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem = There is a frog on the 1st step of an N stairs long staircase. The frog wants to reach the Nth stair. HEIGHT[i] is the height of the (i+1)th stair.
 *              If Frog jumps from ith to jth stair, the energy lost in the jump is given by |HEIGHT[i-1] - HEIGHT[j-1] |.In the Frog is on ith staircase, he can jump to kth stair
 *              Your task is to find the minimum total energy used by the frog to reach from 1st stair to Nth stair.
 *
 *
 * @Constraints =   1 <= T <= 10
 *                  1 <= N <= 100000.
 *                  1 <= HEIGHTS[i] <= 1000 .
 *                  1 <= k <=n
 *                  Time limit: 1 sec
 *
 * @Author saurabh vaish
 * @Date 14-05-2022
 */
public class FrogJump2 {

    public static void main(String[] args) {
        int k=2;
//        int n = 4;
//        int heights []= new int[]{10, 20, 30, 10};
        int n = 8;
        int heights []= new int[]{7 ,4 ,4 ,2 ,6 ,6 ,3 ,4 };
        System.out.println(frogJumpMemoization(n-1,heights,k,new HashMap<Integer,Integer>())); // taking n-1 as height arr starts from 0

        System.out.println("===============");

        System.out.println(frogJumpTabulation(n-1,heights,k)); // taking n-1 as height arr starts from 0

    }

    // Time == O(n)
    // space == O(n) *k  // stack * step
    public static int frogJumpMemoization(int n, int heights[],int k, Map<Integer,Integer>map) {

        if(n==0)return 0; // as min energy 0-0 is 0

        if(map.containsKey(n))return map.get(n); // memoization

        int jumpSteps = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if(n-j>=0){
                jumpSteps = frogJumpMemoization(n-j,heights,k,map) + Math.abs(heights[n]-heights[n-j]); // calculating energy on first stair from stair [ i+1 ]
            }
            min = Math.min(min,jumpSteps);
        }
        map.put(n,min);

        return min;

    }


    // Time == O(n)
    // space == O(n * k) //  array
    public static int frogJumpTabulation(int n, int[] heights,int k) {

        int[] dp = new int[n+1];
        dp[0]=0;    // as min energy 0-0 is 0
        for (int i = 1; i < heights.length; i++) {
            int jumpSteps = Integer.MAX_VALUE;
            int min=Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if(i-j>=0){
                    jumpSteps= dp[i-j] + Math.abs(heights[i]-heights[i-j]); // calculating energy on first stair from stair [ i+1 ]
                    min = Math.min(min,jumpSteps);
                }
            }
            dp[i]=min;
        }
        return dp[n];
    }

    // no tabulation as we need k variables to hold values
}
