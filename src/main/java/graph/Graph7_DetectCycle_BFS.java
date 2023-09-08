package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Link = https://www.codingninjas.com/studio/problems/cycle-detection-in-undirected-graph_1062670?topList=striver-sde-sheet-problems
 * You have been given an undirected graph with 'N' vertices and 'M' edges. The vertices are labelled from 1 to 'N'.
 * Your task is to find if the graph contains a cycle or not.
 * A path that starts from a given vertex and ends at the same vertex traversing the edges only once is called a cycle.
 *
 * detect cycle in graph
 *
 * @Author saurabh vaish
 * @Date 17-07-2023
 */

class BPair{
    int node;
    int parent;

    public BPair(int _node,int _parent){
        this.node = _node;
        this.parent = _parent;
    }
}


public class Graph7_DetectCycle_BFS {


    // O(N) + O(N + 2E)    // not including list conversion
    // O(N)
    public static boolean detectCycle(int[][] grid,int v){
        boolean [] vis = new boolean[v+1];

        ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(grid,v);

        for(int i=1;i<=v;i++){
            if(!vis[i]){
                if(detectBFS(vis,i,adjList))return true;
            }
        }

        return false;
    }

    // O( N + 2E)

    private static boolean detectBFS(boolean[] vis, int src, ArrayList<ArrayList<Integer>> adj) {
        vis[src]=true;

        Queue<BPair> queue = new LinkedList<>();
        queue.add(new BPair(src,-1));  // adding default parent for starting node

        while(!queue.isEmpty()){
            BPair pair = queue.poll();
            int node = pair.node;
            int parent = pair.parent;

            for(Integer a:adj.get(node)){  // getting all neighbours
                if(!vis[a]){
                    vis[a]=true;
                    queue.add(new BPair(a,node)); //  if not visited adding them to queue and taking current node as parent
                }else if(vis[a] && parent!=a){  //  neighbour node is already visited but there parent is not same , means already someone visited so cycle detected
                    return true;   // cycle found return true
                }
            }
        }

        return false;
    }

    // O(N ^ 2)
    private static ArrayList<ArrayList<Integer>> getAdjacencyList(int[][] grid, int v) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<=v;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<grid.length;i++){
            list.get(grid[i][0]).add(grid[i][1]);
            list.get(grid[i][1]).add(grid[i][0]);
        }

        return list;
    }


    public static void main(String[] args) {
        int m = 4, n=3;
        int g[][] = {{1,4},{4,3},{3, 1}};

        System.out.println(detectCycle(g,m));


    }

}
