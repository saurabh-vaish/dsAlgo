package array.slidingWindow;

/**
 *
 * @Problem = Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 *
 * @Solution = we can solve this problem using bruteforce but it will take O( N * K) , so we will use sliding window approach to solve this problem in O(N)
 *
 *
 * @Author saurabh vaish
 * @Date 21-06-2022
 */
public class MaxSumSubArray {

    public static void main(String[] args) {

//        int [] ar = new int[]{2,1,5,1,3,2}; //9
        int [] ar = new int[]{2,3,4,1,5};
        int k =3;

        System.out.println(maxSumSlidingWindow(ar,k));
        System.out.println(maxSumBruteForce(ar,k));

    }

    // using sliding window approach as brute force will take O ( N * K)
    // time - O( N ) , space - O( 1 )
    private static int maxSumSlidingWindow(int[] ar, int k) {

        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        int windowStart=0;
        for (int i = 0; i < ar.length; i++) {
            sum +=ar[i];

            if(i>=k-1){
                maxSum = Math.max(maxSum,sum); // getting max sum
                sum = sum - ar[windowStart]; // when reached window size remove start position as we are moving window
                windowStart++;  // increase window start position
            }
        }
        return maxSum;
    }


    // using brute force
    // time - O( N * K ) , space - O( 1 )
    private static int maxSumBruteForce(int[] ar, int k) {
        int maxSum=0;
        for (int i = 0; i <= ar.length-k; i++) {
            int sum =0 ;
            for (int j = i; j < i+k; j++) {
                sum+=ar[j];
            }
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
}
