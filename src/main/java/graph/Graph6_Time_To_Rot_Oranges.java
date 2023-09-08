package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  given in a matrix find the min time in which all the oranges can be rotten by already rotten oranges , only unit length neighbour
 *  oranges can be rotten in one unit time , and if its not possible to rot all oranges , return -1
 *  0 means no orange
 *  1 means fresh
 *  2 means rotten
 *
 * @Author saurabh vaish
 * @Date 16-07-2023
 */

class OPair{
    int row;
    int col;
    int time;

    public OPair(int _r,int _c,int _t){
        row=_r;
        col = _c;
        time = _t;
    }
}

public class Graph6_Time_To_Rot_Oranges {

    // Time = O(n * m) + O(n * m * 4)
    // space == O(n*m)
    // first we need to find all the rotten oranges and then will start rotting others
    // we will use BFS as only unit neighbours can be rotten so can't use DFS
    public int rottingOranges(int [][] mat){

        int row = mat.length;
        int col = mat[0].length;

        // find all the rotten oranges and also count the fresh ones
        Queue<OPair> queue = new LinkedList<>();
        int countFresh=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==2){
                    queue.add(new OPair(i,j,0)); // initially attach 0 time , as they are already rotten
                }
                if(mat[i][j]==1)countFresh++;
            }
        }

        boolean [][] visited = new boolean[mat.length][];
        int minTime=0;

        // as they can rott in 4 possible directions
        int [] delRow = {-1,0,1,0}; // upper , right, down, left
        int [] delCol = {0,1,0,-1}; // upper , right, down, left

        int count=0;

        while(!queue.isEmpty()){
            OPair orange = queue.poll();
            int orow = orange.row;
            int ocol = orange.col;
            int otime = orange.time;

            minTime = Math.max(otime,minTime);

            for(int i=0;i<4;i++){
                int nRow = orow + delRow[i];
                int nCol = ocol + delCol[i];

                if(nRow>=0 && nRow< row && nCol>=0 && nCol < col && !visited[nRow][nCol] &&
                       mat[nRow][nCol]==1 ){
                    queue.add(new OPair(nRow,nCol,otime++));
                    visited[nRow][nCol]=true;
                    count++;
                }
            }

        }

        if(count != countFresh)return -1; // all the oranges are not being rotten

        return minTime;
    }
}
