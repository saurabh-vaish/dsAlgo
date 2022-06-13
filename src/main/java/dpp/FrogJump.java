package dpp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Link = https://www.codingninjas.com/codestudio/problem-details/frog-jump_3621012
 * @Problem = There is a frog on the 1st step of an N stairs long staircase. The frog wants to reach the Nth stair. HEIGHT[i] is the height of the (i+1)th stair.
 *              If Frog jumps from ith to jth stair, the energy lost in the jump is given by |HEIGHT[i-1] - HEIGHT[j-1] |.In the Frog is on ith staircase, he can jump either to (i+1)th stair or to (i+2)th stair.
 *              Your task is to find the minimum total energy used by the frog to reach from 1st stair to Nth stair.
 *
 * @Example = If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
 *
 * @Constraints =   1 <= T <= 10
 *                  1 <= N <= 100000.
 *                  1 <= HEIGHTS[i] <= 1000 .
 *
 *                  Time limit: 1 sec
 *
 * @Author saurabh vaish
 * @Date 14-05-2022
 */
public class FrogJump {

    public static void main(String[] args) {
        int n = 4;
        int heights []= new int[]{10, 20, 30, 10};
//        int n = 8;
//        int heights []= new int[]{7 ,4 ,4 ,2 ,6 ,6 ,3 ,4 };
        System.out.println(frogJumpMemoization(n-1,heights,new HashMap<Integer,Integer>())); // taking n-1 as height arr starts from 0

        System.out.println("===============");

        System.out.println(frogJumpTabulation(n-1,heights)); // taking n-1 as height arr starts from 0

        System.out.println("===============");

        System.out.println(frogJumpTabulationOptimized(n-1,heights)); // taking n-1 as height arr starts from 0
    }

    // Time == O(n)
    // space == O(n) + O(n) // stack + map
    public static int frogJumpMemoization(int n, int heights[], Map<Integer,Integer>map) {

        if(n==0)return 0; // as min energy 0-0 is 0

        if(map.containsKey(n))return map.get(n); // memoization

        int first = frogJumpMemoization(n-1,heights,map) + Math.abs(heights[n]-heights[n-1]); // calculating energy on first stair from stair [ i+1 ]
        int second = Integer.MAX_VALUE;
        if(n>1){
            second= frogJumpMemoization(n-2,heights,map) + Math.abs(heights[n]-heights[n-2]); // // calculating energy on second stair from stair [ i+2 ]
        }
        int min = Math.min(first,second);
        map.put(n,min);

        return min;

    }


    // Time == O(n)
    // space == O(n) //  array
    public static int frogJumpTabulation(int n, int[] heights) {

        int[] dp = new int[n+1];
        dp[0]=0;    // as min energy 0-0 is 0
        for (int i = 1; i < heights.length; i++) {
            int first = dp[i-1] + Math.abs(heights[i]-heights[i-1]); // calculating energy on first stair from stair [ i+1 ]
            int second = Integer.MAX_VALUE;
            if(i>1){
                second= dp[i-2]+ Math.abs(heights[i]-heights[i-2]); // // calculating energy on second stair from stair [ i+2 ]
            }
            dp[i] = Math.min(first,second);
        }
        return dp[n];
    }

    // Time == O(n)
    // space == O(1) //  array tabulation
    public static int frogJumpTabulationOptimized(int n, int[] heights) {

        int prev = 0;   // as min energy 0-0 is 0 [ i-1 ]
        int prev2 = 0; // as as previous is considering as 0 energy [ i-2 ]
        for (int i = 1; i < heights.length; i++) {
            int first = prev + Math.abs(heights[i]-heights[i-1]); // calculating energy on first stair from stair [ i+1 ]
            int second = Integer.MAX_VALUE;
            if(i>1){
                second= prev2+ Math.abs(heights[i]-heights[i-2]); // // calculating energy on second stair from stair [ i+2 ]
            }
            int min = Math.min(first,second);
            prev2=prev;
            prev=min;
        }
        return prev;
    }
}
