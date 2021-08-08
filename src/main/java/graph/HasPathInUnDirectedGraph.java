package graph;

import java.util.*;

/**
 * @Problem == Find a path between two nodes in a un-directed graph , if found return true else false
 *
 *            Note - graph is undirected means it may have cycles
 *                   We have to avoid these cycles by marking them as visited
 *
 *              --- For marking node visited we can do by two methods --- 1.  By taking node class      2. by using set
 *
 * @Complexity == Time - O(e) , space - O(n) , where e = no of edges , n = no of nodes
 *
 * @author Saurabh Vaish
 * @Date 05-08-2021
 */
public class HasPathInUnDirectedGraph {


    public boolean findPathUsingDfsRecursion(Map<String, List<String>> graph,String source,String des,Set<String> set){
        if(source.equals(des))return true;
        if(set.contains(source))return false; // checking if set is having nodes means visited

        set.add(source); // making node as visited to resolve cycle problem , means it will not traverse to same node again

        if(!graph.containsKey(source))return false; // means the given node is not in graph

        for (String e:graph.get(source)){
            if(findPathUsingDfsRecursion(graph, e, des,set))return true;  // if matches return true else iterate
        }
        return false;
    }

    public boolean findPathUsingBfsRecursion(Map<String, List<String>> graph,String source,String des){
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        return _bfs(queue, graph, des,new HashSet<>());
    }

    private boolean _bfs(Queue<String> queue,Map<String, List<String>> graph,String des,Set<String> set){
        String el = queue.poll();

        if(set.contains(el))return false; // checking if set is having nodes means visited

        set.add(el); // making node as visited to resolve cycle problem , means it will not traverse to same node again

        if(el!=null) {
            if (el.equals(des)) return true;
            queue.addAll(graph.get(el));
            return _bfs(queue, graph, des,set);
        }
        return false;
    }



    public static void main(String[] args) {
        HasPathInUnDirectedGraph path = new HasPathInUnDirectedGraph();

        // given list of edges in graph
        String [][]ar = {{"i","j"},{"k","i"},{"m","k"},{"k","l"},{"o","n"}};
        String source = "i"; //i ,o
        String des = "n";   // l ,n

        // first we need to have adjacency list from this array to represent graph
        Map<String, List<String>> graphStore = path.getGraph(ar);


        boolean exist =  path.findPathUsingDfsRecursion(graphStore, source,des,new HashSet<>());

        System.out.printf("path exist between %s and %s using DFS = %s",source,des,exist);
//
        boolean existUsingBfs = path.findPathUsingBfsRecursion(graphStore, source, des);
        System.out.printf("\npath exist between %s and %s using BFS = %s",source,des,existUsingBfs);

    }

    private  Map<String, List<String>> getGraph(String[][] ar) {
        Map<String, List<String>> graphStore = new HashMap<>();
        for (String[] a:ar){                            // get edges from array
            this.storeInMap(graphStore, a[0],a[1]);     // since its undirected graph so there will be path from both the nodes to each other
            this.storeInMap(graphStore, a[1],a[0]);     // so storing path from other node to previous one
        }
        return graphStore;
    }

    private void storeInMap(Map<String, List<String>> map,String key,String value){
        if(map.containsKey(key)){
            List<String> list = map.get(key);
            list.add(value);
            map.put(key, list);
        }else{
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
}
