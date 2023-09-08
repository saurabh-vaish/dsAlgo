package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class LongestSubArrayWithGivenSumK {

    public static void main(String[] args) {
         int [] ar = {1, 2, 3, 1, 1, 1, 1};
         int k =3;

        System.out.println(longestSubarrayWithSumKBruteForce(ar,k));
        System.out.println(longestSubarrayWithSumKHashing(ar,k));
        System.out.println(longestSubarrayWithSumKTwoPointer(ar,k));
    }


    // complexity == O(N^2) ,space = O(1)
    public static int longestSubarrayWithSumKBruteForce(int []a, long k) {
        int maxLen = 0;
        long sum=0;
        for (int i = 0; i < a.length; i++) {
            sum =0 ;
            for (int j = i; j < a.length; j++) {
                sum+=a[j];  // sum of all sub array from i position to array len

                if(sum==k){
                    maxLen = Math.max(maxLen,(j-i)+1); // +1 as index is starting from 0
                }
            }
        }

        return maxLen;
    }


    // complexity == O(N) ,space = O(N)
    // this solution only works for both positive and negative numbers
    public static int longestSubarrayWithSumKHashing(int []a, long k) {
        int maxLen = 0;
        long sum=0;
        Map<Long,Integer> map = new HashMap<>();  // map of rem and index

        for (int i = 0; i < a.length; i++) {
            sum +=a[i];

            if(sum==k){
                maxLen = Math.max(maxLen,i+1); // +1 as index is starting from 0
            }

            long rem = sum-k;

            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen,len);
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }

        return maxLen;
    }

    // complexity == O(2 * N) ,space = O(1)
    public static int longestSubarrayWithSumKTwoPointer(int []a, long k) {
        int maxLen = 0;
        long sum= a[0];
        int start =0 , end= 0;

        while (end < a.length){

            // if sum if greater than k then reducing left sub array part
            // and moving towards right
            while (sum > k && start<=end){
                sum -=a[start];
                start++;
            }

            if(sum==k){
                maxLen = Math.max(maxLen,end-start+1);
            }

            end++;
            if(end < a.length){  // moving right to the end
                sum+=a[end];
            }

        }

        return maxLen;
    }

}
