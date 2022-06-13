package dpp.grid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Link = https://leetcode.com/problems/cherry-pickup/
 *
 * @Problem = You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.
 *
 *              0 means the cell is empty, so you can pass through,
 *              1 means the cell contains a cherry that you can pick up and pass through, or
 *              -1 means the cell contains a thorn that blocks your way.
 *              Return the maximum number of cherries you can collect by following the rules below:
 *
 *          Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
 *          After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
 *          When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
 *          If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.
 *
 * @Author saurabh vaish
 * @Date 28-05-2022
 */
public class CherryPick { // not working need to  debug

    public static void main(String[] args) {
//        int [][]mat = new int[][]{{0,1,-1},{1,0,-1},{1,1,1}};
        int [][]mat = new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}};
        int row = mat.length;
        int col = mat[0].length;


        CherryPick cherryPick = new CherryPick();
        System.out.println(cherryPick.cherryPickup(mat));

        Map<String,Integer> map = new HashMap<>();
        int ans = maximumCherryPickMemoization(0,0,0,0,row,col,mat,map);
        System.out.println(Math.max(0,ans));
    }

    // instead of going from starting to end and then coming back from end to starting
    // we will start from 0 with two people , one will go from start and second will perform reverse steps

    private static int maximumCherryPickMemoization(int r1, int r2, int c1, int c2, int row, int col, int [][]mat, Map<String,Integer> dp){

        // assume two people starting picking cherry , then both will perform same no of steps
        // so r1+c1 = r2 + c2 ==> r2 = r1 + c1 -c2;  // second person row
//         r2 = r1+c1 - c2;
        // base case

        // not possible
        if(r1 == row || r2 == row || c1 == row || c2 == row || mat[r1][c1]==-1 || mat[r2][c2]==-1) return -999999; // not pick cell

        // reached 0,0 cell
        if(r1==row-1 && c1==row-1)return mat[r1][c1]; // reached last row last cell

        String key = r1+""+r2+""+c1+""+c2;
//        if(dp.containsKey(key))return dp.get(key);

//        int max = Integer.MIN_VALUE+10000;
//        int max = 0;
        int max = mat[r1][c1];

        if(c1!=c2){ // when both are not same cell
            max += mat[r2][c2]; // adding cell on previous
        }
        // now for traversing there could be 4 possibilities - a. 1d2r  b. 1d2d   c. 1r2d   d. 1r2r
        //
        int firstRightSecondRight = maximumCherryPickMemoization(r1,c1+1,r2,c2+1,row,col,mat,dp);
        int firstDownSecondRight = maximumCherryPickMemoization(r1+1,c1,r2,c2+1,row,col,mat,dp);
        int firstRightSecondDown =  maximumCherryPickMemoization(r1,c1+1,r2+1,c2,row,col,mat,dp);
        int firstDownSecondDown = maximumCherryPickMemoization(r1+1,c1,r2+1,c2,row,col,mat,dp);

        int firstStepMax = Math.max(firstDownSecondRight,firstRightSecondRight);
        int secondStepMax = Math.max(firstRightSecondDown,firstDownSecondDown);
        max = max + Math.max(firstStepMax,secondStepMax);

        dp.put(key,max);
        return max;
    }


    int[][][] memo;
    int[][] grid;
    int N;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        memo = new int[N][N][N];
        for (int[][] layer: memo) {
            for (int[] row: layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        int d = dp(0, 0, 0);
        return Math.max(0, d);
    }
    public int dp(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (N == r1 || N == r2 || N == c1 || N == c2 ||  grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -999999;
        }
        if (r1 == N-1 && c1 == N-1) {
            return grid[r1][c1];
        }
        if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
            return memo[r1][c1][c2];
        }

        int ans = grid[r1][c1];
        if (c1 != c2) ans += grid[r2][c2];
//        ans += Math.max(Math.max(dp(r1, c1+1, c2+1), dp(r1+1, c1, c2+1)),
//                Math.max(dp(r1, c1+1, c2), dp(r1+1, c1, c2)));
        int a1 = dp(r1, c1+1, c2+1);
        int a2 = dp(r1+1, c1, c2+1);
        int a3 = dp(r1, c1+1, c2);
        int a4 = dp(r1+1, c1, c2);

        int m1 = Math.max(a1,a2);
        int m2 = Math.max(a3,a4);

        ans+=Math.max(m1,m2);
        memo[r1][c1][c2] = ans;
        return ans;
    }



}
