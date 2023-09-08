package graph;

import CtCILibrary.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Link = https://www.codingninjas.com/studio/problems/replace-o-with-x_630517
 *
 * Given a 2D array grid G of 'O's and 'X's. The task is to replace all 'O' with 'X' contained in each island.
 * Where, an island is a set of 'O's connected horizontally or vertically and surrounded by 'X' from all of it's boundaries.
 * (Boundary means top, bottom, left and right)
 *
 * @Author saurabh vaish
 * @Date 21-07-2023
 */
public class Graph10_Replace_O_with_X {

    // Time - O(N ) + O(M) + O(N * M * 4)
    // we have to replace O with X if O is surrounded by X
    // any O on boundary will not countable as its not surrounded by X
    // since we have to replace all O so we can use dfs
    public static void replaceOWithXUsingDFS(char mat[][]) {
        // write your code here

        int row = mat.length;
        int col = mat[0].length;

        // all 4 possible directions
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};

        boolean [][] vis = new boolean[row][col];

        // check in first and last row , if any O found then traverse them
        for(int i=0;i<col;i++){
            // first row
            if(!vis[0][i]  && mat[0][i]=='O'){
                dfs(vis,mat,delrow,delcol,0,i);
            }

            // last row
            if(!vis[row-1][i]  && mat[row-1][i]=='O'){
                dfs(vis,mat,delrow,delcol,row-1,i);
            }
        }

        // check in first and last col , if any O found then traverse them
        for(int j=0;j<row;j++){
            // first row
            if(!vis[j][0]  && mat[j][0]=='O'){
                dfs(vis,mat,delrow,delcol,j,0);
            }

            // last row
            if(!vis[j][col-1]  && mat[j][col-1]=='O'){
                dfs(vis,mat,delrow,delcol,j,col-1);
            }
        }


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!vis[i][j] && mat[i][j]=='O'){
                    mat[i][j]='X';
//                    vis[i][j]=true;
                }
            }
        }

    }

    private static void dfs(boolean[][] vis, char[][] mat, int[] delrow, int[] delcol, int row, int col) {
        vis[row][col]=true;
        int n=mat.length;
        int m=mat[0].length;

        for(int i=0;i<4;i++){
            int nr = row + delrow[i];
            int nc = col + delcol[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && mat[nr][nc]=='O'){
                dfs(vis,mat,delrow,delcol,nr,nc);
            }
        }
    }

    // time - O(N*M)
    public static void replaceOWithXUsingBFS(char [][] grid){

        boolean [][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;

        // getting all O who are on boundary, add them in queue
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                // only check boundary
                if(i==0 || i==row-1 || j==0 || j==col-1){
                    if(grid[i][j]=='O'){
                        queue.add(new Pair(i,j));
                        vis[i][j]=true;
                    }
                }
            }
        }

        // since we can go only in 4 directions so possible ways
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.col;

            for(int i=0;i<4;i++){
                int nr = r + delrow[i];
                int nc = c + delcol[i];

                if(nr>=0 && nr<row && nc>=0 && nc<col && !vis[nr][nc] && grid[nr][nc]=='O'){
                    queue.add(new Pair(nr,nc));
                    vis[nr][nc]=true;
                }
            }

        }

        // mark those O which are not visited yet
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!vis[i][j] && grid[i][j]=='O'){
                    grid[i][j]='X';
                }
            }
        }

    }
    public static void main(String[] args) {
        char mat [][] = {{'X', 'X', 'O', 'X', 'X','X'}, {'X', 'O', 'O', 'X', 'O','X'}, {'O', 'X','X', 'O', 'O', 'X'},
                {'X', 'O', 'X','O', 'X', 'X'}, {'X', 'X', 'X','X', 'O', 'X'}, {'X', 'O', 'O', 'X','X', 'O'}};

//        replaceOWithXUsingDFS(mat);
        replaceOWithXUsingBFS(mat);

        AssortedMethods.printMatrix(mat);
    }
}
