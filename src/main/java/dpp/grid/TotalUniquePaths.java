package dpp.grid;

import java.util.HashMap;

/**
 * @Path = https://www.codingninjas.com/codestudio/problem-details/total-unique-paths_1081470
 *
 * @Problem = You are present at point ‘A’ which is the top-left cell of an M X N matrix, your destination is point ‘B’, which is the bottom-right cell of the same matrix.
 *              Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’,
 *              your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].
 *              To traverse in the matrix, you can either move Right or Down at each step.
 *              For example in a given point MATRIX[i] [j], you can move to either MATRIX[i + 1][j] or MATRIX[i][j + 1].
 *
 * @Solution -- This problem is similar to grid traveller .We will start from 0,0 and will reach to end [m-1,n-1] by going right and down and count paths . [ reverse in recusrion ]
 *
 * @Author saurabh vaish
 * @Date 19-05-2022
 */
public class TotalUniquePaths {

    public static void main(String[] args) {
        int m=3;
        int n=2;

        // m-1 , n-1  as we will traverse through index
        System.out.println(countPathMemoization(m-1,n-1,new HashMap<>()));
        System.out.println(countPathTabulation(m,n)); // here is no m-1 as n-1 as we're already iterating in loop less
        System.out.println(countPathTabulationOptimized(m,n)); // here is no m-1 as n-1 as we're already iterating in loop less

    }

    // in recursion, we follow top to bottom as we will calculate the ans by going to down from top [ last to base case ]
    // so we will start from row-1 and col-1 and will reach 0,0 by going top and left as we are calculating from top
    // time - O(2^m*n) , space - O(m+n) + dp.length
    private static int countPathMemoization(int row, int col, HashMap<String, Integer> dp) {
        // base case
        if(row==0 && col==0)return 1; // found the point
        if(row<0 || col<0) return 0; // not possible path

        String key = row+","+col;
        if(dp.containsKey(key))return dp.get(key);
        int top = countPathMemoization(row-1,col,dp);
        int left = countPathMemoization(row,col-1,dp);

        int re = top+left;
        dp.put(key,re);
        return re;
    }

    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // so we will start from 0,0 and will reach m-1,n-1 by going top and left as we are calculating from top
    // // time - O(m*n) , space - O(m*n)
    private static int countPathTabulation(int row, int col) {
        // base case
        int [][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i==0 && j==0)dp[i][j]=1; // when both is zero , point found
                else{
                    int bottom =0;int right = 0;
                   if(i>0) bottom = dp[i-1][j];
                   if(j>0) right = dp[i][j-1];
                    dp[i][j]=right+bottom;
                }
            }
        }

        return dp[row-1 ][col-1];

    }

    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // so we will start from 0,0 and will reach m-1,n-1 by going top and left as we are calculating from top
    // int this approch we are storing cols data we only need to store prev row data of cols then from temp we will manage curr row cols data
    // time - O(m*n) , space - O(col)
    private static int countPathTabulationOptimized(int row, int col) {
        // base case
        int [] prev = new int[col]; // till col as we need to worry about columns

        for (int i = 0; i < row; i++) {
            int [] curr = new int[col]; // storing cols data at each row it will get created new and previous will get store in prev
            for (int j = 0; j < col; j++) {
                if(i==0 && j==0)curr[j]=1; // when both is zero , point found
                else{
                    int bottom =0;int right = 0;
                    if(i>0) bottom = prev[j]; // previous row ans
                    if(j>0) right = curr[j-1]; // current row ans
                    curr[j]=right+bottom;
                }
            }
            prev=curr;
        }

        return prev[col-1];

    }
}
