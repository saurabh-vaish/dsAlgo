package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author saurabh vaish
 * @Date 13-07-2023
 */
public class Graph2_DFS {

    // complexity == O(n) + O(2E) , where e= edges
    // space == (L + V + N) == N
    public static ArrayList<Integer> DFS(int vertex, int edges[][]){
        // WRITE YOUR CODE HERE
        ArrayList<Integer> list = new ArrayList<>();

        // visited array to avoid duplicate traversal
        boolean [] visited = new boolean[vertex];

        // adjacency list to hold node neighbours
        List<List<Integer>> adj = getAdjList(edges, vertex);

        dfsTraverse(1,adj,visited,list); // choosing 1 as starting node

        return list;

    }

    private static void dfsTraverse(int node, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        visited[node] = true;  // marking node as true , as in qsn stated that nodes will be from 0 to V-1 , so taking first node
        list.add(node);

        //  getting all neighbours of the node and only traverse which are not visited
        for(Integer nbr:adj.get(node)){
            if(!visited[nbr]){
                dfsTraverse(nbr,adj,visited,list);
            }
        }

    }

    private static List<List<Integer>> getAdjList(int ed[][], int ver){
        List<List<Integer>> adj = new ArrayList<>();

        for (int v = 0; v < ver; v++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<ver;i++){
            for(int j=0;j<ver;j++){
                if(ed[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
//        for (int v = 0; v < ver; v++) {
//            adj.get(ed[v][0]).add(ed[v][1]);
//            adj.get(ed[v][1]).add(ed[v][0]);
//        }
//        for (int v = 0; v < ver; v++) {
//            adj.get(ed[0][v]).add(ed[1][v]);
//            adj.get(ed[1][v]).add(ed[0][v]);
//        }
        return adj;
    }

    public static void main(String[] args) {
        int [][] ed = {{0, 1}, {0, 3}, {1, 2}, {2, 3}};
//        int [][] ed = {{0,0, 1,2}, {1, 3,2,3}};

        List<List<Integer>> adjList = getAdjList(ed, 4);
        adjList.forEach(l-> {
            l.stream().forEach(System.out::print);
            System.out.println();
        });

        ArrayList<Integer> dfs = DFS(4, ed);

        dfs.forEach(System.out::println);
    }



}
