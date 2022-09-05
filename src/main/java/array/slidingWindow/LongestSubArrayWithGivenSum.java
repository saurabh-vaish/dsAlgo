package array.slidingWindow;

/**
 * @Problem  = Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
 *
 * @Author saurabh vaish
 * @Date 04-09-2022
 */
public class LongestSubArrayWithGivenSum { // incomplete

    public static void main(String[] args) {
        int [] arr = {7,1,6,0};
        int k = 7;

        System.out.println(usingBruteForce(arr,k));
    }

    static int optimalUsingSlidingWindow(int[] ar,int k){
        int maxLength = 0;
        int sum=0;
        for (int i = 0; i < ar.length; i++) {
            sum+=ar[i];
            if(ar[i]>k)continue;

        }

        return 0;
    }


    static int usingBruteForce(int [] ar,int k){
        int maxLength=0;
        for (int i = 0; i < ar.length; i++) {
            int sum=0;
            for (int j = i; j < ar.length; j++) {
                sum+=ar[j];
                if(sum==k){ // if target is equal to sum
                    maxLength = Math.max(maxLength,j-i+1);  // getting max length , from i to farthest j , +1 as starting from 0
                }
            }
        }
        return maxLength;
    }

}
