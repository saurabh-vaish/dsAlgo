package graph;

import java.util.*;

/**
 * @Problem  == Count the nodes in the largest component in graph
 *
 * @Complexity ==  time =  O(n+e) == O(e)  , e = no of edges
 *                 space =  O(n)
 *
 * @author Saurabh Vaish
 * @Date 07-08-2021
 */
public class LargestComponentInGraph {

    public static void main(String[] args) {

        LargestComponentInGraph graph = new LargestComponentInGraph();

        Map<Integer, List<Integer>> graphStore = new HashMap<>();
        graphStore.put(0, Arrays.asList(8,1,5));
        graphStore.put(1, Arrays.asList(0));
        graphStore.put(5, Arrays.asList(0,8));
        graphStore.put(8, Arrays.asList(0,5));
        graphStore.put(2, Arrays.asList(3,4));
        graphStore.put(3, Arrays.asList(2,4));
        graphStore.put(4, Arrays.asList(3,2));

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(7, new ArrayList<>());
        adjacencyList.put(5, new ArrayList<Integer>() {{ add(6); }});
        adjacencyList.put(6, new ArrayList<Integer>() {{ add(5); }});
        adjacencyList.put(2, new ArrayList<Integer>() {{ add(1); }});
        adjacencyList.put(3, new ArrayList<Integer>() {{ add(1); add(4); }});
        adjacencyList.put(4, new ArrayList<Integer>() {{ add(1); add(3); }});
        adjacencyList.put(1, new ArrayList<Integer>() {{ add(2); add(3); add(4); }});


        Set<Integer> visited = new HashSet<>();
        int count=0;
        for (Integer node : adjacencyList.keySet()){
            if(!visited.contains(node)) {
                int no = countNodesInComponentInGraph(adjacencyList, node, visited);
                count=Math.max(count, no);
            }
        }

        System.out.println("max no in largest component = "+ count);

    }

    private static int countNodesInComponentInGraph(Map<Integer, List<Integer>> graphStore, Integer node, Set<Integer> visited) {
        visited.add(node);

        int count = 1;  // init size before going to recursive

        for (Integer n:graphStore.get(node)){
            if(!visited.contains(n)) {
               count += countNodesInComponentInGraph(graphStore, n, visited);   // add all nodes
            }
        }
        return count;  // returns the first count after all recursive calls

    }


}
