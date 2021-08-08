package graph;

import java.util.*;

/**
 * incomplete
 *
 * @Problem == In undirected graph count the no of connected components .
 *
 * @Solution -- iterate through all nodes and mark them visited , if not visited then visited all neighbours using dfs.
 *
 * @author Saurabh Vaish
 * @Date 07-08-2021
 */
public class CountNoOfEdges {

    public static void main(String[] args) {

        CountNoOfEdges path = new CountNoOfEdges();

//        Map<String, List<String>> graphStore = new HashMap<>();
//        graphStore.put("f", Arrays.asList("g","i"));
//        graphStore.put("g", Arrays.asList("h"));
//        graphStore.put("i", Arrays.asList("k","g"));
//        graphStore.put("j", Arrays.asList("i"));
//        graphStore.put("k", Collections.EMPTY_LIST);
//        graphStore.put("h", Collections.EMPTY_LIST);

        Map<String, List<String>> directed = new HashMap<>();
        directed.put("a", Arrays.asList("b","c")); // a is connected with b and c
        directed.put("b", Arrays.asList("d")); // b is connected with  d
        directed.put("c", Arrays.asList("e"));    //  c is connected with e
        directed.put("d", Arrays.asList("f"));    // d is connected with f
        directed.put("e", Collections.EMPTY_LIST); //  e is not connected , c ,b are connected with e
        directed.put("f", Collections.EMPTY_LIST);  // f is not connected , d connected to f

        System.out.println("no of edges in directed graph = "+path.noOfEdgesInGraph(directed));

        Map<String, List<String>> unDirected = new HashMap<>();
        unDirected.put("i", Arrays.asList("j","k"));
        unDirected.put("j", Arrays.asList("i"));
        unDirected.put("k", Arrays.asList("i","m","l"));
        unDirected.put("l", Arrays.asList("k"));
        unDirected.put("m", Arrays.asList("k"));
        unDirected.put("n", Arrays.asList("o"));
        unDirected.put("o", Arrays.asList("n"));

        System.out.println("no of edges in un-directed graph = "+path.noOfEdgesInGraph(unDirected));

    }

    private Long noOfEdgesInGraph(Map<String, List<String>> graph){
        return graph.values().stream().mapToLong(List::size).sum();
    }



}
