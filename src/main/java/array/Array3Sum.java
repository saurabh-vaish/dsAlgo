package array;

import java.util.*;

/**
 *
 * @Problem  == Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
 *              In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.
 *
 * @Author saurabh vaish
 * @Date 04-09-2022
 */
public class Array3Sum {

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};  // [[-1, 2, -1], [0, 1, -1]]
//        int [] nums = {0,1,1};  // []
//        int [] nums = {0,0,0};  // [0,0,0]


        System.out.println(optionalUsingTwoPointers(nums));
        
    }

    // O(n ^ 2)
    // O(3 * k) , k = no of triplets
    static List<List<Integer>> optionalUsingTwoPointers(int [] ar) {
        List<List<Integer>> list = new ArrayList<>();

        // sorting array so that we can use two pointers effectively
        Arrays.sort(ar);

        // leaving last two as we have 3 elem to sum , so n-2 will cover last also
        for (int i = 0; i < ar.length - 2; i++) {

//            int currElem = ar[i];      // a
//            int target = -(currElem);  // b+c = -a

            // now we need to find b,c such a way that b+c = -a
            int lo = i + 1;
            int hi = ar.length - 1;

            while (lo < hi) {
                int sum = ar[i] + ar[lo] + ar[hi]; // getting sum

                if (sum == 0) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(ar[lo]);
                    ans.add(ar[hi]);
                    ans.add(ar[i]);

                    list.add(ans);

                    // skipping same elements
                    while (lo < hi && ar[lo] == ar[lo + 1]) lo++;
                    while (lo < hi && ar[hi] == ar[hi - 1]) hi--;

                    lo++;
                    hi--;
                } else if (sum > 0) { // if sum is greater means we need to reduce hi value as array is sorted so hi value from last will be greater
                    hi--;
                } else {   // if sum is leaser means we need to increase lo value as array is sorted so lo value from start will be lesser
                    lo++;
                }
            }

            // skipping same ar[i] as there will be same sum
            while (i < ar.length - 2 && ar[i] == ar[i + 1]) i++;
        }

        return list;
    }
    
}

