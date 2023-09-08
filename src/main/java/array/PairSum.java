package array;

import CtCILibrary.AssortedMethods;

import java.util.*;

/**
 * https://www.codingninjas.com/studio/problems/pair-sum_697295?leftPanelTab=0
 *
 * In a given array and a target K find the sub arrays pairs whose sum is equal to K ,
 * each pair should be sorted and return the result in non-decreasing order
 *
 * @Author saurabh vaish
 * @Date 07-09-2023
 */
public class PairSum {

    public static void main(String[] args) {
//        int ar[] = {2,3,1,4,5};
        int ar[] = {2,-6, 2, 5, 2 };

        int k = 4; //5

        pairSumArraysUsingSorting(ar,k).forEach(a-> AssortedMethods.printIntArray(a));
        System.out.println("=============");
        pairSumArraysUsingSortingAndHashing(ar,k).forEach(a-> AssortedMethods.printIntArray(a));
        System.out.println("=============");
        pairSumArrays(ar,k).forEach(a-> AssortedMethods.printIntArray(a));
        System.out.println("=============");
        pairSumArraysOptimalHashing(ar,k).forEach(a-> AssortedMethods.printIntArray(a));
    }

    // using sorting
    // Complexity == O(n ^ 2) + O( n log n), = O(n2 logN) , space = 1
    private static List<int[]> pairSumArraysUsingSorting(int[] ar, int k) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < ar.length-1; i++) {
            for (int j = i+1; j < ar.length; j++) {
                if(ar[i]+ar[j]==k){
                    int sum[] = new int[2];
                    sum[0]=Math.min(ar[i],ar[j]);
                    sum[1]=Math.max(ar[i],ar[j]);
                    list.add(sum);
                }
            }
        }

        Collections.sort(list, Comparator.comparingInt(a -> a[0]));
        return  list;
    }

    /// all these will not work as they will not allow duplicate

    // using sorting + hashing
    // Complexity == O(n ) + O(log n), = O(n + logN)  , space = O(n)
    private static List<int[]> pairSumArraysUsingSortingAndHashing(int[] ar, int k) {
        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < ar.length; i++) {
            int otherNum = k-ar[i];
            if(set.contains(otherNum)){
                int sum[] = new int[2];
                sum[0]=Math.min(ar[i],otherNum);
                sum[1]=Math.max(ar[i],otherNum);
                list.add(sum);
            }else {
                set.add(ar[i]);
            }
        }

        Collections.sort(list, Comparator.comparingInt(a -> a[0]));
        return  list;
    }


    // using treeset
    // Complexity == O(n ^ 2) + O( log n), = O(n2) , space = 1
    private static List<int[]> pairSumArrays(int[] ar, int k) {
        Set<int[]> list = new TreeSet<>((a,b)->a[0]-b[0]);

        for (int i = 0; i < ar.length-1; i++) {
            for (int j = i+1; j < ar.length; j++) {
                if(ar[i]+ar[j]==k){
                    int sum[] = new int[2];
                    sum[0]=Math.min(ar[i],ar[j]);
                    sum[1]=Math.max(ar[i],ar[j]);
                    list.add(sum);
                }
            }
        }

        return new ArrayList<>(list);
    }

    // using hashing
    // complexity = O(1) + O(N) + O(log N)  == O(N) , space = O(N)
    private static List<int[]> pairSumArraysOptimalHashing(int[] ar, int k) {
        Set<int[]> list = new TreeSet<>((a,b)->a[0]-b[0]);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < ar.length; i++) {
            int otherNum = k-ar[i];
                if(set.contains(otherNum)){
                    int sum[] = new int[2];
                    sum[0]=Math.min(ar[i],otherNum);
                    sum[1]=Math.max(ar[i],otherNum);
                    list.add(sum);
                }else {
                    set.add(ar[i]);
            }
        }

        return new ArrayList<>(list);
    }

}
