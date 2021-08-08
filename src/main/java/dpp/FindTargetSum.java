package dpp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Problem == Program to find the elements from a given array that matches the target sum .
 *             Can return any array of elements .
 *             if sum not exists return null
 *             extra -- try to return all arrays that gives target sum
 *
 * @author Saurabh Vaish
 * @Date 01-08-2021
 */
public class FindTargetSum {

    private static List<List<Integer>> all = new ArrayList<>();

    public static void main(String[] args) {
        int ar[] = {2,3,5};
        int targetSum = 11;

        List<Integer> sumList = findSum(ar,targetSum);
        List<Integer> sumListOp = findSumOptimized(ar,targetSum,new HashMap<>());
        System.out.println(sumList);
        System.out.println(all);
    }


    // complexity -- if n = array length and m = target sum
    // it will run n times until m so time - O(n^m * m)  here extra m times as we are adding to list
    // space = O(m)

    private static List<Integer> findSum(int[] ar, int targetSum) {
        if(targetSum==0)return new ArrayList<>();
        if(targetSum<0)return null;

        for (var a:ar){
            int re = targetSum-a;
            List<Integer> rlist = findSum(ar, re);
            if(rlist!=null) {
                rlist.add(a);
                all.add(rlist);
                return rlist;
            }
        }
        return null;
    }

    //  time - O(m*n) , space = O(m)
    private static List<Integer> findSumOptimized(int[] ar, int targetSum,HashMap<Integer,List<Integer>> map) {
        if(targetSum==0)return new ArrayList<>();
        if(targetSum<0)return null;
        if(map.containsKey(targetSum))return map.get(targetSum);

        for (var a:ar){
            int re = targetSum-a;
            List<Integer> rlist = findSumOptimized(ar, re,map);
            if(rlist!=null) {
                rlist.add(a);
                map.put(targetSum, rlist);
                return rlist;
            }
        }
        map.put(targetSum, null);
        return null;
    }
}
