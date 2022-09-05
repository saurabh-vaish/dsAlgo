package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Problem == In a given array , find the index of numbers whose sum if equal to target sum
 *
 * @Author saurabh vaish
 * @Date 04-09-2022
 */
public class Array2SumIndex {

    public static void main(String[] args) {
        int [] ar = {2,7,11,15}; int k = 22;
//        int [] ar = {3,2,4}; int k = 6;
//        int [] ar = {3,3}; int k = 6;
        System.out.println(Arrays.toString(twoSum(ar,k)));

        System.out.println(Arrays.toString(twoSumUsingTwoPointer(ar,k)));
    }

    // O(N)
    // we will use a map for this solution
    // first we will look for target and try to search the target in map
    static int[] twoSum(int [] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null){
                return new int[]{map.get(nums[i]),i};  // if target found return from map
            }else{
                int tnum = k-nums[i]; // get target
                map.put(tnum, i);  // put in map
            }
        }
        return new int[0];
    }


    // Complexity -- O(N * logN)
    // O(N)
    static int [] twoSumUsingTwoPointer(int [] nums,int k){
        int n = nums.length;
        int[][] arr = new int[n][2]; // 2D array for both indices

        for (int i = 0; i < n; ++i) {
            arr[i][0] = nums[i];  // number
            arr[i][1] = i;  // index
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0])); // Sort arr in increasing order by their values.

        int left = 0, right = n - 1;
        while (left < right) {
            int sum2 = arr[left][0] + arr[right][0];  // values sum
            if (sum2 == k)
                return new int[]{arr[left][1], arr[right][1]};   // return index
            if (sum2 > k)
                right -= 1; // Try to decrease sum2
            else
                left += 1; // Try to increase sum2
        }
        return new int[]{};
    }

}
