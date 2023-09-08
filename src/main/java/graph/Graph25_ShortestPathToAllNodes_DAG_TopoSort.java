package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * find the shortest path in weighted graph for all nodes .
 *
 * we can use other algos like dijestra but this we will solve with topo sort as this is a confirmed DAG
 *
 * @Author saurabh vaish
 * @Date 03-08-2023
 */

class SPair{
    int egde;
    int weight;

    public SPair(int e,int w){
        this.egde = e;
        this.weight = w;
    }
}
public class Graph25_ShortestPathToAllNodes_DAG_TopoSort {

    // Comp = O( N + M )
    // first we will create adj list with weighted nodes
    // then we will sort them using topo sort
    // then will start from each node in topo sort , will calculate weight for each node and will have shorted path on each vertex
    public static int[] shortesPath(int n, int m,int [][] edges){

        // get adjacency list
        ArrayList<ArrayList<SPair>> adjList = new ArrayList<>();

        // O(n)
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        // O(n)
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adjList.get(u).add(new SPair(v,w));
        }



        boolean [] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        // O(N + M)
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                dfs(i,vis,adjList,st);
            }
        }

        int [] sort = new int[m];
        Arrays.fill(sort,(int)1e9);

        sort[0]=0; // since we need to start from 0th vertex , if its given to find distance from particular index then will use that

        // O(N + M) , m edges
        while (!st.isEmpty()){
            Integer node = st.pop();

            for (SPair it:adjList.get(node)){
                if(it.weight + sort[node] < sort[it.egde]){  // will compute distance from sorted stack node to neighbours , if its less what sort already have then replace
                    sort[it.egde] = it.weight + sort[node];
                }
            }
        }


        return sort;
    }

    // topo sort using dfs
    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<SPair>> adjList, Stack<Integer> st) {
        vis[node] = true;

        for(SPair it:adjList.get(node)){
            if(!vis[it.egde]){
                dfs(it.egde,vis,adjList,st);
            }
        }

        st.push(node);
    }

    public static void main(String[] args) {
        int n=5, m =4;

        int [][] ar = {{0,1,5},{0,2,8},{1,2,9},{1,3,2},{2,3,6}};

        System.out.println(Arrays.toString(shortesPath(n,m,ar)));
    }

}

