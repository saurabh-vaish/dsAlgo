package graph;

import java.util.*;

/**
 * @Problem == In a given set of edges find the shortest path from source to destination , return -1 if not possible
 *
 * @Complexity -
 *
 * @author Saurabh Vaish
 * @Date 08-08-2021
 */

class Node{
    public String value;
    public int distance;

    public Node(String value,int distance){
        this.value=value;
        this.distance=distance;
    }
}

public class ShortestPathInGraphComponents {

    public int getShortestPath(Map<String,List<Node>> graph,String source,String des){
        Node node = new Node(source, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<String> visited = new HashSet<>();
        visited.add(node.value);
        return bfs(queue,graph,des,visited);
    }

    private int bfs(Queue<Node> queue, Map<String, List<Node>> graph, String des, Set<String> visited) {
        Node curr = queue.poll();  // getting current element
        if(curr!=null) {
            if(curr.value.equals(des))return curr.distance;  // if source and des are matched then return distance
            if(graph.get(curr.value)!=null) {
                for (Node nei : graph.get(curr.value)) {   // getting all neighbours
                    if (!visited.contains(nei.value)) {    //  preventing cycle
                        nei.distance+=curr.distance+1;    // update distance as we are moving towards des
                        visited.add(nei.value);
                        queue.add(nei);                     // adding in queue
                    }
                }
            }
           return bfs(queue, graph, des, visited);
        }
        return -1;
    }


    public static void main(String[] args) {
        ShortestPathInGraphComponents graph = new ShortestPathInGraphComponents();

//        String[][] edges ={{"w","x"},{"x","y"},{"z","y"},{"z","v"},{"w","v"}};
//        String[][] edges ={{"m", "n"}, {"n", "o"}, {"o", "p"}, {"p", "q"}, {"t", "o"}, {"r", "q"}, {"r", "s"}};
        String[][] edges ={{"a", "c"}, {"a", "b"}, {"c", "b"}, {"c", "d"}, {"b", "d"}, {"e", "d"}, {"g", "f"}};

        String source = "b"; //w , m
        String des = "g";  // z, s

        Map<String, List<Node>> graphStore = graph.getGraph(edges);

        int path = graph.getShortestPath(graphStore, source, des);

        System.out.println("Shortest path = "+path);


    }

    private Map<String, List<Node>> getGraph(String[][] ar) {
        Map<String, List<Node>> graphStore = new HashMap<>();
        for (String[] a:ar){                            // get edges from array
            this.storeInMap(graphStore, a[0],a[1]);     // since its undirected graph so there will be path from both the nodes to each other
            this.storeInMap(graphStore, a[1],a[0]);     // so storing path from other node to previous one
        }
        return graphStore;
    }

    private void storeInMap(Map<String, List<Node>> map,String key,String value){
        if(map.containsKey(key)){
            List<Node> list = map.get(key);
            list.add(new Node(value,0));
            map.put(key, list);
        }else{
            List<Node> list = new ArrayList<>();
            list.add(new Node(value,0));
            map.put(key, list);
        }
    }
}
