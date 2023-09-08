package array;

import CtCILibrary.AssortedMethods;

import java.util.*;

/**
 * https://www.codingninjas.com/studio/problems/two-sum_839653
 *
 * In a given array and target k find all the pairs of the subarray which are having equal to k , we can't use element at same index twice
 *
 *
 * @Author saurabh vaish
 * @Date 07-09-2023
 */


class Pair<T,E>{
    T first;
    E second;

    Pair(T t ,E e){
        this.first = t;
        this.second = e;
    }

    @Override
    public String toString() {
        return first + " "+ second;
    }
}
public class Array2SumWithAllPairs {

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
//        ar.addAll(Arrays.asList(2,7,11,13));
//        int k =9;
        ar.addAll(Arrays.asList(1,-1,-1,2,2));
        int k =1;
//        ar.addAll(Arrays.asList(3,3,3,3,3,3,3,3,3,3));
//        int k =6;

        twoSumArraysUsingSorting(ar,k).forEach(System.out::println);
        System.out.println("=============");
    }

    // using sorting
    // Complexity == O(n) + O(1), = O(n) , space = O(N)
    private static ArrayList<Pair<Integer, Integer>> twoSumArraysUsingSorting(ArrayList<Integer> ar, int k) {
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

//        for (int i = 0; i < ar.size(); i++) {
//            int rem = k-ar.get(i);
//            if(map.containsKey(rem)){
//                list.add(new Pair<>(ar.get(i),rem ));
//            }
//            map.put(ar.get(i),rem);
//        }


        for (int i = 0; i < ar.size(); i++) {
            int rem = k-ar.get(i);
            if(map.containsKey(rem) && map.get(rem)+rem==k){
                list.add(new Pair<>(ar.get(i),rem ));
                map.put(rem,map.get(rem)-1); // as we have already used at this index , so will not use this key again
            }else{
                map.put(ar.get(i),rem); // if key is not present then adding it
            }
        }

        if(list.isEmpty()){
            list.add(new Pair<>(-1,-1));
        }
        return  list;
    }



}

