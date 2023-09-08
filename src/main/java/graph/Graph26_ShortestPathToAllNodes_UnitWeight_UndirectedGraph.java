package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * In given undirected graph where the weight is unit on each edge , find the shortest path on each vertex
 * We can not use Topo sort as it is not directed
 * We are not using other algo like dijestra as weight is unit
 * We can use simple BFS to do this , as we will traverse and count the weight from source
 *
 *
 * @Author saurabh vaish
 * @Date 03-08-2023
 */
public class Graph26_ShortestPathToAllNodes_UnitWeight_UndirectedGraph {

    // Comp = same as bfs , O(N + 2E)
    // we are using bfs to calculate shortest path between vertex
    // first create adjacency matrix then do bfs and will calculate path along with traversal
    // here instead of visited array will use sort [] itself
    public static int[] shortestPath(int n,int m,int s, int t,int [][] edge){

        // adjacency list
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = edge[i][0];
            int v = edge[i][1];

            // as they are undirected so from both side
            list.get(u).add(v);
            list.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(s);  // source

        int sort [] = new int[m+1];
        Arrays.fill(sort,(int)1e9);
        sort[s]=0;

        while (!q.isEmpty()){
            Integer node = q.poll();

            for(Integer it:list.get(node)){
                if(sort[node]+1 < sort[it]){
                    sort[it]= 1 + sort[node];
                    q.offer(it);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(sort[i]==(int)1e9){
                sort[i]=-1;
            }
        }

        return sort;
    }

    public static void main(String[] args) {
        int n=4, m =4, s=1, t =4;

        int [][] ar = {{1,2},{2,3},{3,4},{1,3}};

        System.out.println(Arrays.toString(shortestPath(n,m,s,t,ar)));
    }

}
