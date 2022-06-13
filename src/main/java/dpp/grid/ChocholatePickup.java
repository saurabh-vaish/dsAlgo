package dpp.grid;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Link = https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885
 *
 * @Problem = Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends.
 *              Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid. Each of them can move from their current cell to the cells just below them. When anyone passes from any cell, he will pick all chocolates in it, and then the number of chocolates in that cell will become zero. If both stay in the same cell, only one of them will pick the chocolates in it.
 *              If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the ‘GRID’.
 *              Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules.
 *
 * @Constraints = 1 <= ‘T’ <= 10
 *              2 <= 'R', 'C' <= 50
 *              0 <= 'GRID[i][j]'<= 10^2
 *              Time Limit: 1sec
 *
 *
 *
 *
 * @Author saurabh vaish
 * @Date 27-05-2022
 */
public class ChocholatePickup {

    public static void main(String[] args) {
        int [][] mat = new int[][]{{2,3,1,2},{3,4,2,2},{5,6,3,5}};
//        int [][] mat = new int[][]{{1,1},{1,2}};
        int row = mat.length;
        int col = mat[0].length;

        // since alice and bob both are traversing together ,so they will go to same row but diff cells so we are taking 2 col values one for alice and another for bob
        // alice will start from 0 so 0 and bob  will start from right col sol col-1
        System.out.println(maximumChocolatesMemoization(0,0,col-1,row,col,mat,new HashMap<>()));
        System.out.println(maximumChocolateTabulation(row,col,mat));
        System.out.println(maximumChocolateTabulationOptimized(row,col,mat));

    }

    // time come -- O(3^n * 3^n) == expo  , space = O(n * m * m) + dp.length
    public static int maximumChocolatesMemoization(int i, int alicej, int bobj, int r, int c, int[][] mat, Map<String,Integer> dp) {
        // base case
        // check boundry condtn
        if( alicej<0 || alicej>=c || bobj<0 || bobj>=c)return Integer.MIN_VALUE+10000; // as we need to reject this value so we need to choose max

        // when its reaching the destination i.e. the last row then we can have any cell
        if(i==r-1){ // reached last row
            if(alicej==bobj){ // both reached to same cell then just return that cell
                return mat[i][alicej];
            }else{ // they are not on same cell so return sum of them
                return mat[i][alicej] + mat[i][bobj];
            }
        }

        // explore all path
        // as we need to traverse both same time and for each cell alice traverse both will traverse 3 so there will be 9 combo

        String key = i+","+alicej+","+bobj;
        if(dp.containsKey(key))return dp.get(key);

        int max = Integer.MIN_VALUE+10000;
        for (int dj1 = -1; dj1 <= +1 ; dj1++) {
            for (int dj2 = -1; dj2 <= +1; dj2++) {
                int value=0;
                if(dj1==dj2) value = mat[i][alicej]; // same cell so return any
                else value = mat[i][alicej] + mat[i][bobj]; // sum of alice and bob cell

                value += maximumChocolatesMemoization(i+1,alicej+dj1,bobj+dj2,r,c,mat,dp); // recursion call
                max = Math.max(max,value); // getting max in cell
            }
        }

        dp.put(key,max);

        return max;
    }

    // time come -- O(n * m * m) == expo  , space = O(m * m * n)
    public static int maximumChocolateTabulation(int r,int c, int[][] mat){
        // dp[r][c][c]
        int[][][] dp = new int[r][c][c];

        // since we have done recursion from first row so we will start from last row 
        // so need to fill data in last row first

        // base case
        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if(j1==j2) dp[r-1][j1][j2] = mat[r-1][j1]; // same cell so return any
                else dp[r-1][j1][j2]  = mat[r-1][j1] + mat[r-1][j2];
            }
        }

        // since we already covered last row so we will go from r-2 to 0
        for (int row = r-2; row >=0 ; row--) { // for recursion

            for (int alicej = 0; alicej < c ; alicej++) { // alice cells
                for (int bobj = 0; bobj < c; bobj++) { // bob traversal
                    int max = Integer.MIN_VALUE+10000;

                    for (int dj1 = -1; dj1 <= +1 ; dj1++) {
                        for (int dj2 = -1; dj2 <= +1; dj2++) {

                            int value = 0;
                            if (alicej == bobj) value = mat[row][alicej]; // same cell so return any
                            else value = mat[row][alicej] + mat[row][bobj]; // sum of alice and bob cell

                            if(alicej + dj1>=0 && alicej + dj1<c && bobj + dj2>=0 && bobj + dj2 <c) {
                                value += dp[row + 1][alicej + dj1][bobj + dj2]; // recursion call
                            }else{
                                value += Integer.MIN_VALUE+10000;
                            }
                            max = Math.max(max, value); // getting max in cell
                        }
                    }
                    dp[row][alicej][bobj]=max;
                }
            }
        }
        

        return dp[0][0][c-1];
    }

    // time come -- O(n * m * m) == expo  , space = O(m * m)
    public static int maximumChocolateTabulationOptimized(int r,int c, int[][] mat){
        // dp[r][c][c]
        // in normal optimization we go from 2d from 1d so in this we wil go from 3d to 2d space
        // dp[aliceCol][bobCol]
        int[][] frontDp = new int[c][c];


        // since we have done recursion from first row so we will start from last row
        // so need to fill data in last row first

        // base case
        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if(j1==j2) frontDp[j1][j2] = mat[r-1][j1]; // same cell so return any
                else frontDp[j1][j2]  = mat[r-1][j1] + mat[r-1][j2];
            }
        }

        // since we already covered last row so we will go from r-2 to 0
        for (int row = r-2; row >=0 ; row--) { // for recursion
            int [][] currDp = new int[c][c];

            for (int alicej = 0; alicej < c ; alicej++) { // alice cells
                for (int bobj = 0; bobj < c; bobj++) { // bob traversal

                    int max = Integer.MIN_VALUE+10000;
                    for (int dj1 = -1; dj1 <= +1 ; dj1++) { // alice has 3 choices
                        for (int dj2 = -1; dj2 <= +1; dj2++) { // on each alice choice , bob has 3 choices

                            int value = 0;
                            if (alicej == bobj) value = mat[row][alicej]; // same cell so return any
                            else value = mat[row][alicej] + mat[row][bobj]; // sum of alice and bob cell

                            if(alicej + dj1>=0 && alicej + dj1<c && bobj + dj2>=0 && bobj + dj2 <c) {
                                value += frontDp[alicej + dj1][bobj + dj2]; // recursion call
                            }else{
                                value += Integer.MIN_VALUE+10000;
                            }
                            max = Math.max(max, value); // getting max in cell
                        }
                    }
                    currDp[alicej][bobj]=max;
                }
            }
            frontDp = currDp;
        }


        return frontDp[0][c-1];
    }



}
