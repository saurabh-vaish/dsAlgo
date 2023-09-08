package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Link = https://www.codingninjas.com/studio/problems/distinct-island_630460
 *
 * You are given a two-dimensional array/list of integers consisting of 0s and 1s. In the list, 1 represents land and 0 represents water.
 * The task is to find the number of distinct islands where a group of connected 1s(horizontally or vertically) forms an island.
 * Two islands are considered to be the same if and only if one island is equal to another(not rotated or reflected)
 * i.e if we can translate one island on another without rotating or reflecting then it would be considered as the same islands.
 *
 * @Author saurabh vaish
 * @Date 21-07-2023
 */
public class Graph12_DistinctIslands {

    // O(n * m) + O(n * m * 4)
    // since two islands are only identical if they have same position in grid
    // we can use dfs to traverse the grid but need to make sure ,we are traversing same directions in each time
    // we can store coords in set and in last can have all unique islands
    public static int distinctIsland(int [][] arr, int n, int m)
    {
        boolean[][] vis = new boolean[n][m];

        // all possible directions
        int [] delr = {-1,0,1,0};
        int [] delc = {0,1,0,-1};

        Set<ArrayList<String>> set = new HashSet<>();

        // O(n * m)
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && arr[i][j]==1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,arr,delr,delc,list,i,j);
                    set.add(list);
                }
            }
        }

        return set.size();

    }

    // O(n * m * 4)
    private static void dfs(int row,int col,boolean[][] vis, int[][] arr, int[] delr, int[] delc, ArrayList<String> list, int baseRow, int baseCol) {
        vis[row][col]=true;

        // baserow - currentrow , baseCol - currentCol ==> to form coordinates
        // since we are storing the differences so we will get same diff coordinates on grid
        list.add((row-baseRow) + " "+ (col-baseCol));

        int r = arr.length;
        int c = arr[0].length;

        for(int i=0;i<4;i++){
            int nr = row + delr[i];
            int nc = col + delc[i];

            if(nr>=0 && nr<r && nc>=0 && nc<c && !vis[nr][nc] && arr[nr][nc]==1){
                dfs(nr,nc,vis,arr,delr,delc,list,baseRow,baseCol);
            }
        }

    }

    public static void main(String[] args) {
        int [][] mat=  {{0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 1, 0, 0},
                        {1, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1}};

        System.out.println(distinctIsland(mat,5,6));


    }

}
