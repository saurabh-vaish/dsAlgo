package graph;

import java.util.ArrayList;

/**
 * @Link = https://www.codingninjas.com/studio/problems/detect-cycle-in-a-directed-graph_1062626?topList=striver-sde-sheet-problems
 *
 * detect cycle in directed graph
 *
 * @Author saurabh vaish
 * @Date 24-07-2023
 */
public class Graph15_DetectCycle_Directed_Graph_DFS {


    // O( N + E) + O(N)  , O(N) as in worst case it may call for all nodes
    // O(N) + O(N)
    // to detect cycle we will traverse graph and mark node visited , if in traversing we encountered same node again means there is cycle
    // since its directed graph so we have so track path also from which its traversing
    // every time we will visit a node will mark as visited and will do same with pathvisit also
    // but when we return from traversing will unmark pathvisit as current path traversing is done and cycle not found
    public static boolean detectCycle(int[][] grid,int v){
        int [] vis = new int[v];
        int [] pathVis = new int[v]; // to track path

        ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(grid,v);

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(detectDFS(vis,pathVis,i,adjList))return true;
            }
        }

        return false;
    }

    // O( N + 2E)
    private static boolean detectDFS(int[] vis,int [] pathVis, int node, ArrayList<ArrayList<Integer>> adjList) {
        vis[node]=1;
        pathVis[node]=1;

        for(Integer adj: adjList.get(node)){
            if(vis[adj]==0){  // if adjacent node is not visited
                boolean isCycle = detectDFS(vis,pathVis, adj, adjList);
                if(isCycle)return true;
            }else if(pathVis[adj]==1){  // if adjacent node is already visited and there is also visited in current path traversal means its cycle
                return true;
            }
        }

        pathVis[node]=0; // make path visited again 0 once coming back from node ,means traverse from that path is completed
        return false;
    }


    private static ArrayList<ArrayList<Integer>> getAdjacencyList(int[][] grid, int v) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            list.add(new ArrayList<>());
        }

        // id only edges are given
        for(int i=0;i<grid.length;i++){
            list.get(grid[i][0]).add(grid[i][1]);
        }


        // if 0 ,1 matrix is given for edge
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]==1 && i!=j) {
//                    list.get(i).add(j);
//                }
//            }
//        }

        return list;
    }


    //  using one vis array -------------------

    public static boolean detectCycle2(int[][] grid,int v){
        int [] vis = new int[v];

        ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(grid,v);

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(detectDFS2(vis,i,adjList))return true;
            }
        }

        return false;
    }

    // O( N + 2E)
    private static boolean detectDFS2(int[] vis, int node, ArrayList<ArrayList<Integer>> adjList) {
        vis[node]=2;  // one for vis and one for path

        for(Integer adj: adjList.get(node)){
            if(vis[adj]==0){
                boolean isCycle = detectDFS2(vis, adj, adjList);
                if(isCycle)return true;
            }else if(vis[adj]==2){  // if node is already visited and there is also visited in current path traversal means its cycle
                return true;
            }
        }

        vis[node]=vis[node]--; // make path visited again 0 once coming back from node ,means traverse from that path is completed
        return false;
    }


    public static void main(String[] args) {
        int v=5;

        int [][] mat = {{1,2},
                {4 ,1},
                {2 ,4},
                {3 ,4},
                {5 ,2},
                {1 ,3}};


        System.out.println(detectCycle(mat,v));
        System.out.println(detectCycle2(mat,v));
    }



}
