package dpp.grid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/triangle_1229398
 *
 * @Problem = You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.
 *            The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.
 *              You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.
 *
 * @Constraints = 1 <= T <= 5
 *              1 <= N <= 10^3
 *              -10^6 <= TRIANGLE[i][pos] <= 10^6 ,
 *
 *              Where 'TRIANGLE[i][pos]' is the element at row = 'i' & position = 'pos' in triangle array.
 *
 *              Time limit: 1 sec
 *
 * @Complexity -- O(n*n) both
 *
 *
 * @Author saurabh vaish
 * @Date 22-05-2022
 */
public class TrianglePathSum {

    public static void main(String[] args) {
//        int [][] mat = new int[][]{{1},{2,3},{3,6,7},{8,9,6,10}};
        int [][] mat = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};

        System.out.println(triangleMinSumMemoization(0,0,mat,mat.length,new HashMap<>()));
        System.out.println(triangleMinSumTabulation(mat,mat.length));
        System.out.println(triangleMinSumTabulationOptimized(mat,mat.length));
    }

    // here in this recusion we are going from first element to last row , as in last row we can have any column element, so we are moving forwards in recursion.
    // time - O(n*n) , space- O(n*n) + dp.length
    private static int triangleMinSumMemoization(int row, int col, int[][]triangle,int len, Map<String,Integer>dp){

        if(row==len-1)return triangle[len-1][col]; // if in triangle we can choose any column

        String key = row+","+col;
        if (dp.containsKey(key))return dp.get(key);
        // as we can go only down or diagonal
        int down = triangle[row][col] + triangleMinSumMemoization(row+1,col,triangle,len,dp);
        int diagonal = triangle[row][col] + triangleMinSumMemoization(row+1,col+1,triangle,len,dp);

        int min = Math.min(down,diagonal);
        dp.put(key,min);
        return min;
    }


    // here in this recusion we are going from first element to last row , as in last row we can have any column element, so we are moving forwards in recursion.
    // time - O(n*n) , space- O(n*n) + dp.length
    private static int triangleMinSumTabulation(int[][]triangle,int len){

        // in tabulation we do reverse of recursion , since in recursion , so we will loop from n-1 to 0
        // since we need to start from last row so we will fill last row element in dp array

        int [][] dp = new int[len][];

        for (int i = 0; i < len; i++) {
            dp[i] = new int[triangle[i].length];
        }
        dp[len-1]=triangle[len-1];

        for (int i = len-2; i >=0 ; i--) { // row len-2 to first as n-1 already stored in dp

            for (int j = i; j >=0; j--) { // each row having col = row
                int down = triangle[i][j] + dp[i+1][j];
                int diagonal = triangle[i][j] + dp[i+1][j+1];

                dp[i][j]=Math.min(down,diagonal);
            }
        }

        return dp[0][0]; // as loop has reached to 0,0
    }

    // here in this recusion we are going from first element to last row , as in last row we can have any column element, so we are moving forwards in recursion.
    // time - O(n*n) , space- O(n*n) + dp.length
    private static int triangleMinSumTabulationOptimized(int[][]triangle,int len){

        // in tabulation we do reverse of recursion , since in recursion , so we will loop from n-1 to 0
        // since we need to start from last row so we will fill last row element in dp array

        int [] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i]=triangle[len-1][i];
        }

        for (int i = len-2; i >=0 ; i--) { // row len-2 to first as n-1 already stored in dp
            int [] curr = new int[len];

            for (int j = i; j >=0; j--) { // each row having col = row
                int down = triangle[i][j] + dp[j]; // dp[i+1][j]; in tab as in dp we are storing last row value and i+1 is last as loop starts from n-2
                int diagonal = triangle[i][j] + dp[j+1];

                curr[j]=Math.min(down,diagonal); // storing in curr
            }
            dp = curr;
        }

        return dp[0]; // as loop has reached to 0,0
    }


}
