package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem == Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * @Author saurabh vaish
 * @Date 06-09-2022
 */
public class MaximumSumInContiguousSubArray {

    public static void main(String[] args) {
        int [] ar = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSumBruteForce(ar));

        System.out.println(maxSumOptimalKadanesAlgo(ar));

        System.out.println(maxSubArrayOptimal2(ar));
    }

    static int maxSubArrayOptimal2(int [] ar) {
        // Initialize using first element of the array
        int currentSubArray = ar[0];
        int maxSubArray = ar[0];
        // Start with the second element in the array since we already used the first element
        for (int i = 1; i < ar.length; i++) {
            int num = ar[i]; // get current element
            currentSubArray +=num;   // current sub array sum with current num

            // get max of current num and sub array
            currentSubArray = Math.max(num, currentSubArray);  // if current is more then ignore all prev sum
            maxSubArray = Math.max(maxSubArray, currentSubArray); // compare with max and current
        }
        return maxSubArray;
    }

    // O(N)
    // O(1)
    // with the kadanes algo we can get sum in lenear time , as we need to find sum in contiguous subarray
    // so we will keep track of sum of elements as soon as we get sum greater replace with max
    // and if sum is lesser than zero then make it equal to 0 as we are searching for max
    static int maxSumOptimalKadanesAlgo(int [] ar){
        int max=Integer.MIN_VALUE;
        int sum=0;

        for (int i = 0; i < ar.length; i++) {
            sum+=ar[i];

            if(sum>max){
                max=sum; // if sum is greater assign max
            }

            if(sum<0){ // is sum is less than zero then make it 0 as we are finding max
                sum=0;
            }
        }

        return max;
    }


    // O( n*n)
    // O(1)
    static int maxSumBruteForce(int [] ar){
        int max=Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>(); // for sub array

        for (int i = 0; i < ar.length; i++) {
            int sum=0;  // initialize everytime i is changing
            for (int j = i; j < ar.length; j++) {
                sum+=ar[j];   // adding sum
                if(sum>=max){
                    list.clear();
                    max=sum;  // if sum is greater means we have max sum
                    list.add(i);
                    list.add(j);
                }
            }
        }

        // printing subarray of max sum
        for (int i = list.get(0); i <=list.get(1) ; i++) {
            System.out.print(ar[i]+" ");
        }
        System.out.println();
        return max;
    }

}
