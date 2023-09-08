package graph;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @Link = https://www.codingninjas.com/studio/problems/find-number-of-islands_630512?topList=striver-sde-sheet-problems&leftPanelTab=1
 *
 * you-are-given-a-2-dimensional-array-list-having-n-rows-and-m-columns-which-is-filled-with-ones-1-and-zeroes-0-1-signifies-land-and-0-signifies-water
 *
 * A cell is said to be connected to another cell, if one cell lies immediately next to the other cell, in any of the eight directions (two vertical, two horizontal, and four diagonals).
 *
 * A group of connected cells having value 1 is called an island. Your task is to find the number of such islands present in the matrix.
 *
 * @Author saurabh vaish
 * @Date 16-07-2023
 */



class Pair{
    int row;
    int col;

    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

public class Graph4_NoOf_Islaands_Or_ConnectedComponents {


    // Time = O(n * m ) + O(V ^ 2)
    // to count islands , we can either create adjacency matrix first then we can do dfs / bfs and count it
    // or we can traverse directly mat and do bfs when islands found and directly count them
    public static int noOfIslands(int [][] grid){

        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int count=0;

        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !visited[i][j]){  // not visited and there is land on position
                    count++;
                    bfs(grid,visited,i,j);
                }
            }
        }

        return count;
    }

    // O(n*m)
    // traverse matrix using bfs
    private static void bfs(int[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col]=true;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));  // starting point for traverse

        int gridRowSize = grid.length;
        int gridColSize = grid[0].length;

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int r = pair.row;
            int c = pair.col;

            // traverse all the neighbours
            // for from any node we can go in any eight direction but the row , col we can traverse is from -1 to 1 , as previous row , current row , current col and same in col
            for(int delRow=-1;delRow<=1;delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nrow = r + delRow;
                    int ncol = c + delCol;

                    if(nrow >=0 && nrow < gridRowSize && ncol>=0 && ncol<gridColSize && !visited[nrow][ncol]
                     && grid[nrow][ncol]==1) { // row and col are not exceeding and island is present on coordinate
                        visited[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        int m = 4, n=5;
        int g[][] = {{0,1,1,0, 0},{1, 0, 0, 1,0} ,{0,0,1,0,0},{1, 0,0,0,1}};

        int t = noOfIslands(g);

        System.out.println(t);
    }


}
