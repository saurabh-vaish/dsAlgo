package binarysearch;

/**
 * @Link =https://www.codingninjas.com/codestudio/problems/implement-upper-bound_8165383
 *
 * find the upper bound of element x , the lower bound is defined as index which is as smallest as possible at which arr[indx] is greater than x
 *  i.e. upper_bound = arr[ind] > x
 *
 * @Author saurabh vaish
 * @Date 10-06-2023
 */
public class UpperBound {

    public static void main(String[] args) {
//        int[] arr = {10,20,30,40,50};
        int[] arr = {10,20,25,25,30,40,50};
        int x = 25;

        int ind = upper_bound(arr,x,arr.length);

        System.out.println("lower bound of x == "+ind);

        int ind2 = upper_bound_recursion(arr,x,arr.length,0,arr.length-1);

        System.out.println("upper bound of x recursive== "+ind2);

    }

    // complexity == log(n)
    private static int upper_bound(int[] arr, int x, int length) {
        int low = 0, high = length-1;
        int ans=length; // if LB not found for an element then it will be length of array

        while (low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>x){
                ans = mid;
                high=mid-1;
            }
            else{
                low = mid+1; // as we need to look greater numbers
            }
        }

        return ans;
    }


    private static int upper_bound_recursion(int[] arr, int x, int ans, int low, int high) {
        if (low > high) return ans;

        int mid = low + (high - low) / 2;

        return (arr[mid] > x) ? upper_bound_recursion(arr, x, mid, low, mid - 1) : upper_bound_recursion(arr, x, ans, mid + 1, high);
    }
}
