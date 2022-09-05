package array.slidingWindow;

/**
 *
 * @Problem = Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous sub array whose sum is greater than or equal to ‘S’. Return 0, if no such sub array exists.
 *
 * @Author saurabh vaish
 * @Date 21-06-2022
 */
public class SmallestSubArrayGivenSum {

    public static void main(String[] args) {

        int [] ar =new int[]{2,1,5,2,3,2};
        int s=7;

        System.out.println(smallestSubArrayCount(ar,s));
    }

    private static int smallestSubArrayCount(int[] ar, int s) {

        int count =0;
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum +=ar[i];

            while (sum>=s){

            }

            if(sum>=s)count++;
        }
        return count;
    }
}
