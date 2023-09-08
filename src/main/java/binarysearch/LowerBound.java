package binarysearch;

/**
 * @Link =https://www.codingninjas.com/codestudio/problems/lower-bound_8165382
 *
 * find the lower bound of element x , the lower bound is defined as smallest index as possible as at which arr[indx] is not less than x
 *  i.e. lower_bound = arr[ind] >=x ,
 *
 * @Author saurabh vaish
 * @Date 10-06-2023
 */
public class LowerBound {

    public static void main(String[] args) {
//        int[] arr = {10,20,30,40,50};
        int[] arr = {10,20,25,25,30,40,50};
        int x = 25;

        int ind = lower_bound(arr,x,arr.length);

        System.out.println("lower bound of x == "+ind);

        int ind2 = lower_bound_recursion(arr,x,arr.length,0,arr.length-1);

        System.out.println("lower bound of x recursive== "+ind2);

    }

    // complexity == log(n)
    private static int lower_bound(int[] arr, int x, int length) {
        int low = 0, high = length-1;
        int ans=length; // if LB not found for an element then it will be length of array

        while (low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>=x){
                ans = mid;
                high=mid-1;
            }
            else{
                low = mid+1; // as we need to look greater numbers
            }
        }

        return ans;
    }


    private static int lower_bound_recursion(int[] arr, int x, int ans,int low,int high) {
        if (low > high) return ans;

        int mid = low + (high - low) / 2;

        return (arr[mid] >= x) ? lower_bound_recursion(arr, x, mid, low, mid - 1) : lower_bound_recursion(arr, x, ans, mid + 1, high);
    }
}
