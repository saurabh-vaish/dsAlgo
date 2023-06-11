package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Problem == In a given array , find the numbers whose sum if equal to target sum
 *
 * @Author saurabh vaish
 * @Date 04-09-2022
 */
public class Array2Sum {

    public static void main(String[] args) {
        int [] ar = {2,7,11,15}; int k = 22;
//        int [] ar = {3,2,4}; int k = 6;
//        int [] ar = {3,3}; int k = 6;
        System.out.println(Arrays.toString(twoSum(ar,k)));

        System.out.println(Arrays.toString(twoSumUsingTwoPointer(ar,k)));
    }

    // O(N) [ both ]
    // we will use a map for this solution
    // first we will look for target and try to search the target in map
    static int[] twoSum(int [] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null){
                return new int[]{map.get(nums[i]),nums[i]};  // if target found return from map
            }else{
                int tnum = k-nums[i]; // get target
                map.put(tnum, nums[i]);  // put in map
            }
        }
        return new int[0];
    }


    // Complexity -- O(N * logN)  , logN for sorting
    // O(N)
    static int [] twoSumUsingTwoPointer(int [] nums,int k){

        Arrays.sort(nums); // sorting array so that we can have numbers in order

        int n = nums.length;
        int left=0;
        int right = n-1;

        while (left<right){
            int sum=nums[left] + nums[right]; // getting sum

            if(sum==k){ // if sum is equal to target then return the numbers on left and right
                return new int[]{nums[left],nums[right]};
            } else if (sum<k) { // if sum is less means we need to go to right as max is on right
                left++;
            }else {         // if sum is more than target means we need to reduce to move throught left
                right--;
            }
        }
        return new int[2];
    }

}
