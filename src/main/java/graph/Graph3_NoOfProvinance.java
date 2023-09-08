package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author saurabh vaish
 * @Date 16-07-2023
 */
public class Graph3_NoOfProvinance {

    // O(v + 2E)
    private static void dfs(List<List<Integer>> list,int i,boolean[] visited){
        visited[i]=true;

        for(Integer a:list.get(i)){
            if(!visited[a]){
                dfs(list,a,visited);
            }
        }
    }

    // O(N) * O(v + 2E)
    private static int noOfProvinance(int [][] ed,int v){

        // create adjacency list
        List<List<Integer>> adj = getAdjcencyList(ed,v);

        boolean [] visited = new boolean[v+1];
        int count = 0;
        for(int i=1;i<=v;i++){
            if(!visited[i]){
                count++;
                dfs(adj,v,visited);
            }
        }

        return count;

    }

    // O(V * V)
    private static List<List<Integer>> getAdjcencyList(int[][] grid, int v) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<=v;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<grid.length;i++){
            list.get(grid[i][0]).add(grid[i][1]);
            list.get(grid[i][1]).add(grid[i][0]);
        }


//        for(int i=0;i<v;i++){
//            for(int j=0;j<v;j++){
//                if(ed[i][j]==1 && i!=j){
//                    list.get(i).add(j);
//                    list.get(j).add(i);
//                }
//            }
//        }

        return list;
    }

    public static void main(String[] args) {
        int m = 4, n=5;
        int g[][] = {{1,2},{2,3},{3,4}};

        int t = noOfProvinance(g,4);

        System.out.println(t);
    }

}
