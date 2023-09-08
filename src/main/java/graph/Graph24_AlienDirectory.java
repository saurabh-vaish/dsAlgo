package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Link = https://www.codingninjas.com/studio/problems/alien-dictionary_630423
 *
 * You have been given a sorted (lexical order) dictionary of an alien language.
 * Write a function that finds the order of characters in the alien language. This dictionary will be given to you as an array of strings called directory of size n
 *
 * we are given set of strings and alphate count 3, we need to observe the order of strings in set and found out the order of alphabets
 *
 *
 * @Author saurabh vaish
 * @Date 02-08-2023
 */
public class Graph24_AlienDirectory {


    // we will compare each and every charector in string to its next string if char are not same then will compare order
    // first we need to compare strings and create a directed graph
    // then using topological sort we can get order of the alphabates
    public static char[] getAlienLanguage(int n, String[] dictionary) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i <dictionary.length-1; i++) {
            String s1 = dictionary[i];
            String s2 = dictionary[i+1];
            int len = Math.min(s1.length(),s2.length());

            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){  // chars are not same add them to list
                    list.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');  // adding edge between chars
                }
            }
        }

        ArrayList<Integer> topo = topoSort(list,n);
        char[] ch = new char[n];

        for (int i = 0; i < n; i++) {
            ch[i]=(char)(topo.get(i)+'a');
        }

        return ch;
    }


    // topo using bfs using queue
    private static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj,int n){
        ArrayList<Integer> list = new ArrayList<>();

        int [] ind = new int[n];

        for(int i=0;i<n;i++){
            for(Integer it:adj.get(i)){
                ind[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(ind[i]==0)q.add(i);
        }

        while (!q.isEmpty()){
            Integer el = q.poll();
            list.add(el);

            for(Integer it:adj.get(el)){
                ind[it]--;
                if(ind[it]==0){
                    q.add(it);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
//        String[] ar = {"caa","aaa","aab"};
        String[] ar = {"a","aa","aaa"};

        System.out.println(getAlienLanguage(1,ar));
    }

}
