package graph;

import java.util.*;

/**
 *  Graph -- Graph data structure having nodes with edges . Graphs are two types - directed , undirected
 *
 *          -- We can represent graph using adjacency list , matrix and using map
 *
 *
 * @author Saurabh Vaish
 * @Date 05-08-2021
 */
public class GraphTraversal {


    // we will implement dfs using stacks , will push each node and pop and push its neighbours
    public void dfs(Map<String, List<String>> graph,String startingNode){
        Stack<String> stack = new Stack<>();
        stack.push(startingNode);

        // iterating stack until its became empty
        while (!stack.isEmpty()){
            String el = stack.pop();  // pop the current node
            System.out.print(el+" ");

            // iterate over node neighbours
            for (String e:graph.get(el)){
                stack.push(e); // adding neighbours to stack
            }
        }
    }

    public void dfsUsingRecursion(Map<String, List<String>> graph,String startingNode){
        System.out.print(startingNode+" ");

        // no base condition here as loop is managing recursive calls
        for (String e:graph.get(startingNode)){
            dfsUsingRecursion(graph, e);
        }
    }



    // we will implement bfs using queue , will add each node and remove from front  and add its neighbours from back in queue
    public void bfs(Map<String, List<String>> graph,String startingNode){
        Queue<String> queue = new LinkedList<>();
        queue.add(startingNode);

        // iterating queue until its became empty
        while (!queue.isEmpty()){
            String el = queue.poll();  // pop the current node
            System.out.print(el+" ");

            queue.addAll(graph.get(el)); // adding neighbours to stack
        }
    }

    // Time - O(e)  , space - O(n)
    public void bfsUsingRecursion(Map<String, List<String>> graph,Queue<String> queue){
        if(queue.isEmpty())return;
        String el = queue.poll();
        System.out.print(el+" ");
        queue.addAll(graph.get(el));
        bfsUsingRecursion(graph, queue);
    }




    public static void main(String[] args) {

        GraphTraversal graph = new GraphTraversal();

        // adding value for graph
        Map<String, List<String>> graphStore = new HashMap<>();
        graphStore.put("a", Arrays.asList("b","c")); // a is connected with b and c
        graphStore.put("b", Arrays.asList("d")); // b is connected with  d
        graphStore.put("c", Arrays.asList("e"));    //  c is connected with e
        graphStore.put("d", Arrays.asList("f"));    // d is connected with f
        graphStore.put("e", Collections.EMPTY_LIST); //  e is not connected , c ,b are connected with e
        graphStore.put("f", Collections.EMPTY_LIST);  // f is not connected , d connected to f

        System.out.print("Dfs using stack == ");
        graph.dfs(graphStore, "a");

        System.out.print("\nDfs using recursion == ");
        graph.dfsUsingRecursion(graphStore, "a");

        // note both output will not same as they depends on child position in list

        System.out.print("\nBfs using queue = ");
        graph.bfs(graphStore, "a");

        System.out.print("\nBfs using recursion = ");
        Queue<String> queue = new LinkedList<>();
        queue.add("a"); // adding starting node
        graph.bfsUsingRecursion(graphStore, queue);

    }
}
