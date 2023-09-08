package binarysearch;

/**
 * @Link = https://www.codingninjas.com/studio/problems/smallest-divisor-with-the-given-limit_1755882
 *
 * Find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result
 * is less than or equal to the given integer's limit.
 *
 * @Author saurabh vaish
 * @Date 06-07-2023
 */
public class SmallestDivisor {


    // O( max * n) , O(1)
    // we have to find the smallest no that when it divides array elements the sum of divison is not more than limit
    // we can start with from 1 to max no in array
    // this is our ans range
    public static int smallestDivisor(int arr[], int limit) {
        // Write your coder here
        int low = 1; int high = Integer.MIN_VALUE;

        for(int ar:arr){
            high = Math.max(high,ar);
        }

        int ans = -1;

        // binary search on ans range
        while(low<=high){
            int mid = low + (high-low)/2;

            if(divisorSum(mid,arr)<=limit){
                high = mid-1;  // as we need to find the minimum
                ans = mid;
            }else{
                low= mid+1;
            }

        }

        return ans;
    }

    // O(n)
    private static int divisorSum(int mid,int [] arr) {
        int sum=0;
        for(int ar:arr){
            sum += Math.ceil((double) ar /mid);
        }

        return sum;
    }

    public static void main(String[] args) {
        int ar[] = {2,3,5,7,11};
        int l = 11;

        System.out.println(smallestDivisor(ar,l));
    }
}
