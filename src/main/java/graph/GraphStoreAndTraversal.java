package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author saurabh vaish
 * @Date 09-10-2022
 */
public class GraphStoreAndTraversal {


    // =================================================================

    // Time == ( N + 2*E )
    // space == (L + V + N) == N
    private static void dfsRecursion(List<List<Integer>> adjList,  int node, List<Integer> list, boolean[] visit) {
        visit[node]=true;
        list.add(node);

        for (Integer nd : adjList.get(node)){
            if(!visit[nd]){
                dfsRecursion(adjList,nd,list,visit);
            }
        }
    }

    public static List<Integer> dfs(List<List<Integer>> adjList,int size,int startingNode){
        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[size];
        dfsRecursion(adjList,startingNode,list,visit);
        return list;
    }

    // =================================================================================================

    // Time === O( N + 2*E) , N= size of adj list , E = edges , here 2*E is total degree
    // space == (L + Q + V ) === N , size of list , queue and visited array

    public static List<Integer> bfs(List<List<Integer>> adjList,int size, int startingNode){
        List<Integer> list = new ArrayList<>(); // bfs list

        Queue<Integer> queue = new LinkedList<>();  // queue that will store nodes

        boolean[] visited = new boolean[size]; // visited array that will track node is visited or not
        queue.add(startingNode); // adding first nodes
        visited[startingNode]=true;  // making as visited

        // untill queue is not empty
        while (!queue.isEmpty()){
            Integer elem = queue.poll();   // getting first element
            list.add(elem);  // adding to bfs list

            for (Integer nds : adjList.get(elem)){  // loop and get childs
                if(!visited[nds]){  // if not visited
                    queue.add(nds);   // add its childs to queue
                    visited[nds]=true;
                }
            }
        }


        return list;
    }


    public static void main(String[] args) {
        GraphStoreAndTraversal graph = new GraphStoreAndTraversal();
        int nodes = 5;

        List<List<Integer>> adjList = new ArrayList<>();  // created adjacent list
        // undirected

        //         0
        //      1   2   3
        //          4

        // insertion for zero based index
//        for (int i = 0; i < nodes; i++) {
//            adjList.add(new ArrayList<>());  // adding empty list to all nodes
//        }
//
//        // start filling children's to list
//        adjList.get(0).add(1);
//        adjList.get(0).add(2);
//        adjList.get(0).add(3);
//
//        adjList.get(1).add(0);
//        adjList.get(1).add(2);
//
//        adjList.get(2).add(0);
//        adjList.get(2).add(1);
//        adjList.get(2).add(3);
//        adjList.get(2).add(4);
//
//        adjList.get(3).add(2);
//
//        adjList.get(4).add(2);

        int nodes2 = 8;

        //          1
        //      2     3    4
        //   5    6   7    8

        // 1 based indexing
        for (int i = 0; i <=nodes2; i++) {
            adjList.add(new ArrayList<>());  // adding empty list to all nodes
        }

        // start filling children's to list
        // no child at 0
        adjList.get(1).add(2);
        adjList.get(1).add(3);

        adjList.get(2).add(1);
        adjList.get(2).add(5);
        adjList.get(2).add(6);

        adjList.get(3).add(1);
        adjList.get(3).add(4);
        adjList.get(3).add(7);

        adjList.get(4).add(3);
        adjList.get(4).add(8);

        adjList.get(5).add(2);

        adjList.get(6).add(2);

        adjList.get(7).add(3);
        adjList.get(7).add(8);

        adjList.get(8).add(7);
        adjList.get(8).add(4);



        System.out.println(adjList);

        System.out.println("======= bfs traversal ========= ");

        System.out.println(bfs(adjList, adjList.size(),1));

        System.out.println("======= dfs traversal ========= ");

        System.out.println(dfs(adjList, adjList.size(),1));


    }

}
