package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Link = https://www.codingninjas.com/studio/problems/course-schedule_985288?leftPanelTab=0
 *
 * You are a student of Netaji Subhas Institute of Technology. You have to take ‘N’ number of courses labelled from 1 to N to complete your B.Tech Degree.
 *Some courses may have prerequisites, for example, to take course 1 you have to first take course 2, which is expressed as a pair: [1, 2].
 * Now, your task is to find is it possible for you to finish all courses.
 *
 * We have to check if all task can be finished means we have to write task in such a way that if every dependent task if before from actual task.
 * Its the similat as topological sort as we have to check if it can be written in topo sort order
 * Means there should be directed and acyclic graph , as it is direction we have pair where one is dependent on another
 * we need to find it there is any cycle , if yes return false as it can not be written in topo order
 *
 *
 * @Author saurabh vaish
 * @Date 26-07-2023
 */
public class Graph21_Course_Scheduler_1 {

    public static int getMaxMarker(ArrayList<ArrayList<Integer>> pair, int n, int m) {
        //	Write your code here.

        // first we need adjacency matrix
        ArrayList<ArrayList<Integer>> adj = adjacencyList(pair,n);

        int [] indegree = new int[n+1];

        for(int i=0;i<n;i++){
            for(Integer it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){  // adding on degree 0 as they have no inbound edges
                q.add(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            Integer node = q.poll();
            list.add(node);

            for(Integer it:adj.get(node)){
                indegree[it]--; // decrease degree as already traversed
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        if(list.size()==n)return 1; // as topological sort and course size same so its possible to complete all course
        return 0;

    }

    private static ArrayList<ArrayList<Integer>> adjacencyList(ArrayList<ArrayList<Integer>> pair, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<pair.size();i++){
            list.get(pair.get(i).get(0)).add(pair.get(i).get(1));
        }

        return list;
    }

    public static void main(String[] args) {
//        int mat [][] = {{1,2},{2,1}}; // no as cycle present
//        int n=3, m=2;

        int mat [][] = {{1,0},{2,1},{3,2}}; // yes as no cycle present
        int n=4, m=3;


        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int[] row : mat) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int item : row) {
                innerList.add(item);
            }
            arrayList.add(innerList);
        }

        System.out.println(getMaxMarker(arrayList,n,m));
    }

}
