package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author saurabh vaish
 * @Date 13-07-2023
 */
public class Graph1_BFS {

    // complexity == O(n) + O(2E) , where e= edges
    public static ArrayList<Integer> BFS(int vertex, int edges[][]){
        // WRITE YOUR CODE HERE
        ArrayList<Integer> list = new ArrayList<>();

        // visited array to avoid duplicate traversal
        boolean [] visited = new boolean[vertex];
        visited[0] = true;  // marking 0 as true , as in qsn stated that nodes will be from 0 to V-1 , so taking first node

        // adjacency list to hold node neighbours
        List<List<Integer>> adj = getAdjList(edges, vertex);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int e = q.poll();
            list.add(e);

            // get all neighbours and add then to queue if not visited
            for (Integer l: adj.get(e)) {
                if(!visited[l]){
                    visited[l]=true;
                    q.add(l);
                }
            }
        }

        return list;

    }

    private static List<List<Integer>> getAdjList(int ed[][], int ver){
        List<List<Integer>> adj = new ArrayList<>();

        for (int v = 0; v < ver; v++) {
            adj.add(new ArrayList<>());
        }
        for (int v = 0; v < ver; v++) {
            adj.get(ed[v][0]).add(ed[v][1]);
            adj.get(ed[v][1]).add(ed[v][0]);
        }
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

        ArrayList<Integer> bfs = BFS(4, ed);

        bfs.forEach(System.out::println);
    }



}
