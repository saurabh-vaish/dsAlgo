package graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Link = https://www.codingninjas.com/studio/problems/safe-nodes-in-the-graph_1376703
 *
 * Safe nodes in graph are those nodes from which we can reach to terminal nodes [ a node which has no outgoing edge]
 * Need to find such safe nodes in sorted order
 *
 * if a node is cycle or is part of cycle or going to cycle then it can not be safe node
 *
 * we will check for cycles and mark safe nodes
 *
 * @Author saurabh vaish
 * @Date 24-07-2023
 */
public class Graph17_EventualSafeNodes {


    public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        // Write your code here.

        List<List<Integer>> list = adjacencyList(edges,n,e);

        ArrayList<Integer> res = new ArrayList<>();

        boolean vis [] = new boolean[n+1];
        boolean pathvis [] = new boolean[n+1];
        int safe [] = new int[n+1];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(vis,pathvis,safe,list,i);
            }
        }

        for(int i=0;i<safe.length;i++){
            if(safe[i]==1)
            res.add(i);
        }

        return res;
    }

    private static boolean dfs(boolean[] vis, boolean[] pathvis, int[] safe, List<List<Integer>> list, int node) {

        vis[node]=true;
        pathvis[node]=true;
        safe[node]=0;

        for(Integer it:list.get(node)){
            if(!vis[it]){ // if its not visited
                boolean isCycle = dfs(vis,pathvis,safe,list,it);
                if(isCycle)return true;
            }
            else if(pathvis[it])return true;  // visited and also path visited so its cycle
        }

        safe[node]=1;
        pathvis[node]=false;

        return false;
    }

    private static List<List<Integer>> adjacencyList(int[][] edges, int n, int e) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
        }

        return list;
    }


    public static void main(String[] args) {
//        int v = 5;
//        int [][] mat = {{0,1},{1,0},{0,2}};
        int v=3;
        int [][] mat = {{1,2},{2,0}};

        System.out.println(safeNodes(mat,v,2));
    }
}
