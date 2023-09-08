package graph;

import java.util.*;

/**
 * @Link = https://www.codingninjas.com/studio/problems/is-bipartite_3849884
 *
 * A graph is bipartite if the nodes of the graph can be partitioned into two independent sets A and B such that every edge in the graph
 * connects a node in set A and a node in set B.
 *
 *  Since we have to divide the nodes into two disjoints set that no two graph vertices are adjacent
 *  so if we start coloring each node with 2 colors then no two adjacent  nodes will have same color
 * - if a graph is having no cycle then it will be bipertite graph
 * - if its having cycle with even no of nodes then also it will be bi-pertitie graph
 * - if its having cycle with odd no of nodes then it will not be bipertite graph
 *
 *
 * @Author saurabh vaish
 * @Date 23-07-2023
 */
public class Graph13_Bipertite_BFS {

    // O(N + 2E)
    // to check graph is bipertitie of not first we need adjacency matrix then we will start traversing graph and will do coloring
    // if any two nodes will have same color then they are not bipertite
    public static boolean checkBiPertite_BFS(int start,int v,List<List<Integer>> list ,int []vis){

        Queue<Integer> q = new LinkedList<>();
        q.add(start); // adding starting node to queue

        vis[start] = 0;  // giving starting node initial color

        while(!q.isEmpty()){
            Integer node = q.poll();

            for(Integer it :list.get(node)){

                if(vis[it]==-1){
                    vis[it] = 1-vis[node];
                    q.add(it);
                }
                else if(vis[it]==vis[node]){  // adjacent node and current node has same color ,not bipertite graph
                   return false;
                }
            }
        }

        return true;
    }


    // O(V ) + O(N + 2E)
    public static boolean isBipartitie(int v, int[][]mat){

        List<List<Integer>> list = adjacencyList(mat,v);

        int [] vis = new int[v];
        Arrays.fill(vis, -1);  // filling for initial value

        for(int i=0;i<v;i++){
            if(vis[i]==-1){
                boolean isBipartite = checkBiPertite_BFS(i,v,list,vis);
                if(!isBipartite)return false;
            }
        }
        return true;
    }

    // O(N)
    private static List<List<Integer>> adjacencyList(int[][] mat, int v) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<v;i++){
            list.add(new ArrayList<>());
        }

        // using this if matrix with 0 ,1 is given
//        for(int i=0;i<mat.length;i++){
//            for(int j=0;j<mat[0].length;j++){
//                if(mat[i][j]==1 && i!=j){
//                    list.get(i).add(j);
//                    list.get(j).add(i);
//                }
//            }
//        }

        // use this when edge list is given
        for(int i=0;i<mat.length;i++){
            list.get(mat[i][0]).add(mat[i][1]);
            list.get(mat[i][1]).add(mat[i][0]);
        }

        return list;
    }


    public static void main(String[] args) {
        int m = 4, n=5;
        int g[][] = {{0,1},{0,3},{1,2}};

        System.out.println(isBipartitie(m,g));


    }
}
