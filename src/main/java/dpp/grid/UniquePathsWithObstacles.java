package dpp.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/maze-obstacles_977241
 *
 * @Problem = Given a ‘N’ * ’M’ maze with obstacles, count and return the number of unique paths to reach the right-bottom cell from the top-left cell. A cell in the given maze has a value '-1' if it is a blockage or dead-end, else 0. From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.
 *              Since the answer can be large, print it modulo 10^9 + 7.
 *
 * @Constraints = 1 <= T <= 10
 *              1 <= N,M <= 200
 *              Time Limit: 1 sec
 *
 *
 * @Author saurabh vaish
 * @Date 22-05-2022
 */
public class UniquePathsWithObstacles {

    private static int modulo = (int) (Math.pow(10,9)+7);

    public static void main(String[] args) {
//        int [][] mat = new int[][]{{0,0,0},{0,-1,0},{0,0,0}};
        int [][] mat = new int[][]{{0,0},{0,0}};
        int row = mat.length;
        int col = mat[0].length;

        System.out.println(uniquePathsMemoization(row-1,col-1,mat,new HashMap<String,Integer>()));
        System.out.println(uniquePathsTabulation(row,col,mat));
        System.out.println(uniquePathsTabulationOptimized(row,col,mat));

    }


    // in recursion, we follow top to bottom as we will calculate the ans by going to down from top [ last to base case ]
    // so we will start from row-1 and col-1 and will reach 0,0 by going top and left as we are calculating from top
    // time - O(2^m*n) , space - O(m+n) + dp.length
    private static int uniquePathsMemoization(int row, int col, int[][] mat, Map<String,Integer> dp){

        // base case
        if(row==0 && col ==0 )return 1; // found cell
        if(row<0 || col<0 || mat[row][col]==-1) return 0; // can't traverse more or obstacle found

        String key=row+","+col;
        if(dp.containsKey(key))return dp.get(key);
        int top = mat[row][col] + uniquePathsMemoization(row-1,col,mat,dp); // going up
        int left = mat[row][col] + uniquePathsMemoization(row,col-1,mat,dp); // going left

        int total = left + top;
        dp.put(key,total);
        return total%modulo;
    }



    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // so we will start from 0,0 and will reach m-1,n-1 by going top and left as we are calculating from top
    // // time - O(m*n) , space - O(m*n)
    private static int uniquePathsTabulation(int row, int col, int[][] mat){
        int [][]dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j]==-1) dp[i][j] =0; // can't traverse more or obstacle found
                else if(i==0 && j==0)dp[i][j]=1; // when both is zero , point found
                else{
                    int right = 0;int down=0;
                    if(i>0)down = dp[i-1][j];
                    if(j>0)right =dp[i][j-1];
                    dp[i][j] = (right+down)%modulo;
                }
            }
        }

        return dp[row-1][col-1];

    }


    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // so we will start from 0,0 and will reach m-1,n-1 by going top and left as we are calculating from top
    // int this approch we are storing cols data we only need to store prev row data of cols then from temp we will manage curr row cols data
    // time - O(m*n) , space - O(col)
    private static int uniquePathsTabulationOptimized(int row, int col, int[][] mat){
        int [] prev = new int[col];

        for (int i = 0; i < row; i++) {
            int [] curr = new int[col];
            for (int j = 0; j < col; j++) {
                if(mat[i][j]==-1) curr[j] =0; // can't traverse more or obstacle found
                else if(i==0 && j==0)curr[j]=1; // when both is zero , point found
                else{
                    int right = 0;int down=0;
                    if(i>0)down = prev[j]; // prev row as going down
                    if(j>0)right =curr[j-1]; // curr row as going right
                    curr[j] = (right+down)%modulo;
                }
            }
            prev=curr;
        }

        return prev[col-1];

    }

}
