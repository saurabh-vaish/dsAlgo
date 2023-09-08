package tree;

import java.util.ArrayList;

/**
 * https://www.codingninjas.com/studio/problems/conquer-the-best-kingdom_2689306
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class Tree_ConquorBestKingdom {

    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{4,6},{2,0},{0,1}};
        int n=7, x =2;

        System.out.println(conquer(edges,n,x));
    }

    private static boolean conquer(int [][] edges,int n,int x){
        ArrayList<ArrayList<Integer>> list = getAdjacentNodes(edges,n);

        int max=0;

        int [] vis = new int[n];

        for (Integer node : list.get(x)){
            int [] cnt = new int[1];

            dfs(node,list,vis,cnt);

            max = Math.max(max,cnt[0]);
        }

        if((2 * max) < n)return true;

        return false;
    }

    private static void dfs(Integer node,ArrayList<ArrayList<Integer>> adjList, int[] vis, int[] cnt) {
        vis[node]=1;
        cnt[0]++;

        for (Integer adj:adjList.get(node)){
            if(vis[adj]==0){
                dfs(adj,adjList,vis,cnt);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> getAdjacentNodes(int[][] edges,int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for (int i=0;i<n;i++)list.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        return list;
    }
}
