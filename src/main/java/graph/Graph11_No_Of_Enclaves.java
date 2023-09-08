package graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given matrix where 1 represents 1 and 0 represents water , need to find the no of lands from which we can not go outside of islands.
 * we can go outside if any land is on boundary or connected to boundary with other lands in unit distance
 *
 * @Author saurabh vaish
 * @Date 20-07-2023
 */


public class Graph11_No_Of_Enclaves {


    // since we can go outside if any lands on boundary , so we have to exclude all the lands which are on boundary or connected to it
    // we can use bfs and dfs both
    // first count the islands which are on boundary
    // start traversing using them and mark them
    // in last count those lands which are not marked
    public static int countIslandsUsingBfs(int [][] grid){

        boolean [][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                // only check boundary
                if(i==0 || i==row-1 || j==0 || j==col-1){
                    if(grid[i][j]==1){
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

                if(nr>=0 && nr<row && nc>=0 && nc<col && !vis[nr][nc] && grid[nr][nc]==1){
                    queue.add(new Pair(nr,nc));
                    vis[nr][nc]=true;
                }
            }

        }

        int count=0;
        // count those lands which are not visited yet
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int g[][] = {{0,0,0,1,1},{0,0,1,1,0},{0,1,0,0,0},{0,1,1,0,0},{0,0,0,1,1}};

        int t = countIslandsUsingBfs(g);

        System.out.println(t);
    }

}
