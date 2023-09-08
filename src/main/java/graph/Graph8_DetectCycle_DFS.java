package graph;

import java.util.ArrayList;

/**
 * detect cycle in graph
 *
 * @Author saurabh vaish
 * @Date 17-07-2023
 */

class DPair{
    int node;
    int parent;

    public DPair(int _node,int _parent){
        this.node = _node;
        this.parent = _parent;
    }
}


public class Graph8_DetectCycle_DFS {


    // O( N + 2E) + O(N)  , O(N) as in worst case it may call for all nodes
    // O(N) + O(N)
    public boolean detectCycle(int[][] grid,int v){
        boolean [] vis = new boolean[v];

        ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(grid,v);

        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(detectDFS(vis,i,-1,adjList))return true;
            }
        }

        return false;
    }

    // O( N + 2E)
    private boolean detectDFS(boolean[] vis, int src, int parent, ArrayList<ArrayList<Integer>> adjList) {
        vis[src]=true;

        for(Integer adj: adjList.get(src)){
            if(!vis[src]){
                boolean isCycle = detectDFS(vis, adj, src, adjList);
                if(isCycle)return true;
            }else if(vis[src] && parent != adj){
                return true;
            }
        }

        return false;
    }


    // O(N ^ 2)
    private ArrayList<ArrayList<Integer>> getAdjacencyList(int[][] grid, int v) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<grid.length;i++){
            list.get(grid[i][0]).add(grid[i][1]);
            list.get(grid[i][1]).add(grid[i][0]);
        }


//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]==1 && i!=j) {
//                    list.get(i).add(j);
//                    list.get(j).add(i);
//                }
//            }
//        }

        return list;
    }

}
