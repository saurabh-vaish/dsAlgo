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
public class Graph16_DetectCycle_Directed_Graph_DFS2 {


    // O( N + E) + O(N)  , O(N) as in worst case it may call for all nodes
    // O(N) + O(N)
    // to detect cycle we will traverse graph and mark node visited , if in traversing we encountered same node again means there is cycle
    // since its directed graph so we have so track path also from which its traversing
    // every time we will visit a node will mark as visited and will do same with pathvisit also
    // but when we return from traversing will unmark pathvisit as current path traversing is done and cycle not found
    public static boolean detectCycleInDirectedGraph(int v, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.
        int [] vis = new int[v+1];
        int [] pathVis = new int[v+1]; // to track path

        ArrayList<ArrayList<Integer>> adjList = getAdjacencyList(edges,v);

        for(int i=1;i<=edges.size();i++){
            if(vis[i]==0){
                if(detectDFS(vis,pathVis,i,adjList))return true;
            }
        }

        return false;
    }

    // O( N + E)
    private static boolean detectDFS(int[] vis,int [] pathVis, int node, ArrayList<ArrayList<Integer>> adjList) {
        vis[node]=1;
        pathVis[node]=1;

        for(Integer adj: adjList.get(node)){
            if(vis[adj]==0){   // if adjacent node is not visited
                boolean isCycle = detectDFS(vis,pathVis, adj, adjList);
                if(isCycle)return true;
            }else if(pathVis[adj]==1){  // if adjacent node is already visited and there is also visited in current path traversal means its cycle
                return true;
            }
        }

        pathVis[node]=0; // make path visited again 0 once coming back from node ,means traverse from that path is completed
        return false;
    }


    private static ArrayList<ArrayList<Integer>> getAdjacencyList( ArrayList < ArrayList < Integer >> edges, int v) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int s = Math.max(v,edges.size());
        for(int i=0;i<=v;i++){
            list.add(new ArrayList<>());
        }

        // id only edges are given
        for(int i=0;i<edges.size();i++){
            list.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }


        return list;
    }


    public static void main(String[] args) {
        int v=5;

//        int [][] mat = {{1,2}, {4 ,1}, {2 ,4}, {3 ,4}, {5 ,2}, {1 ,3}};

        int [][] mat = {{1,2},{2,3},{3,4},{4,5}};

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int[] row : mat) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int item : row) {
                innerList.add(item);
            }
            arrayList.add(innerList);
        }


        System.out.println(detectCycleInDirectedGraph(v,arrayList));
    }



}
