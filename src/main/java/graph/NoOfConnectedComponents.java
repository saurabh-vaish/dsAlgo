package graph;

import java.util.*;

/**
 *
 * @Problem == In undirected graph count the no of connected components .
 *
 * @Solution -- iterate through all nodes and mark them visited , if not visited then visited all neighbours using dfs.
 *
 * @author Saurabh Vaish
 * @Date 07-08-2021
 */
public class NoOfConnectedComponents {

    public static void main(String[] args) {

        NoOfConnectedComponents path = new NoOfConnectedComponents();

        Map<Integer, List<Integer>> graphStore = new HashMap<>();
        graphStore.put(0, Arrays.asList(8,1,5));
        graphStore.put(1, Arrays.asList(0));
        graphStore.put(5, Arrays.asList(0,8));
        graphStore.put(8, Arrays.asList(0,5));
        graphStore.put(2, Arrays.asList(3,4));
        graphStore.put(3, Arrays.asList(2,4));
        graphStore.put(4, Arrays.asList(3,2));

        Set<Integer> visited = new HashSet<>();
        int count=0;

        // iterating over all nodes as there could be un connected graphs , so it will check for all
        for (Map.Entry<Integer,List<Integer>> val:graphStore.entrySet()){
            if(visited.contains(val.getKey()))continue;
            boolean isTrue = path.countNoOfNodesInLargestComponent(graphStore, val.getKey(), visited, 0);
            if(isTrue)count++;
        }
        System.out.print("no of connected components = "+count);


        // code to print all connected componnets

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(7, new ArrayList<>());
        adjacencyList.put(5, new ArrayList<Integer>() {{ add(6); }});
        adjacencyList.put(6, new ArrayList<Integer>() {{ add(5); }});
        adjacencyList.put(2, new ArrayList<Integer>() {{ add(1); }});
        adjacencyList.put(3, new ArrayList<Integer>() {{ add(1); add(4); }});
        adjacencyList.put(4, new ArrayList<Integer>() {{ add(1); add(3); }});
        adjacencyList.put(1, new ArrayList<Integer>() {{ add(2); add(3); add(4); }});

        Set<Integer> visited2 = new HashSet<>();
        List<List<Integer>> componentList = new ArrayList<>();

        // iterating over all nodes as there could be un connected graphs , so it will check for all
        for (Map.Entry<Integer,List<Integer>> val:adjacencyList.entrySet()){
            if(!visited2.contains(val.getKey())) {
                List<Integer> list = new ArrayList<>();
                path.getComponentsUsingDfs(adjacencyList, val.getKey(), visited2, list);
                componentList.add(list);
            }
        }
        System.out.println();
        componentList.forEach(System.out::println);

    }

    private boolean countNoOfNodesInLargestComponent(Map<Integer, List<Integer>> graph, Integer source, Set<Integer> set, Integer count) {
        if(set.contains(source))return false;   // if already visited means its in connected componenet
        set.add(source);

        // exploring all neighbours
        for (Integer neigh:graph.get(source)){
            if(!set.contains(neigh)) {   // only traverse unvisited nodes
                if (countNoOfNodesInLargestComponent(graph, neigh, set, count)) return true;
            }
        }
        return true;   // returning true means all the nodes of graph has been visited , then we can assume we have traversed one graph
    }


    private void getComponentsUsingDfs(Map<Integer, List<Integer>> graph,Integer source, Set<Integer> set,List<Integer> componentList) {
        set.add(source);                // marking as visited
        componentList.add(source);     // adding to components

        // exploring all neighbours
        for (Integer neigh:graph.get(source)){
            if(!set.contains(neigh)) {   // only traverse unvisited nodes
                getComponentsUsingDfs(graph, neigh, set, componentList);
            }
        }
    }

}
