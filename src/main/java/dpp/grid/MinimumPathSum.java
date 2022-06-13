package dpp.grid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Path = https://www.codingninjas.com/codestudio/problems/minimum-path-sum_985349?topList=striver-sde-sheet-problems
 *
 * @Problem = Ninjaland is a country in the shape of a 2-Dimensional grid 'GRID', with 'N' rows and 'M' columns. Each point in the grid has some cost associated with it.
 *              Find a path from top left i.e. (0, 0) to the bottom right i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the cost of all the numbers along the path. You need to tell the minimum sum of that path.
 *          Note:  You can only move down or right at any point in time.
 *
 * @Constraints -- 1 <= T <= 100
 *                  1 <= N, M <= 10^2
 *                  1 <= GRID[i][j] <= 10^5
 *
 *              Where 'GRID[i][j]' denotes the value of the cell in the matrix.
 *
 *              Time limit: 1 sec
 *
 * @Solution -- This problem is similar to grid traveller .We will start from 0,0 and will reach to end [m-1,n-1] by going right and down and count paths . [ reverse in recusrion ]
 *
 * @Author saurabh vaish
 * @Date 22-05-2022
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int [][] mat = new int[][]{{1,2,3},{4,5,4},{7,5,9}};
        int row = mat.length;
        int col = mat[0].length;

        System.out.println(minimumPathsMemoization(row-1,col-1,mat,new HashMap<String,Integer>()));
        System.out.println(minimumPathsTabulation(row,col,mat));
        System.out.println(minimumPathsTabulationOptimized(row,col,mat));

    }


    // in recursion, we follow top to bottom as we will calculate the ans by going to down from top [ last to base case ]
    // so we will start from row-1 and col-1 and will reach 0,0 by going top and left as we are calculating from top
    // time - O(m*n) , space - O(m+n) + dp.length
    private static int minimumPathsMemoization(int row, int col, int[][] mat, Map<String,Integer> dp) {

        // base case
        if (row == 0 && col == 0) return mat[row][col]; // found cell
        if (row < 0 || col < 0)
            return 100000001; // can't traverse more or obstacle found , static value as we can't take Integer.Max and row can have 10^5 max

        String key = row + "," + col;
        if (dp.containsKey(key)) return dp.get(key);
        int up = mat[row][col] + minimumPathsMemoization(row - 1, col, mat, dp); // going up
        int left = mat[row][col] + minimumPathsMemoization(row, col - 1, mat, dp); // going left

        int min = Math.min(up, left);
        dp.put(key, min);
        return min;
    }



    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // so we will start from 0,0 and will reach m-1,n-1 by going top and left as we are calculating from top
    // // time - O(m*n) , space - dp.length
    private static int minimumPathsTabulation(int row, int col, int[][] mat){
        int [][]dp = new int[row][col];
        int max=100000001;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i==0 && j==0)dp[i][j]=mat[i][j]; // when both is zero , point found
                else{
                    int right = mat[i][j];
                    int down= mat[i][j];
                    if(i>0)down += dp[i-1][j];
                    else down +=max;  // as path not possible

                    if(j>0)right +=dp[i][j-1];
                    else right +=max; // path not possible

                    dp[i][j] = Math.min(right,down);
                }
            }
        }

        return dp[row-1][col-1];

    }


    // in tabulation, we follow bottom-up as we will calculate the ans by going to top from bottom [ start to end ]
    // so we will start from 0,0 and will reach m-1,n-1 by going top and left as we are calculating from top
    // int this approch we are storing cols data we only need to store prev row data of cols then from temp we will manage curr row cols data
    // time - O(m*n) , space - O(col)
    private static int minimumPathsTabulationOptimized(int row, int col, int[][] mat){
        int [] prev = new int[col];
        int max=100000001;
        for (int i = 0; i < row; i++) {
            int [] curr = new int[col];
            for (int j = 0; j < col; j++) {
                if(i==0 && j==0)curr[j]=mat[i][j]; // when both is zero , point found
                else{
                    int right = mat[i][j];
                    int down= mat[i][j];

                    if(i>0)down += prev[j]; // prev row as going down
                    else down +=max;  // as path not possible

                    if(j>0)right +=curr[j-1]; // curr row as going right
                    else right +=max;  // as path not possible

                    curr[j] = Math.min(right,down);
                }
            }
            prev=curr;
        }

        return prev[col-1];

    }

}
