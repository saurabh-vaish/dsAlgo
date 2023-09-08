package graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Link = https://www.codingninjas.com/studio/problems/topological-sort_982938?topList=striver-sde-sheet-problems
 *
 * Topological Task ==  Topological sorting is a graph traversal algorithm that produces a linear ordering of the vertices of a directed acyclic graph (DAG).
 *                      The topological ordering is such that for every directed edge uv from vertex u to vertex v, vertex u appears before vertex v in the ordering.
 *                      It's only works on Direct Acyclic Graph.
 *                      Direct - bcs its need linear direct ordering
 *                      Acyclic - If a graph is cyclic then can't define the which node is first node
 *
 * @Author saurabh vaish
 * @Date 25-07-2023
 */
public class Graph18_TopologicalSortDfs {


    // O(N + E ) + O(N)
    // for topological sort will traverse with dfs and on every dfs completion will add them in stack
    // since we are using visited array to it wont traverse every time
    // and in the end of dfs will get topological order of nodes [ there could be multiple order of same graph ]
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> list = getAdjacencyList(edges,v,e);

        ArrayList<Integer> sort = new ArrayList<>();

        boolean [] vis = new boolean[v];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<v;i++){
            if(!vis[i])
                dfs(i,vis,list,st);
        }

        while(!st.isEmpty()){
            sort.add(st.pop());
        }


        return sort;
    }

    // O(N + E)
    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node]=true;

        for(Integer it:adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,st);
            }
        }
        st.add(node);
    }

    // O(N)
    private static ArrayList<ArrayList<Integer>> getAdjacencyList(ArrayList<ArrayList<Integer>> edges, int v, int e) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<v;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.size();i++){
            list.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }

        return list;
    }

    public static void main(String[] args) {
        int e=4,v=4;

        int mat [][] = {{0,1},{0,3},{1,2},{3,2}};

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int[] row : mat) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int item : row) {
                innerList.add(item);
            }
            arrayList.add(innerList);
        }

        System.out.println(topologicalSort(arrayList,v,e));
    }


}
