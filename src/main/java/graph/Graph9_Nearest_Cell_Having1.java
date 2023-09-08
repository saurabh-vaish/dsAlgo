package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Link == https://www.codingninjas.com/studio/problems/distance-of-nearest-cell-having-1-in-a-binary-matrix_1169913
 *
 * You have been given a binary matrix 'MAT' containing only 0’s and 1’s of size N x M. You need to find the distance of the nearest cell having 1 in the matrix for each cell.
 *
 * The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the coordinates of the current cell and i2, j2 are the coordinates of the nearest cell having value 1.
 *
 * @Author saurabh vaish
 * @Date 19-07-2023
 */


class MPair{
    int row;
    int col;
    int dis;

    public MPair(int _r,int _c,int _d){
        row=_r;
        col=_c;
        dis = _d;
    }
}

public class Graph9_Nearest_Cell_Having1 {

    // O(r * c) + O( r * c * 4) + O(r * c)

    // using bfs we cam get nearest cell , we cannot use dfs as it will wrong ans will traverse until finds 1
    // but in bfs we will look into all 4 directions  as neighbours and can count dis from 1
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int r, int c) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int [][] ans = new int[r][c];

        Queue<MPair> queue = new LinkedList<>();

        boolean [][] vis = new boolean[r][c];

        // O(r * c)
        // track all cells having one
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat.get(i).get(j)==1){
                    queue.add(new MPair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }

        // since we can check only in 4 dir so
        int[]  delRow = {-1,0,1,0}; // up right bottom left
        int[]  delCol = {0,1,0,-1}; // up right bottom left

        // O( r * c * 4)
        while(!queue.isEmpty()){
            MPair poll = queue.poll();
            int row = poll.row;
            int col = poll.col;
            int dis = poll.dis;
            ans[row][col]=dis;

            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow>=0 && nRow < r && nCol >=0 && nCol<c && !vis[nRow][nCol]){
                    queue.add(new MPair(nRow,nCol,dis+1));
                    vis[nRow][nCol]=true;
                }
            }
        }


        for(int i=0;i<r;i++){
            list.add(new ArrayList<>());
        }

        // O(r * c)
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                list.get(i).add(ans[i][j]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int r=3,c=4;

        int [][]mat = {{0,0,0,1},{0,0,1,1},{0,1,1,0}};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<r;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                list.get(i).add(mat[i][j]);
            }
        }

        ArrayList<ArrayList<Integer>> nearest = nearest(list, r, c);

        nearest.forEach(n->{
            n.forEach(System.out::print);
            System.out.println();
        });

    }



}
