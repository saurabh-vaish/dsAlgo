package graph;

import java.util.*;

/**
 *  @Link = https://www.codingninjas.com/studio/problems/safe-nodes-in-the-graph_1376703
 *
 * Safe nodes in graph are those nodes from which we can reach to terminal nodes [ a node which has no outgoing edge]
 *  Need to find such safe nodes in sorted order
 *
 *  if a node is cycle or is part of cycle or going to cycle then it can not be safe node
 *
 * This is the impl for finding eventual safe nodes using topological sort ,
 * for this we will first reverse edges as we need to return sorted array
 *
 * @Author saurabh vaish
 * @Date 26-07-2023
 */
public class Graph23_EventualSafe_Using_TopologicalSort {


    public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        // Write your code here.

        List<List<Integer>> list = adjacencyList(edges,n,e);

        ArrayList<Integer> res = new ArrayList<>();

        int indegree [] = new int[n+1];

        for(int i=0;i<n;i++){
            for(Integer it:list.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            Integer node = q.poll();
            res.add(node);

            for(Integer it:list.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        Collections.sort(res);

        return res;
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
