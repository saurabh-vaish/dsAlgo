package slidingWindow;

import java.util.Arrays;

/**
 *
 * @Problem == Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *
 * @Complexity - BruteForce - O(N * K) , sliding window - O(N)
 *
 * @Author saurabh vaish
 * @Date 21-06-2022
 */
public class AverageSumSubArray {

    public static void main(String[] args) {

        int [] ar = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int winSize = 5;

        double [] brfOpt = avgSumUsingBruteForce(ar,winSize);
        System.out.println(Arrays.toString(brfOpt));

        double [] slingWindowOpt = avgSumUsingSlidingWindow(ar,winSize);
        System.out.println(Arrays.toString(brfOpt));

    }

    // using sliding window approach 
    // first loop till len - k 
    // in second loop calculate sum and store avg in array
    // time - O(N )
    // space - O( K )
    private static double[] avgSumUsingSlidingWindow(int[] ar,int k) {
        double [] opt = new double[ar.length-k+1]; // there could be ar.length-k subarray for sum

        double sum=0; // for temp sum
        int winStart=0; // variable to track window start point

        for (int i = 0; i < ar.length; i++) { // loop till array
            sum +=ar[i]; // calculate sum

            if(i>=k-1){  // if true means we reached window
                opt[winStart] = sum/k; // get sum of the window

                sum -=ar[winStart]; // remove first index sum as we are moving window
                winStart++; // increase track
            }
        }

        return opt;
    }


    // using bruteforce approach 
    // first loop till len - k 
    // in second loop calculate sum and store avg in array
    // time - O(N * K )
    // space - O( K )
    private static double[] avgSumUsingBruteForce(int[] ar,int k) {
        double [] opt = new double[ar.length-k+1]; // there could be ar.length-k sub array for sum

        for (int i = 0; i <= ar.length-k; i++) {
            double sum=0;
            for (int j = i; j < i+k; j++) {
                sum += ar[j];
            }
            opt[i]=sum/k;
        }

        return opt;
    }
}
