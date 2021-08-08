package graph;

import java.util.*;

/**
 * @Problem == Find a path between two nodes in a directed graph , if found return true else false
 *
 *            Note - graph is acyclic means contains no cycle
 *
 * @Complexity == Time - O(e) , space - O(n) , where e = no of edges , n = no of nodes
 *
 * @author Saurabh Vaish
 * @Date 05-08-2021
 */
public class HasPathInDirectedGraph {


    public boolean findPathUsingDfsRecursion(Map<String, List<String>> graph,String source,String des){
        if(source.equals(des))return true;

        for (String e:graph.get(source)){
            if(findPathUsingDfsRecursion(graph, e, des))return true;  // if matches return true else iterate
        }
        return false;
    }

    public boolean findPathUsingBfsRecursion(Map<String, List<String>> graph,String source,String des){
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        return _bfs(queue, graph, des);
    }

    private boolean _bfs(Queue<String> queue,Map<String, List<String>> graph,String des){
        String el = queue.poll();
        if(el!=null) {
            if (el.equals(des)) return true;
            queue.addAll(graph.get(el));
            return _bfs(queue, graph, des);
        }
        return false;
    }



    public static void main(String[] args) {
        HasPathInDirectedGraph path = new HasPathInDirectedGraph();

        Map<String, List<String>> graphStore = new HashMap<>();
        graphStore.put("f", Arrays.asList("g","i"));
        graphStore.put("g", Arrays.asList("h"));
        graphStore.put("i", Arrays.asList("k","g"));
        graphStore.put("j", Arrays.asList("i"));
        graphStore.put("k", Collections.EMPTY_LIST);
        graphStore.put("h", Collections.EMPTY_LIST);


        String source = "g"; //f ,g
        String des = "k";   // k ,j

        boolean exist =  path.findPathUsingDfsRecursion(graphStore, source,des);

//        System.out.println("path exist between "+source +" and "+des +" = "+exist);
        System.out.printf("path exist between %s and %s = %s",source,des,exist);

        boolean existUsingBfs = path.findPathUsingBfsRecursion(graphStore, source, des);
        System.out.printf("\npath exist between %s and %s = %s",source,des,existUsingBfs);

    }
}
