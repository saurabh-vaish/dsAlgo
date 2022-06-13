package dpp.grid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Path = https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?leftPanelTab=0
 *
 * @Problem =   You have been given an N*M matrix filled with integer numbers, find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.
 *              From a cell in a row, you can move to another cell directly below that row, or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.
 *              Down: (row+1,col)
 *              Down left diagonal: (row+1,col-1)
 *              Down right diagonal: (row+1, col+1)
 *
 * @Constraints --  1 <= T <= 50
 *                  1 <= N <= 100
 *                  1 <= M <= 100
 *                  -10^4 <= matrix[i][j] <= 10^4
 *
 * @Solution -- In this problem instead of going from 0,0 we have to check from every cell in first row so it will require extra step to compare max in first row .
 *
 * @Author saurabh vaish
 * @Date 22-05-2022
 */
public class MaximumPathSum {

    public static void main(String[] args) {
        int [][] mat = new int[][]{{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int row = mat.length;
        int col = mat[0].length;

        int max = Integer.MIN_VALUE;
         // since we can select any cell in first row so we will check by taking each cell one by one
        for (int firstRowCol = 0; firstRowCol < col; firstRowCol++) {
            max = Math.max(max,maximumPathsMemoization(row-1,firstRowCol,mat,new HashMap<String,Integer>()));
        }

        System.out.println(max);

        System.out.println(minimumPathsTabulation(row,col,mat));
        System.out.println(minimumPathsTabulationOptimized(row,col,mat));

    }


    // in recursion, we follow top to bottom as we will calculate the ans by going to down from top [ last to base case ]
    // so we will start from row-1 and col-1 and will reach 0,0 by going top and left as we are calculating from top
    // time - O(m*n) , space - O(m+n) + dp.length
    private static int maximumPathsMemoization(int row, int col, int[][] mat, Map<String,Integer> dp) {

        // base case
        if (col<0 || col >= mat[0].length)
            return 0;   //Integer.MIN_VALUE; // can't traverse more or obstacle found , static value as we can't take Integer.Max and row can have 10^5 max

        if (row == 0 ) return mat[0][col]; // as can select any cell in first row

        String key = row + "," + col;
        if (dp.containsKey(key)) return dp.get(key);
        // going up
        int up = mat[row][col] + maximumPathsMemoization(row - 1, col, mat, dp); // going up
        // going left diagonal
        int leftDg = mat[row][col] + maximumPathsMemoization(row-1, col - 1, mat, dp); // going left
        // going right diagonal
        int rightDg = mat[row][col] + maximumPathsMemoization(row-1, col + 1, mat, dp); // going right

        int max = Math.max(up, Math.max(leftDg,rightDg));
        dp.put(key, max);
        return max;
    }



    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // so we will start from 0,0 and will reach m-1,n-1 by going top and left as we are calculating from top
    // // time - O(m*n)+O(n) , space - O(n*m)
    private static int minimumPathsTabulation(int row, int col, int[][] mat){
        int [][]dp = new int[row][col];

        for (int j = 0; j < col; j++) {
            dp[0][j] = mat[0][j];  // filling first row in dp as in recursion we have gone from last row so here we will start from first
        }

        int max = Integer.MIN_VALUE+10000;

        for (int i = 1; i < row; i++) { // as 0 already covered
            for (int j = 0; j < col; j++) {
                // going down
                int down = mat[i][j] + dp[i - 1][j]; // going up
                // going left diagonal
                int leftDg = mat[i][j] ;
                if(j-1>=0)leftDg += dp[i-1] [j - 1]; // going left
                else leftDg = max;
                // going right diagonal
                int rightDg = mat[i][j];
                if(j+1<col)rightDg += dp[i-1][j +1]; // going right
                else rightDg = max;
                dp[i][j]= Math.max(down, Math.max(leftDg,rightDg));

            }
        }

        // taking max in all cell in last row
        for (int j = 0; j < col; j++) {
            max = Math.max(max,dp[row-1][j]);
        }

        return max;

    }


    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // int this approach we are storing cols data we only need to store prev row data of cols then from temp we will manage curr row cols data
    // time - O(m*n)+O(n) , space - O(col)
    private static int minimumPathsTabulationOptimized(int row, int col, int[][] mat){
        int [] prev = new int[col];

        for (int j = 0; j < col; j++) {
            prev[j] = mat[0][j];  // filling first row in dp as in recursion we have gone from last row so here we will start from first
        }

        int max = Integer.MIN_VALUE+10000;

        for (int i = 1; i < row; i++) { // as 0 already covered
            int [] curr = new int[col];
            for (int j = 0; j < col; j++) {
                // going down
                int down = mat[i][j] + prev[j]; // going up
                // going left diagonal
                int leftDg = mat[i][j] ;
                if(j-1>=0)leftDg += prev[j - 1]; // going left
                else leftDg = max;
                // going right diagonal
                int rightDg = mat[i][j];
                if(j+1<col)rightDg += prev[j +1]; // going right
                else rightDg = max;
                curr[j]= Math.max(down, Math.max(leftDg,rightDg));

            }
            prev=curr;
        }

        // taking max in all cell in last row
        for (int j = 0; j < col; j++) {
            max = Math.max(max,prev[j]);
        }

        return max;

    }

}
