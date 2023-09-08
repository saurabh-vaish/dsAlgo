package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
public class Graph19_TopologicalSortBfs_Kahn_Algo {


    // O(N + E ) + O(N) + O(n)
    // This is also similar to topological sort using dfs , instead stack here we will use query and BFS and instead of visited array will use
    // frequency array [ in-degree ] of nodes . In degree of node state no of edges coming to that node.
    // first create adjacency matrix then count indegree of nodes
    // then start from first node and do bfs and will add those nodes whose indegree is 0 and on each bfs add node to list
    public static ArrayList<Integer> topologicalSortBFS(ArrayList<ArrayList<Integer>> edges, int v, int e)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> list = getAdjacencyList(edges,v,e);

        ArrayList<Integer> sort = new ArrayList<>();

        int [] indegree = new int[v];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<v;i++){
            for(Integer it:list.get(i)){
                indegree[it]++;  // counting nodes degree
            }
        }

        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            Integer node = q.poll();
            sort.add(node);

            for(Integer it:list.get(node)){
                indegree[it]--; // as node is already added into sort so reduce degree
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }


        return sort;
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

        System.out.println(topologicalSortBFS(arrayList,v,e));
    }


}
